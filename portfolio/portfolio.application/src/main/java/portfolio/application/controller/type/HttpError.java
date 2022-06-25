package portfolio.application.controller.type;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import portfolio.service.service.MessageSourceService;

/**
 * Enum to represent HTTP errors and provide an easy way to fetch their
 * respective messages.
 * 
 * @author Felipe Abreu
 * @version 0.01
 * @since 0.01
 */
public enum HttpError {

	HTTP400 {
		@Override
		public String getErrorMessage(MessageSourceService messageService) {
			return messageService != null ? messageService.getMessageBy("error.http.400") : "";
		}

		@Override
		public String getErrorCode() {
			return "400";
		}
	},
	HTTP401 {
		@Override
		public String getErrorMessage(MessageSourceService messageService) {
			return messageService != null ? messageService.getMessageBy("error.http.401") : "";
		}

		@Override
		public String getErrorCode() {
			return "401";
		}
	},
	HTTP402 {
		@Override
		public String getErrorMessage(MessageSourceService messageService) {
			return messageService != null ? messageService.getMessageBy("error.http.402") : "";
		}

		@Override
		public String getErrorCode() {
			return "402";
		}
	},
	HTTP403 {
		@Override
		public String getErrorMessage(MessageSourceService messageService) {
			return messageService != null ? messageService.getMessageBy("error.http.403") : "";
		}

		@Override
		public String getErrorCode() {
			return "403";
		}
	},
	HTTP404 {
		@Override
		public String getErrorMessage(MessageSourceService messageService) {
			return messageService != null ? messageService.getMessageBy("error.http.404") : "";
		}

		@Override
		public String getErrorCode() {
			return "404";
		}
	},
	HTTP405 {
		@Override
		public String getErrorMessage(MessageSourceService messageService) {
			return messageService != null ? messageService.getMessageBy("error.http.405") : "";
		}

		@Override
		public String getErrorCode() {
			return "405";
		}
	},
	HTTP406 {
		@Override
		public String getErrorMessage(MessageSourceService messageService) {
			return messageService != null ? messageService.getMessageBy("error.http.406") : "";
		}

		@Override
		public String getErrorCode() {
			return "406";
		}
	},
	HTTP407 {
		@Override
		public String getErrorMessage(MessageSourceService messageService) {
			return messageService != null ? messageService.getMessageBy("error.http.407") : "";
		}

		@Override
		public String getErrorCode() {
			return "407";
		}
	},
	HTTP408 {
		@Override
		public String getErrorMessage(MessageSourceService messageService) {
			return messageService != null ? messageService.getMessageBy("error.http.408") : "";
		}

		@Override
		public String getErrorCode() {
			return "408";
		}
	},
	HTTP409 {
		@Override
		public String getErrorMessage(MessageSourceService messageService) {
			return messageService != null ? messageService.getMessageBy("error.http.409") : "";
		}

		@Override
		public String getErrorCode() {
			return "409";
		}
	},
	HTTP410 {
		@Override
		public String getErrorMessage(MessageSourceService messageService) {
			return messageService != null ? messageService.getMessageBy("error.http.410") : "";
		}

		@Override
		public String getErrorCode() {
			return "410";
		}
	},
	HTTP411 {
		@Override
		public String getErrorMessage(MessageSourceService messageService) {
			return messageService != null ? messageService.getMessageBy("error.http.411") : "";
		}

		@Override
		public String getErrorCode() {
			return "411";
		}
	},
	HTTP412 {
		@Override
		public String getErrorMessage(MessageSourceService messageService) {
			return messageService != null ? messageService.getMessageBy("error.http.412") : "";
		}

		@Override
		public String getErrorCode() {
			return "412";
		}
	},
	HTTP413 {
		@Override
		public String getErrorMessage(MessageSourceService messageService) {
			return messageService != null ? messageService.getMessageBy("error.http.413") : "";
		}

		@Override
		public String getErrorCode() {
			return "413";
		}
	},
	HTTP414 {
		@Override
		public String getErrorMessage(MessageSourceService messageService) {
			return messageService != null ? messageService.getMessageBy("error.http.414") : "";
		}

		@Override
		public String getErrorCode() {
			return "414";
		}
	},
	HTTP415 {
		@Override
		public String getErrorMessage(MessageSourceService messageService) {
			return messageService != null ? messageService.getMessageBy("error.http.415") : "";
		}

		@Override
		public String getErrorCode() {
			return "415";
		}
	},
	HTTP416 {
		@Override
		public String getErrorMessage(MessageSourceService messageService) {
			return messageService != null ? messageService.getMessageBy("error.http.416") : "";
		}

		@Override
		public String getErrorCode() {
			return "416";
		}
	},
	HTTP417 {
		@Override
		public String getErrorMessage(MessageSourceService messageService) {
			return messageService != null ? messageService.getMessageBy("error.http.417") : "";
		}

		@Override
		public String getErrorCode() {
			return "417";
		}
	},
	HTTP500 {
		@Override
		public String getErrorMessage(MessageSourceService messageService) {
			return messageService != null ? messageService.getMessageBy("error.http.500") : "";
		}

		@Override
		public String getErrorCode() {
			return "500";
		}
	},
	HTTP501 {
		@Override
		public String getErrorMessage(MessageSourceService messageService) {
			return messageService != null ? messageService.getMessageBy("error.http.501") : "";
		}

		@Override
		public String getErrorCode() {
			return "501";
		}
	},
	HTTP502 {
		@Override
		public String getErrorMessage(MessageSourceService messageService) {
			return messageService != null ? messageService.getMessageBy("error.http.502") : "";
		}

		@Override
		public String getErrorCode() {
			return "502";
		}
	},
	HTTP503 {
		@Override
		public String getErrorMessage(MessageSourceService messageService) {
			return messageService != null ? messageService.getMessageBy("error.http.503") : "";
		}

		@Override
		public String getErrorCode() {
			return "503";
		}
	},
	HTTP504 {
		@Override
		public String getErrorMessage(MessageSourceService messageService) {
			return messageService != null ? messageService.getMessageBy("error.http.504") : "";
		}

		@Override
		public String getErrorCode() {
			return "504";
		}
	},
	HTTP505 {
		@Override
		public String getErrorMessage(MessageSourceService messageService) {
			return messageService != null ? messageService.getMessageBy("error.http.505") : "";
		}

		@Override
		public String getErrorCode() {
			return "505";
		}
	},
	HTTP511 {
		@Override
		public String getErrorMessage(MessageSourceService messageService) {
			return messageService != null ? messageService.getMessageBy("error.http.511") : "";
		}

		@Override
		public String getErrorCode() {
			return "511";
		}
	};

	/**
	 * Statically stores the mapping between the HTTP error code and its
	 * corresponding HttpError enum.
	 */
	private static final Map<String, HttpError> ENUM_MAP;
	static {
		Map<String, HttpError> map = new ConcurrentHashMap<String, HttpError>();
		for (HttpError httpError : HttpError.values()) {
			map.put(httpError.getErrorCode(), httpError);
		}
		ENUM_MAP = Collections.unmodifiableMap(map);
	}

	/**
	 * Returns the HttpError corresponding to the HTTP error code passed by
	 * parameter. The code must contain only numbers, for example 400, 500...
	 * 
	 * @param httpErrorCode - HTTP error code
	 * @return HttpError enum or Null if not found
	 */
	public static HttpError from(String httpErrorCode) {
		HttpError httpError = null;
		if (httpErrorCode != null) {
			httpError = ENUM_MAP.get(httpErrorCode);
		}
		return httpError;
	}

	/**
	 * Returns the error message corresponding to the HTTP error code passed by
	 * parameter.
	 * 
	 * @param httpErrorCode  - HTTP error code
	 * @param messageService - Service to fetch messages from *_messsage.properties
	 *                       files
	 * @return Error message ou empty string if not found
	 */
	public static String getMessageBy(String httpErrorCode, MessageSourceService messageService) {
		HttpError httpError = from(httpErrorCode);
		return httpError != null ? httpError.getErrorMessage(messageService) : "";
	}

	/**
	 * Returns the HTTP error code in String format.
	 * 
	 * @return HTTP error code
	 */
	public abstract String getErrorCode();

	/**
	 * Returns the HTTP error message in String format.
	 * 
	 * @param messageService - Service to fetch messages from *_messsage.properties
	 *                       files
	 * @return Error message ou empty string if not found
	 */
	public abstract String getErrorMessage(MessageSourceService messageService);

}
