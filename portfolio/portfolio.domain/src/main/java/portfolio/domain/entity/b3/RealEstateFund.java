package portfolio.domain.entity.b3;

/**
 * B3 asset class representing a Real Estate Fund
 * 
 * @author Felipe Abreu
 * @version 0.01
 * @since 0.01
 */
public class RealEstateFund extends B3Asset {

	/**
	 * Constructor that receives information by parameter to instantiate a B3
	 * asset's Real Estate Fund type
	 * 
	 * @param ticker - Brazilian exchange symbol (Ticker), not null
	 */
	public RealEstateFund(String ticker) {
		super(B3AssetType.REAL_ESTATE_FUND, ticker);
	}

}