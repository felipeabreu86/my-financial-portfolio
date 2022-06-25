package portfolio.domain.entity.b3;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Abstract Class responsible for defining the basis for an instance of the
 * financial asset type of the Brazilian stock exchange (B3)
 * 
 * @author Felipe Abreu
 * @version 0.01
 * @since 0.01
 */
@Entity
@Table(name = "b3_assets")
public abstract class B3Asset {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "b3_asset_data_id")
	private B3AssetData b3AssetData;

	/**
	 * Default constructor
	 */
	public B3Asset() {
		super();
	}

	/**
	 * Overloaded constructor that receives B3 asset data
	 * 
	 * @param type   - type of asset referring to investment in the Brazilian stock
	 *               exchange (B3), not null
	 * @param ticker - asset stock symbol (ticker), not null
	 */
	public B3Asset(B3AssetType stock, String ticker) {
		this.b3AssetData = new B3AssetData(stock, ticker);
	}

	/**
	 * Getter for the reference of b3 asset data instance
	 * 
	 * @return B3 asset data reference
	 */
	public B3AssetData getB3AssetData() {
		return b3AssetData;
	}

}