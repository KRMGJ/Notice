package egovframework.let.bbs.user.dao;

import org.egovframe.rte.psl.dataaccess.EgovAbstractMapper;
import org.springframework.stereotype.Repository;

import egovframework.let.bbs.user.vo.ComtnUserVO;

@Repository("comtnUserDAO")
public class ComtnUserDAO extends EgovAbstractMapper {

	/**
	 * userId로 사용자 정보 조회
	 * 
	 * @param userId
	 * @return ComtnUserVO
	 */
	public ComtnUserVO selectUserById(String userId) {
		return (ComtnUserVO) selectOne("ComtnUserDAO.selectUserById", userId);
	}

	/**
	 * 로그인 처리를 위한 사용자 정보 조회
	 * 
	 * @param userId
	 * @return ComtnUserVO
	 */
	public ComtnUserVO selectUserForLogin(String userId) {
		return (ComtnUserVO) selectOne("ComtnUserDAO.selectUserForLogin", userId);
	}
}
