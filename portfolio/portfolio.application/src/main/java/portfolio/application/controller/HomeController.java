package portfolio.application.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import portfolio.application.controller.type.PageOptions;

/**
 * Controller that receive requests from Home page and redirect them to the
 * correct page requested by user.
 * 
 * @author Felipe Abreu
 * @version 0.01
 * @since 0.01
 */
@Controller
public class HomeController {

	/**
	 * Receives a Get request for path '/' and forwards to '/login' as the solution
	 * doesn't have a home page.
	 * 
	 * @return forward to /login
	 */
	@GetMapping(value = "/")
	public String home() {
		return "forward:/login";
	}

	/**
	 * Receives a Get request for path '/{pageChoice}' and redirects to the
	 * corresponding page. The default page is 'dashboard'.
	 * 
	 * @param pageChoice - user page navigation choice.
	 * @return String indicating to load index page and the Model with 'page'
	 *         attribute filled informing which fragment should be loaded.
	 */
	@GetMapping(value = { "/{pageChoice}" })
	public String onMenuChoice(Model model, @PathVariable Optional<String> pageChoice) {
		if (pageChoice.isPresent()) {
			model.addAttribute("page", PageOptions.valueOf(pageChoice.get().toUpperCase()).toString());
		} else {
			model.addAttribute("page", PageOptions.DASHBOARD.toString());
		}
		return "index";
	}

}
