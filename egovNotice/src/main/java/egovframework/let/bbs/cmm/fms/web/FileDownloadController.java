package egovframework.let.bbs.cmm.fms.web;

import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import egovframework.let.bbs.cmm.fms.service.FileMngService;
import egovframework.let.bbs.cmm.fms.vo.FileVO;

@Controller
public class FileDownloadController {

	@Resource(name = "fileMngService")
	private FileMngService fileMngService;

	/**
	 * 파일다운로드
	 */
	@RequestMapping("/cmm/fms/FileDown.do")
	public void fileDown(@RequestParam("atchFileId") String atchFileId, @RequestParam("fileSn") int fileSn,
			HttpServletResponse response) throws Exception {

		FileVO f = fileMngService.selectFileOne(atchFileId, fileSn);
		if (f == null || !"Y".equals(f.getUseAt())) {
			throw new IllegalStateException("파일이 존재하지 않습니다.");
		}

		File file = new File(f.getFileStreCours(), f.getStreFileNm());
		if (!file.exists()) {
			throw new IllegalStateException("파일이 존재하지 않습니다.");
		}

		String downloadName = encodeFilename(f.getOrignlFileNm());

		response.setContentType("application/octet-stream");
		response.setHeader("Content-Disposition", "attachment; filename=\"" + downloadName + "\"");
		response.setHeader("Content-Length", String.valueOf(file.length()));

		try (FileInputStream in = new FileInputStream(file)) {
			in.transferTo(response.getOutputStream());
		}
	}

	private String encodeFilename(String name) {
		String encoded = URLEncoder.encode(name, StandardCharsets.UTF_8);
		return encoded.replaceAll("\\+", "%20");
	}
}
