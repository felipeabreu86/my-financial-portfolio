package portfolio.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import portfolio.application.controller.type.PageOptions;

@Controller
@RequestMapping(value = "/user")
public class UserController {

	@GetMapping(value = "/logout")
	public String logout(Model model) {
		return "forward:/";
	}

	@GetMapping(value = "/profile")
	public String profile(Model model) {
		model.addAttribute("page", PageOptions.PROFILE.toString());
		return "index";
	}

}
