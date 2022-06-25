package portfolio.domain.mock;

import java.util.ArrayList;
import java.util.List;

import portfolio.domain.entity.b3.B3Asset;
import portfolio.domain.entity.b3.RealEstateFund;
import portfolio.domain.entity.b3.Stock;
import portfolio.domain.repository.B3AssetRepository;

/**
 * Mock for the implementation of B3AssetRepository interface
 */
public class B3AssetRepositoryImplMock implements B3AssetRepository {

	public static int option;

	@Override
	public List<B3Asset> findAll() {
		ArrayList<B3Asset> lista = new ArrayList<B3Asset>();
		if (option == 1) {
			lista.add(new Stock("ABCD3"));
		} else if (option == 2) {
			lista.add(new Stock("ABCD3"));
			lista.add(new RealEstateFund("ABCD11"));
		}
		return lista;
	}

	@Override
	public B3Asset save(B3Asset asset) {
		if (asset == null) {
			throw new NullPointerException();
		}
		return asset;
	}

}