package portfolio.domain.usecase.b3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import portfolio.domain.entity.b3.B3Asset;
import portfolio.domain.entity.b3.B3AssetType;
import portfolio.domain.mock.B3AssetRepositoryImplMock;

class FindAllAssetsUsecaseTest {

	private static FindAllAssetsUsecase usecase;

	@BeforeAll
	static void beforeAll() {
		usecase = new FindAllAssetsUsecase(new B3AssetRepositoryImplMock());
	}

	@Test
	void testFindAllWithNoAsset() {
		B3AssetRepositoryImplMock.option = 0;
		List<B3Asset> lista = usecase.call();
		assertEquals(0, lista.size());
	}

	@Test
	void testFindAllWithOneAsset() {
		B3AssetRepositoryImplMock.option = 1;
		List<B3Asset> lista = usecase.call();
		assertEquals(1, lista.size());
		assertEquals("ABCD3", lista.get(0).getB3AssetData().getTicker());
		assertEquals(B3AssetType.STOCK, lista.get(0).getB3AssetData().getType());
	}

	@Test
	void testFindAllWithTwoAssets() {
		B3AssetRepositoryImplMock.option = 2;
		List<B3Asset> lista = usecase.call();
		assertEquals(2, lista.size());
		assertEquals("ABCD3", lista.get(0).getB3AssetData().getTicker());
		assertEquals(B3AssetType.STOCK, lista.get(0).getB3AssetData().getType());
		assertEquals("ABCD11", lista.get(1).getB3AssetData().getTicker());
		assertEquals(B3AssetType.REAL_ESTATE_FUND, lista.get(1).getB3AssetData().getType());
	}

}
