package portfolio.service.service;

import java.util.Locale;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

/**
 * This class implements the service that aims to fetch messages from
 * /resources/messages/*_messsage.properties files.
 * 
 * @author Felipe Abreu
 * @version 0.01
 * @since 0.01
 */
@Service
public class MessageSourceService {

	/**
	 * Interface for resolving messages from *_messsage.properties
	 */
	@Autowired
	private MessageSource messageSource;

	/**
	 * Represents a specific geographical, political, or cultural region. Brazil
	 * Portuguese (pt-BR) set as Default.
	 */
	private Locale locale = new Locale("pt", "BR");

	/**
	 * Setter for Locale
	 * 
	 * @param locale - represents a specific geographical, political, or cultural
	 *               region, not null
	 */
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

}
