package portfolio.application.controller.request;

import javax.validation.constraints.NotBlank;

import portfolio.domain.entity.b3.B3Asset;
import portfolio.domain.entity.b3.B3AssetType;

/**
 * This class represents the data of a request made to the application in order
 * to register a new asset in the database.
 * 
 * @author Felipe Abreu
 * @version 0.01
 * @since 0.01
 */
public class B3AssetCreateRequest {

	/**
	 * Brazilian stock exchange symbol (Ticker), not null or Empty
	 */
	@NotBlank
	private String ticker;

	/**
	 * Type of asset referring to investment in the Brazilian stock exchange (B3),
	 * not null or Empty
	 */
	@NotBlank
	private String type;

	/**
	 * Getter for Ticker
	 * 
	 * @return Brazilian stock exchange symbol (Ticker)
	 */
	public String getTicker() {
		return ticker;
	}

	/**
	 * Setter for Ticker
	 * 
	 * @param ticker - Brazilian stock exchange symbol (Ticker)
	 */
	public void setTicker(String ticker) {
		this.ticker = ticker;
	}

	/**
	 * Getter for Type
	 * 
	 * @return Type of asset referring to investment in the Brazilian stock exchange
	 *         (B3)
	 */
	public String getType() {
		return type;
	}

	/**
	 * Setter for Type
	 * 
	 * @param type - Type of asset referring to investment in the Brazilian stock
	 *             exchange (B3)
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Uses the attributes received in the request to instantiate an object of type
	 * B3Asset
	 * 
	 * @return B3Asset reference
	 */
	public B3Asset toB3Asset() {
		return B3AssetType.valueOf(type.toUpperCase()).getInstance(this.ticker);
	}

}
