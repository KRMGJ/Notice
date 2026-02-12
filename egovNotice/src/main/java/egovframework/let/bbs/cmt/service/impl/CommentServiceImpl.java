package egovframework.let.bbs.cmt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.egovframe.rte.fdl.idgnr.EgovIdGnrService;
import org.springframework.stereotype.Service;

import egovframework.let.bbs.cmt.dao.CommentDAO;
import egovframework.let.bbs.cmt.service.CommentService;
import egovframework.let.bbs.cmt.vo.CommentVO;

@Service("commentService")
public class CommentServiceImpl implements CommentService {

	@Resource(name = "commentDAO")
	private CommentDAO commentDAO;

	@Resource(name = "egovCmtIdGnrService")
	private EgovIdGnrService egovCmtIdGnrService;

	/**
	 * 댓글 목록 조회
	 */
	@Override
	public List<CommentVO> selectCommentList(String nttId) throws Exception {
		return commentDAO.selectCommentList(nttId);
	}

	/**
	 * 댓글 등록
	 */
	@Override
	public String insertComment(CommentVO vo) throws Exception {
		String commentId = egovCmtIdGnrService.getNextStringId();
		vo.setCommentId(commentId);

		// 부모 댓글이 없는 경우(최상위 댓글)
		if (vo.getParentId() == null || vo.getParentId().isEmpty()) {

			int maxOrder = commentDAO.selectMaxOrder(vo.getNttId());

			vo.setCommentGroup(commentId);
			vo.setCommentDepth(0);
			vo.setCommentOrder(maxOrder + 1);

		} else {

			CommentVO parent = commentDAO.selectComment(vo.getParentId());

			commentDAO.updateOrderPlus(parent);

			vo.setCommentGroup(parent.getCommentGroup());
			vo.setCommentDepth(parent.getCommentDepth() + 1);
			vo.setCommentOrder(parent.getCommentOrder() + 1);
		}

		commentDAO.insertComment(vo);
		return vo.getCommentId();
	}

	/**
	 * 댓글 삭제 (논리삭제)
	 */
	@Override
	public void deleteComment(CommentVO vo) throws Exception {
		commentDAO.deleteComment(vo);
	}

	/**
	 * 댓글 수정
	 */
	@Override
	public void updateComment(CommentVO vo) throws Exception {
		commentDAO.updateComment(vo);
	}

}
