package portfolio.domain.entity.b3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class B3AssetTest {

	@Test
	void testNewAssetForStock() {
		B3Asset asset = new Stock("ABCD3");
		assertEquals(true, asset instanceof B3Asset);
		assertEquals("ABCD3", asset.getB3AssetData().getTicker());
		assertEquals(B3AssetType.STOCK, asset.getB3AssetData().getType());
	}

	@Test
	void testNewAssetForRealEstateFund() {
		B3Asset asset = new RealEstateFund("ABCD11");
		assertEquals(true, asset instanceof B3Asset);
		assertEquals("ABCD11", asset.getB3AssetData().getTicker());
		assertEquals(B3AssetType.REAL_ESTATE_FUND, asset.getB3AssetData().getType());
	}

}
