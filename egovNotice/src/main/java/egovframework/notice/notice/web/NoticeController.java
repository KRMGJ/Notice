package egovframework.notice.notice.web;

import java.util.List;

import javax.annotation.Resource;

import org.egovframe.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.notice.notice.service.NoticeService;
import egovframework.notice.notice.service.NoticeVO;

@Controller
public class NoticeController {

	@Resource(name = "noticeService")
	private NoticeService noticeService;

	/**
	 * 공지사항 목록을 조회한다.
	 * 
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @param model    - 화면모델
	 * @return 공지사항 목록 View
	 * @throws Exception
	 */
	@RequestMapping("/notice/list.do")
	public String noticeList(NoticeVO searchVO, Model model) throws Exception {
		if (searchVO.getBbsId() == null || searchVO.getBbsId().isEmpty()) {
			searchVO.setBbsId("BBSMSTR_000000000001");
		}

		if (searchVO.getPageIndex() < 1) {
			searchVO.setPageIndex(1);
		}

		if (searchVO.getPageUnit() < 1) {
			searchVO.setPageUnit(10);
		}

		if (searchVO.getPageSize() < 1) {
			searchVO.setPageSize(10);
		}

		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(searchVO.getPageIndex());
		paginationInfo.setRecordCountPerPage(searchVO.getPageUnit());
		paginationInfo.setPageSize(searchVO.getPageSize());

		searchVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		searchVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());

		List<NoticeVO> noticeList = noticeService.selectNoticeList(searchVO);
		List<NoticeVO> pinnedList = noticeService.selectNoticePinnedList(searchVO);

		int totCnt = noticeService.selectNoticeListTotCnt(searchVO);
		paginationInfo.setTotalRecordCount(totCnt);

		model.addAttribute("noticeList", noticeList);
		model.addAttribute("pinnedList", pinnedList);
		model.addAttribute("paginationInfo", paginationInfo);
		model.addAttribute("searchVO", searchVO);

		return "notice/noticeList";
	}
}
