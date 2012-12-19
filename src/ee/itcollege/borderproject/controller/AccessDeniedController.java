package ee.itcollege.borderproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AccessDeniedController {
	
	private static final String ACCESS_DENIED_VIEW = "AccessDenied";

	@RequestMapping(value = "/accessDenied")
	public String accessDenied() {
		return ACCESS_DENIED_VIEW;
	}

}
