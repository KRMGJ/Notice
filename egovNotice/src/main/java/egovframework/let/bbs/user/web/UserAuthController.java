package egovframework.let.bbs.user.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import egovframework.com.cmm.LoginVO;
import egovframework.let.bbs.user.service.UserAuthService;

@Controller
public class UserAuthController {

	@Resource(name = "userAuthService")
	private UserAuthService userAuthService;

	/** 로그인 화면 */
	@RequestMapping(value = "/user/loginView.do", method = RequestMethod.GET)
	public String loginView() {
		return "user/login";
	}

	/** 로그인 처리 */
	@RequestMapping(value = "/user/login.do", method = RequestMethod.POST)
	public String login(@RequestParam("userId") String userId, @RequestParam("password") String password, Model model,
			HttpServletResponse response) {
		try {
			LoginVO loginVO = userAuthService.login(userId, password);

			model.addAttribute("result", "OK");
			model.addAttribute("loginVO", loginVO);
			return "jsonView";

		} catch (IllegalArgumentException | IllegalStateException e) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);

			model.addAttribute("result", "FAIL");
			model.addAttribute("message", e.getMessage());
			return "jsonView";
		} catch (Exception e) {
			response.setStatus(500);

			model.addAttribute("result", "FAIL");
			model.addAttribute("message", "서버 오류");
			return "jsonView";
		}
	}

	/** 로그아웃 */
	@RequestMapping(value = "/user/logout.do", method = RequestMethod.POST)
	public String logout(Model model) {
		userAuthService.logout();
		model.addAttribute("result", "OK");
		return "jsonView";
	}

	/** 현재 로그인 사용자 */
	@RequestMapping(value = "/user/me.do", method = RequestMethod.GET)
	public String me(Model model) {
		LoginVO loginVO = userAuthService.meOrNull();
		model.addAttribute("isLogin", loginVO != null);
		model.addAttribute("loginVO", loginVO);
		return "jsonView";
	}
}
