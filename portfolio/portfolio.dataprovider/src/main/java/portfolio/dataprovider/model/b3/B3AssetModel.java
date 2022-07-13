package portfolio.dataprovider.model.b3;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Table;

import portfolio.domain.entity.b3.B3Asset;
import portfolio.domain.entity.b3.B3AssetType;

@Entity
@Table(name = "b3_assets")
public class B3AssetModel extends B3Asset {

	public B3AssetModel() {
		super(null, null);
	}

	public B3AssetModel(B3AssetType type, String ticker) {
		super(type, ticker);
		this.type = Objects.requireNonNull(type);
		this.ticker = Objects.requireNonNull(ticker);
		this.type.validate(ticker);
	}

	public boolean isValid() {
		try {
			Objects.requireNonNull(this.getType());
			this.getType().validate(getTicker());
		} catch (IllegalArgumentException | NullPointerException e) {
			return false;
		}
		return true;
	}

}
