package portfolio.dataprovider.model;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import portfolio.domain.entity.b3.B3Asset;

@Entity
@Table(name = "b3_assets")
public class B3AssetModel extends B3Asset {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "b3_asset_data_id")
	private B3AssetDataModel b3AssetDataModel;

	public B3AssetModel() {
		super();
	}

	public B3AssetModel(B3AssetDataModel b3AssetDataModel) {
		Objects.requireNonNull(b3AssetDataModel);
		this.b3AssetDataModel = b3AssetDataModel;
	}

	@Override
	public String toString() {
		return String.format("B3 Asset - %s - %s", this.b3AssetDataModel.getType(), this.b3AssetDataModel.getTicker());
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof B3AssetModel)) {
			return false;
		}
		B3AssetModel model = (B3AssetModel) obj;
		if (this.id != model.id || !this.b3AssetDataModel.getTicker().equals(model.b3AssetDataModel.getTicker())) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		return (String.valueOf(this.id) + this.b3AssetDataModel.getTicker()).hashCode();
	}

	public static B3AssetModel from(B3Asset asset) {
		return new B3AssetModel(B3AssetDataModel.from(asset));
	}

}
