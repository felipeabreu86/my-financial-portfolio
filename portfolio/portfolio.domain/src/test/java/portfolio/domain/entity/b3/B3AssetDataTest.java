package portfolio.domain.entity.b3;

class B3AssetDataTest {
/*
	@Test
	void testNewAssetDataWithDefaultConstructor() {
		B3AssetData assetData = new B3AssetData();
		assertEquals(B3AssetData.class, assetData.getClass());
		assertEquals(null, assetData.getTicker());
		assertEquals(null, assetData.getType());
	}

	@Test
	void testNewAssetDataForStock() {
		B3AssetData assetData = new B3AssetData(B3AssetType.STOCK, "ABCD3");
		assertEquals(B3AssetData.class, assetData.getClass());
		assertEquals("ABCD3", assetData.getTicker());
		assertEquals(B3AssetType.STOCK, assetData.getType());
	}

	@Test
	void testNewAssetDataForRealEstateFund() {
		B3AssetData assetData = new B3AssetData(B3AssetType.REAL_ESTATE_FUND, "ABCD11");
		assertEquals(B3AssetData.class, assetData.getClass());
		assertEquals("ABCD11", assetData.getTicker());
		assertEquals(B3AssetType.REAL_ESTATE_FUND, assetData.getType());
	}

	@Test
	void testNewAssetDataWithNull() {
		assertThrows(NullPointerException.class, () -> new B3AssetData(null, null));
		assertThrows(NullPointerException.class, () -> new B3AssetData(null, "ABCD3"));
		assertThrows(NullPointerException.class, () -> new B3AssetData(B3AssetType.STOCK, null));
	}

	@Test
	void testNewAssetDataWithEmpty() {
		assertThrows(NullPointerException.class, () -> new B3AssetData(null, ""));
		assertThrows(IllegalArgumentException.class, () -> new B3AssetData(B3AssetType.STOCK, ""));
		assertThrows(NullPointerException.class, () -> new B3AssetData(null, " "));
		assertThrows(IllegalArgumentException.class, () -> new B3AssetData(B3AssetType.STOCK, " "));
	}

	@Test
	void testNewAssetDataWithInvalidTicker() {
		for (String ticker : B3AssetTestUtil.invalidStockTickers) {
			assertThrows(IllegalArgumentException.class, () -> new B3AssetData(B3AssetType.STOCK, ticker));
		}

		for (String ticker : B3AssetTestUtil.invalidRealEstateFundTickers) {
			assertThrows(IllegalArgumentException.class, () -> new B3AssetData(B3AssetType.REAL_ESTATE_FUND, ticker));
		}
	}
*/
}
