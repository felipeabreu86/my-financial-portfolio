package portfolio.domain.entity.b3;

import javax.persistence.Entity;

/**
 * B3 asset class representing a Stock
 * 
 * @author Felipe Abreu
 * @version 0.01
 * @since 0.01
 */
@Entity
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

	@Override
	public String toString() {
		return String.format("B3 Asset, Stock ticker %s.", this.getB3AssetData().getTicker());
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof Stock)) {
			return false;
		}
		Stock other = (Stock) obj;
		if (!this.getB3AssetData().getTicker().equals(other.getB3AssetData().getTicker())) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		return this.getB3AssetData().getTicker().hashCode();
	}

}
