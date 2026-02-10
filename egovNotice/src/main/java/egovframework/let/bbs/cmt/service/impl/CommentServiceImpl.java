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

	@Override
	public List<CommentVO> selectCommentList(String nttId) throws Exception {
		return commentDAO.selectCommentList(nttId);
	}

	@Override
	public String insertComment(CommentVO vo) throws Exception {
		String commentId = egovCmtIdGnrService.getNextStringId();
		vo.setCommentId(commentId);
		commentDAO.insertComment(vo);
		return vo.getCommentId();
	}

	@Override
	public void deleteComment(CommentVO vo) throws Exception {
		commentDAO.deleteComment(vo);
	}

}
