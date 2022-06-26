package portfolio.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import portfolio.application.controller.type.PageOptions;

/**
 * Controller that handles requests related to user authentication.
 * 
 * @author Felipe Abreu
 * @version 0.01
 * @since 0.01
 */
@Controller
public class AuthenticationController {

	/**
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping(value = { "/", "/login" })
	public String login(Model model) {
		return "login";
	}

	/**
	 * 
	 * @param model
	 * @return
	 */
	@PostMapping(value = "/loginredirect")
	public String loginredirect(Model model) {
		return "redirect:/" + PageOptions.DASHBOARD.toString();
	}

	/**
	 * Log the user out and redirects to home page
	 * 
	 * @param model - Interface that defines a holder for model attributes
	 * @return forward to home page
	 */
	@GetMapping(value = "/logout")
	public String logout(Model model) {
		return "redirect:/login";
	}

}
