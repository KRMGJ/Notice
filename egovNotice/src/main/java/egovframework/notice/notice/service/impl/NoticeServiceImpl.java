package egovframework.notice.notice.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.notice.notice.mapper.NoticeMapper;
import egovframework.notice.notice.service.NoticeService;
import egovframework.notice.notice.service.NoticeVO;

@Service("noticeService")
public class NoticeServiceImpl implements NoticeService {

	@Resource(name = "noticeMapper")
	private NoticeMapper noticeMapper;

	/**
	 * 공지사항 목록을 조회한다.
	 */
	@Override
	public List<NoticeVO> selectNoticeList(NoticeVO searchVO) throws Exception {
		return noticeMapper.selectNoticeList(searchVO);
	}

	/**
	 * 공지사항 총 갯수를 조회한다.
	 */
	@Override
	public int selectNoticeListTotCnt(NoticeVO searchVO) throws Exception {
		return noticeMapper.selectNoticeListTotCnt(searchVO);
	}

	/**
	 * 공지사항 상단고정 목록을 조회한다.
	 */
	@Override
	public List<NoticeVO> selectNoticePinnedList(NoticeVO searchVO) throws Exception {
		return noticeMapper.selectNoticePinnedList(searchVO);
	}

}
