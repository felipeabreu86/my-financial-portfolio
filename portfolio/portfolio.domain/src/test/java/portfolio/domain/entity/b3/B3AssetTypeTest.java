package portfolio.domain.entity.b3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import portfolio.domain.util.B3AssetTestUtil;

class B3AssetTypeTest {

	@Test
	void testB3AssetTypeGetInstance() {
		assertEquals(B3AssetType.STOCK, B3AssetType.valueOf("STOCK").getInstance("abcd3").getB3AssetData().getType());
		assertEquals(B3AssetType.REAL_ESTATE_FUND,
				B3AssetType.valueOf("REAL_ESTATE_FUND").getInstance("abcd11").getB3AssetData().getType());
	}

	@Test
	void testB3AssetTypeStockValidationFail() {
		for (String ticker : B3AssetTestUtil.invalidStockTickers) {
			assertThrows(IllegalArgumentException.class, () -> B3AssetType.valueOf("STOCK").getInstance(ticker));
			assertThrows(IllegalArgumentException.class, () -> B3AssetType.STOCK.validate(ticker));
		}
	}

	@Test
	void testB3AssetTypeRealEstateFundValidationFail() {
		for (String ticker : B3AssetTestUtil.invalidRealEstateFundTickers) {
			assertThrows(IllegalArgumentException.class,
					() -> B3AssetType.valueOf("REAL_ESTATE_FUND").getInstance(ticker));
			assertThrows(IllegalArgumentException.class, () -> B3AssetType.REAL_ESTATE_FUND.validate(ticker));
		}
	}

}
