package egovframework.let.bbs.user.service;

import egovframework.com.cmm.LoginVO;

public interface UserAuthService {

	LoginVO login(String userId, String rawPassword);

	void logout();

	LoginVO meOrNull();
}
