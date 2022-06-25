package portfolio.domain.entity.b3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import portfolio.domain.util.B3AssetTestUtil;

class RealEstateFundTest {

	@Test
	void testNewRealEstateFundWithNullTicker() {
		assertThrows(NullPointerException.class, () -> new RealEstateFund(null));
	}

	@Test
	void testNewRealEstateFundWithEmptyTicker() {
		assertThrows(IllegalArgumentException.class, () -> new RealEstateFund(""));
		assertThrows(IllegalArgumentException.class, () -> new RealEstateFund(" "));
	}

	@Test
	void testNewRealEstateFundWithInvalidTicker() {
		for (String ticker : B3AssetTestUtil.invalidRealEstateFundTickers) {
			assertThrows(IllegalArgumentException.class, () -> new RealEstateFund(ticker));
		}
	}

	@Test
	void testNewRealEstateFundWithValidTicker() {
		assertEquals("ABCD11", new RealEstateFund("ABCD11").getB3AssetData().getTicker());
	}

	@Test
	void testNewRealEstateFundWithTickerInUppercase() {
		B3Asset asset = new RealEstateFund("abcd11");
		assertEquals("ABCD11", asset.getB3AssetData().getTicker());
		assertNotEquals("abcd11", asset.getB3AssetData().getTicker());
	}

	@Test
	void testB3AssetType() {
		assertEquals(B3AssetType.REAL_ESTATE_FUND, new RealEstateFund("abcd11").getB3AssetData().getType());
	}

}
