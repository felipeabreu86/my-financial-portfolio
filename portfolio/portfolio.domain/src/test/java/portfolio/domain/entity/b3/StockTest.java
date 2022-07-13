package portfolio.domain.entity.b3;

class StockTest {
/*
	@Test
	void testNewStockWithNullTicker() {
		assertThrows(NullPointerException.class, () -> new Stock(null));
	}

	@Test
	void testNewStockWithEmptyTicker() {
		assertThrows(IllegalArgumentException.class, () -> new Stock(""));
		assertThrows(IllegalArgumentException.class, () -> new Stock(" "));
	}

	@Test
	void testNewStockWithInvalidTicker() {
		for (String ticker : B3AssetTestUtil.invalidStockTickers) {
			assertThrows(IllegalArgumentException.class, () -> new Stock(ticker));
		}
	}

	@Test
	void testNewStockWithValidTicker() {
		assertEquals("ABCD3", new Stock("ABCD3").getB3AssetData().getTicker());
		assertEquals("ABCD4", new Stock("ABCD4").getB3AssetData().getTicker());
		assertEquals("ABCD5", new Stock("ABCD5").getB3AssetData().getTicker());
		assertEquals("ABCD6", new Stock("ABCD6").getB3AssetData().getTicker());
		assertEquals("ABCD7", new Stock("ABCD7").getB3AssetData().getTicker());
		assertEquals("ABCD8", new Stock("ABCD8").getB3AssetData().getTicker());
		assertEquals("ABCD11", new Stock("ABCD11").getB3AssetData().getTicker());
	}

	@Test
	void testNewStockWithTickerInUppercase() {
		B3Asset asset = new Stock("abcd3");
		assertEquals("ABCD3", asset.getB3AssetData().getTicker());
		assertNotEquals("abcd3", asset.getB3AssetData().getTicker());
	}

	@Test
	void testB3AssetType() {
		assertEquals(B3AssetType.STOCK, new Stock("abcd3").getB3AssetData().getType());
	}
*/
}
