package portfolio.shared.util;

import java.util.Locale;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

/**
 * This class implements the component that aims to fetch messages from
 * /resources/messages/*_messsage.properties files.
 * 
 * @author Felipe Abreu
 * @version 0.01
 * @since 0.01
 */
@Component
public class MessageUtil {

	@Autowired
	private MessageSource messageSource;

	/**
	 * Represents a specific geographical, political, or cultural region. Brazil
	 * Portuguese (pt-BR) set as Default.
	 */
	private Locale locale = new Locale("pt", "BR");

	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		Objects.requireNonNull(locale);
		this.locale = locale;
	}

	/**
	 * Returns the message stored in the properties file from its identifier code
	 * 
	 * @param resourceCode - resource identifier code
	 * @return String containing the Message linked to the resource code
	 */
	public String getMessageBy(String resourceCode) {
		return messageSource.getMessage(resourceCode, null, locale);
	}

	/**
	 * Returns the message stored in the properties file from its identifier code
	 * and add the arguments into it as parameters
	 * 
	 * @param resourceCode - resource identifier code
	 * @param args         - arguments
	 * @return String containing the Message linked to the resource code
	 */
	public String getMessageBy(String resourceCode, Object... args) {
		return messageSource.getMessage(resourceCode, args, locale);
	}

}
