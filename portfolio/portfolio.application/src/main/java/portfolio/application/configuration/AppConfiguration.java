package portfolio.application.configuration;

import java.time.Duration;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.client.RestTemplate;

/**
 * Class intended to handle various configurations of this application
 * 
 * @author Felipe Abreu
 * @version 0.01
 * @since 0.01
 */
@Configuration
public class AppConfiguration {

	/**
	 * Implementation of MessageSource, witch is a Strategy interface for resolving
	 * messages
	 * 
	 * @return MessageSource implementation
	 */
	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasenames(
				"classpath:/messages/error_messages", 
				"classpath:/messages/response_messages");
		messageSource.setDefaultEncoding("UTF-8");
		return messageSource;
	}

	/**
	 * Synchronous client to perform HTTP requests, exposing a simple, template
	 * method API over underlying HTTP client libraries such as the JDK
	 * HttpURLConnection, Apache HttpComponents, and others. The RestTemplate offers
	 * templates for common scenarios by HTTP method, in addition to the generalized
	 * exchange and execute methods that support of less frequent cases.
	 * 
	 * @param builder - Builder that configures a RestTemplate
	 * @return configuration of a RestTemplate
	 */
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder
				.setConnectTimeout(Duration.ofSeconds(30))
				.setReadTimeout(Duration.ofSeconds(30))
				.build();
	}

}