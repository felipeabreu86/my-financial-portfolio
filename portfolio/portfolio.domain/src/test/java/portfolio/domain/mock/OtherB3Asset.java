package portfolio.domain.mock;

import portfolio.domain.entity.b3.B3Asset;
import portfolio.domain.entity.b3.B3AssetType;

public class OtherB3Asset extends B3Asset {
	public OtherB3Asset() {
		super(null, null);
	}

	public OtherB3Asset(B3AssetType type, String ticker) {
		super(type, ticker);
	}
}