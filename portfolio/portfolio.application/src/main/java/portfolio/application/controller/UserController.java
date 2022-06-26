package portfolio.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import portfolio.application.controller.type.PageOptions;

/**
 * Controller that receives requests via '/user' path and processes and
 * redirects them for its specific purposes
 * 
 * @author Felipe Abreu
 * @version 0.01
 * @since 0.01
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

	/**
	 * Load profile page
	 * 
	 * @param model - Interface that defines a holder for model attributes
	 * @return index page with the information to load 'profile' fragment
	 */
	@GetMapping(value = "/profile")
	public String profile(Model model) {
		model.addAttribute("page", PageOptions.PROFILE.toString());
		return "index";
	}

}
