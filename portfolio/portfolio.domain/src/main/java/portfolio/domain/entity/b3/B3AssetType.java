package portfolio.domain.entity.b3;

import java.util.Objects;

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
			return new B3Asset(STOCK, ticker);
		}

		@Override
		public void validate(String ticker) {
			Objects.requireNonNull(ticker);

			if (!ticker.matches("[A-Za-z]{4}(3|4|5|6|7|8|11)")) {
				throw new IllegalArgumentException("Invalid format for Stock Ticker: " + ticker);
			}
		}
	},
	REAL_ESTATE_FUND {
		@Override
		public B3Asset getInstance(String ticker) {
			return new B3Asset(REAL_ESTATE_FUND, ticker);
		}

		@Override
		public void validate(String ticker) {
			Objects.requireNonNull(ticker);

			if (!ticker.matches("[A-Za-z]{4}11")) {
				throw new IllegalArgumentException("Invalid format for Real Estate Fund Ticker: " + ticker);
			}
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

	/**
	 * Abstract method that performs asset ticker validations
	 * 
	 * @param ticker - asset stock symbol (ticker)
	 */
	public abstract void validate(String ticker);

}
