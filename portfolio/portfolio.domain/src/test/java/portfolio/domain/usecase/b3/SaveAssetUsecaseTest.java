package portfolio.domain.usecase.b3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import portfolio.domain.entity.b3.B3Asset;
import portfolio.domain.entity.b3.B3AssetType;
import portfolio.domain.entity.b3.RealEstateFund;
import portfolio.domain.entity.b3.Stock;
import portfolio.domain.mock.B3AssetRepositoryImplMock;
import portfolio.domain.mock.OtherB3Asset;
import portfolio.domain.util.B3AssetTestUtil;

class SaveAssetUsecaseTest {

	private static SaveAssetUsecase usecase;

	@BeforeAll
	static void beforeAll() {
		usecase = new SaveAssetUsecase(new B3AssetRepositoryImplMock());
	}

	@Test
	void testSaveAsset() {
		B3Asset asset = new Stock("ABCD4");
		B3Asset savedAsset = usecase.call(asset);

		assertEquals(asset.getB3AssetData().getTicker(), savedAsset.getB3AssetData().getTicker());
		assertEquals("ABCD4", savedAsset.getB3AssetData().getTicker());
		assertEquals(B3AssetType.STOCK, savedAsset.getB3AssetData().getType());
	}

	@Test
	void testSaveNullAsset() {
		assertThrows(NullPointerException.class, () -> usecase.call(null));
	}

	@Test
	void testSaveAssetWithNullParameters() {
		assertThrows(NullPointerException.class, () -> usecase.call(new OtherB3Asset()));
		assertThrows(NullPointerException.class, () -> usecase.call(new OtherB3Asset(null, null)));
		assertThrows(NullPointerException.class, () -> usecase.call(new OtherB3Asset(B3AssetType.STOCK, null)));
		assertThrows(NullPointerException.class, () -> usecase.call(new OtherB3Asset(null, "ABCD3")));
	}

	@Test
	void testSaveAssetWithIllegalArgumentException() {
		for (String ticker : B3AssetTestUtil.invalidStockTickers) {
			assertThrows(IllegalArgumentException.class, () -> usecase.call(new Stock(ticker)));
		}
		for (String ticker : B3AssetTestUtil.invalidRealEstateFundTickers) {
			assertThrows(IllegalArgumentException.class, () -> usecase.call(new RealEstateFund(ticker)));
		}
	}

}
