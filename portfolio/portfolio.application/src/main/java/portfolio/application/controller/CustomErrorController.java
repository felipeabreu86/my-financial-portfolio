package portfolio.application.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.ServletWebRequest;

import portfolio.application.controller.type.HttpError;
import portfolio.shared.util.MessageUtil;

/**
 * Controller responsible for intercepting application errors via '/error' path,
 * handling them and redirect to the generic page error
 * 
 * @author Felipe Abreu
 * @version 0.01
 * @since 0.01
 */
@Controller
public class CustomErrorController implements ErrorController {

	/**
	 * Provides access to error attributes which can be logged or presented to the
	 * user
	 */
	@Autowired
	private ErrorAttributes errorAttributes;

	/**
	 * Reference to message source service implementation
	 */
	@Autowired
	private MessageUtil messageUtil;

	/**
	 * It handles the error thrown while using the application and redirects the
	 * user to the generic page error
	 * 
	 * @param request - HTTP Servlet Request
	 * @return generic page error with status and error description information
	 */
	@RequestMapping("/error")
	public String handleError(HttpServletRequest request) {
		Map<String, Object> attrs = errorAttributes
				.getErrorAttributes(new ServletWebRequest(request), ErrorAttributeOptions.defaults());

		// get error attributes
		String status = attrs.getOrDefault("status", "").toString();
		String error = attrs.getOrDefault("error", "").toString();
		String timestamp = attrs.getOrDefault("timestamp", "").toString();
		String message = attrs.getOrDefault("message", "").toString();
		String path = attrs.getOrDefault("path", "").toString();

		// TODO: log error details here...
		System.out.println("timestamp: " + timestamp);
		System.out.println("status: " + status);
		System.out.println("error: " + error);
		System.out.println("message: " + message);
		System.out.println("path: " + path);
		// -------------------------------

		// send status and error description to error.html through request attributes
		request.setAttribute("status", status);
		request.setAttribute("errordescription", HttpError.getMessageBy(status, messageUtil));

		// display generic page error
		return "error";
	}

	/**
	 * This method only exists to avoid browser 404 issue by returning nothing in
	 * response for '/favicon.ico' request.
	 */
	@GetMapping("/favicon.ico")
	@ResponseBody
	public void returnNoFavicon() {
	}

}
