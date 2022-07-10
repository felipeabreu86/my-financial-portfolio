package portfolio.application.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
	 * Receives a Get request for path '/' and forwards to '/login' as the solution
	 * doesn't has a home page.
	 * 
	 * @return forward to /login
	 */
	@GetMapping(value = "/")
	public String home() {
		return "forward:/login";
	}

	/**
	 * Receives a Get request for path '/login' and redirects to login page.
	 * 
	 * @param principal - represents the user logged in
	 * @return redirects to '/dashboard' if the user is logged in or to '/login' if
	 *         not.
	 */
	@GetMapping(value = "/login")
	public String login(final Principal principal) {
		boolean userIsLoggedIn = principal != null;
		
		if (userIsLoggedIn) {
			return "redirect:/dashboard";
		}
		
		return "login";
	}

}
