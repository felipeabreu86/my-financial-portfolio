package portfolio.domain.entity.b3;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Class of type Value Object (VO) that stores the B3 asset data like type,
 * ticket etc
 * 
 * @author Felipe Abreu
 * @version 0.01
 * @since 0.01
 */
@Entity
@Table(name = "b3_asset_data")
public class B3AssetData {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@OneToOne(mappedBy = "b3AssetData")
	private B3Asset b3Asset;

	/**
	 * Type of asset referring to investment in the Brazilian stock exchange (B3)
	 */
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private B3AssetType type;

	/**
	 * Brazilian stock exchange symbol (Ticker)
	 */
	@Column(nullable = false, unique = true)
	private String ticker;

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
		Objects.requireNonNull(type);
		type.validate(ticker);
		this.type = type;
		this.ticker = ticker.toUpperCase();
	}

	public B3AssetType getType() {
		return type;
	}

	public String getTicker() {
		return ticker;
	}

}