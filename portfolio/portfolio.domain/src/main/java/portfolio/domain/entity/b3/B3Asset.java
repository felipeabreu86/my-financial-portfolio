package portfolio.domain.entity.b3;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Class responsible for defining the basis for an instance of the financial
 * asset type of the Brazilian stock exchange (B3)
 * 
 * @author Felipe Abreu
 * @version 0.01
 * @since 0.01
 */
@MappedSuperclass
public class B3Asset {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	protected B3AssetType type;

	@Column(nullable = false, unique = true)
	protected String ticker;

	public B3Asset(B3AssetType type, String ticker) {
		this.type = type;
		this.ticker = ticker;
	}

	public long getId() {
		return id;
	}

	public B3AssetType getType() {
		return type;
	}

	public String getTicker() {
		return ticker;
	}

}