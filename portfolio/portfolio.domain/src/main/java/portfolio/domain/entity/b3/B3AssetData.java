package portfolio.domain.entity.b3;

import java.util.Objects;

/**
 * Class of type Value Object (VO) that stores the B3 asset data like type,
 * ticket etc
 * 
 * @author Felipe Abreu
 * @version 0.01
 * @since 0.01
 */
public class B3AssetData {

	/**
	 * Type of asset referring to investment in the Brazilian stock exchange (B3)
	 */
	private B3AssetType type;

	/**
	 * Brazilian stock exchange symbol (Ticker)
	 */
	private String ticker;

	/**
	 * Default constructor
	 */
	public B3AssetData() {
		super();
	}

	/**
	 * Overloaded constructor that receives B3 asset data
	 * 
	 * @param type   - type of asset referring to investment in the Brazilian stock
	 *               exchange (B3), not null
	 * @param ticker - asset stock symbol (ticker), not null
	 */
	public B3AssetData(B3AssetType type, String ticker) {
		Objects.requireNonNull(ticker);
		this.type = type;
		this.ticker = ticker.toUpperCase();
	}

	/**
	 * Getter for type
	 * 
	 * @return type of B3 asset
	 */
	public B3AssetType getType() {
		return type;
	}

	/**
	 * Getter for ticker
	 * 
	 * @return symbol of B3 asset
	 */
	public String getTicker() {
		return ticker;
	}

}
