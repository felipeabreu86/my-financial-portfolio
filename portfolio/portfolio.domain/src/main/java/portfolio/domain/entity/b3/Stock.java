package portfolio.domain.entity.b3;

/**
 * B3 asset class representing a Stock
 * 
 * @author Felipe Abreu
 * @version 0.01
 * @since 0.01
 */
public class Stock extends B3Asset {

	/**
	 * Constructor that receives information by parameter to instantiate a B3
	 * asset's Stock type
	 * 
	 * @param ticker - Brazilian exchange symbol (Ticker), not null
	 */
	public Stock(String ticker) {
		super(B3AssetType.STOCK, ticker);
	}

}
