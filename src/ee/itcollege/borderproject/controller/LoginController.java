package ee.itcollege.borderproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

	private static final String LOGIN_VIEW = "Login";
	
	@RequestMapping("/login")
	public String login() {
		return LOGIN_VIEW;
	}

	@RequestMapping(value = "/loginfailed")
	public String loginerror(Model model) {
		return LOGIN_VIEW;

	}
}
