package ee.itcollege.borderproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	public static final String HOME_PAGE = "HomePage";

	@RequestMapping("/")
	public String index() {
		return HOME_PAGE;
	}
	
}
