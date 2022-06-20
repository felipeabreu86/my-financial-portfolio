package portfolio.domain.entity.b3;

import java.util.Objects;

/**
 * Abstract class responsible for defining the basis for an instance of the
 * financial asset type of the Brazilian stock exchange (B3)
 * 
 * @author Felipe Abreu
 * @version 0.01
 * @since 0.01
 */
public abstract class B3Asset {

	/**
	 * Reference to B3AssetData class (value object) that stores the B3 asset data
	 */
	protected B3AssetData b3AssetData;

	/**
	 * Default constructor
	 */
	public B3Asset() {
		super();
		if (this.b3AssetData == null) {
			this.b3AssetData = new B3AssetData();
		}
	}

	/**
	 * Overloaded constructor that receives B3 asset data
	 * 
	 * @param type   - type of asset referring to investment in the Brazilian stock
	 *               exchange (B3), not null
	 * @param ticker - asset stock symbol (ticker), not null
	 */
	public B3Asset(B3AssetType type, String ticker) {
		Objects.requireNonNull(ticker);
		this.b3AssetData = new B3AssetData(type, ticker);
	}

	/**
	 * Getter for the reference of b3 asset data instance
	 * 
	 * @return B3 asset data reference
	 */
	public B3AssetData getAssetData() {
		return this.b3AssetData;
	}

}
