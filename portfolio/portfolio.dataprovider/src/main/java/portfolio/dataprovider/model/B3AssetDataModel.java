package portfolio.dataprovider.model;

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

import portfolio.domain.entity.b3.B3Asset;
import portfolio.domain.entity.b3.B3AssetData;
import portfolio.domain.entity.b3.B3AssetType;

@Entity
@Table(name = "b3_asset_data")
public class B3AssetDataModel extends B3AssetData {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@OneToOne(mappedBy = "b3AssetDataModel")
	private B3AssetModel b3AssetModel;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private B3AssetType type;

	@Column(nullable = false, unique = true)
	private String ticker;

	public B3AssetDataModel() {
		super();
	}

	public B3AssetDataModel(B3AssetData b3AssetType) {
		this();
		Objects.requireNonNull(b3AssetType);
		this.type = b3AssetType.getType();
		this.ticker = b3AssetType.getTicker();
	}

	public B3AssetType getType() {
		return type;
	}

	public String getTicker() {
		return ticker;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof B3AssetDataModel)) {
			return false;
		}
		B3AssetDataModel model = (B3AssetDataModel) obj;
		if (this.id != model.id || !this.ticker.equals(model.getTicker())) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		return (String.valueOf(this.id) + this.ticker).hashCode();
	}

	public static B3AssetDataModel from(B3Asset asset) {
		return new B3AssetDataModel(asset.getAssetData());
	}

}
