package portfolio.domain.entity.b3;

/**
 * Enum to represent the types of assets that can be invested in relation to
 * investments in the Brazilian stock exchange (B3)
 * 
 * @author Felipe Abreu
 * @version 0.01
 * @since 0.01
 */
public enum B3AssetType {

	STOCK {
		@Override
		public B3Asset getInstance(String ticker) {
			return new Stock(ticker);
		}
	},
	REAL_ESTATE_FUND {
		@Override
		public B3Asset getInstance(String ticker) {
			return new RealEstateFund(ticker);
		}
	};

	/**
	 * Abstract method that aims to return an instance of a b3 asset with the ticker
	 * passed by parameter
	 * 
	 * @param ticker - asset stock symbol (ticker)
	 * @return instance of B3 asset
	 */
	public abstract B3Asset getInstance(String ticker);

}
