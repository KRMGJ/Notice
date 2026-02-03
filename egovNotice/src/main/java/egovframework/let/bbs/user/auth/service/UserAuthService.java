package egovframework.let.bbs.user.auth.service;

import egovframework.com.cmm.vo.LoginVO;

public interface UserAuthService {

	/**
	 * 로그인 처리
	 * 
	 * @param userId      - 아이디
	 * @param rawPassword - 비밀번호(평문)
	 * @return LoginVO
	 * @throws Exception
	 */
	LoginVO login(String userId, String rawPassword) throws Exception;

	/**
	 * 로그아웃 처리 throws Exception
	 */
	void logout() throws Exception;

	/**
	 * 현재 로그인 사용자 정보 조회(로그인하지 않은 경우 null 반환)
	 * 
	 * @return LoginVO or null
	 * @throws Exception
	 */
	LoginVO meOrNull() throws Exception;
}
