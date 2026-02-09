package egovframework.let.bbs.cmm.fms.vo;

import java.io.Serializable;

public class FileVO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String atchFileId; // ATCH_FILE_ID
	private Integer fileSn; // FILE_SN

	private String fileStreCours; // FILE_STRE_COURS
	private String streFileNm; // STRE_FILE_NM (저장파일명)
	private String orignlFileNm; // ORIGNL_FILE_NM (원본파일명)
	private String fileExtsn; // FILE_EXTSN
	private String fileCn; // FILE_CN
	private Long fileSize; // FILE_SIZE

	private String useAt; // USE_AT

	public String getAtchFileId() {
		return atchFileId;
	}

	public void setAtchFileId(String atchFileId) {
		this.atchFileId = atchFileId;
	}

	public Integer getFileSn() {
		return fileSn;
	}

	public void setFileSn(Integer fileSn) {
		this.fileSn = fileSn;
	}

	public String getFileStreCours() {
		return fileStreCours;
	}

	public void setFileStreCours(String fileStreCours) {
		this.fileStreCours = fileStreCours;
	}

	public String getStreFileNm() {
		return streFileNm;
	}

	public void setStreFileNm(String streFileNm) {
		this.streFileNm = streFileNm;
	}

	public String getOrignlFileNm() {
		return orignlFileNm;
	}

	public void setOrignlFileNm(String orignlFileNm) {
		this.orignlFileNm = orignlFileNm;
	}

	public String getFileExtsn() {
		return fileExtsn;
	}

	public void setFileExtsn(String fileExtsn) {
		this.fileExtsn = fileExtsn;
	}

	public String getFileCn() {
		return fileCn;
	}

	public void setFileCn(String fileCn) {
		this.fileCn = fileCn;
	}

	public Long getFileSize() {
		return fileSize;
	}

	public void setFileSize(Long fileSize) {
		this.fileSize = fileSize;
	}

	public String getUseAt() {
		return useAt;
	}

	public void setUseAt(String useAt) {
		this.useAt = useAt;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
