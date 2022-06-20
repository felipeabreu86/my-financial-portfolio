package portfolio.dataprovider.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import portfolio.dataprovider.dao.B3AssetDao;
import portfolio.dataprovider.model.B3AssetModel;
import portfolio.domain.entity.b3.B3Asset;
import portfolio.domain.repository.B3AssetRepository;

@Repository
public class B3AssetRepositoryImpl implements B3AssetRepository {

	@Autowired
	private B3AssetDao b3AssetDao;

	@Override
	public List<B3Asset> findAll() {
		List<B3Asset> assets = new ArrayList<>();
		b3AssetDao.findAll().forEach(i -> assets.add(i));
		return assets;
	}

	@Override
	public void save(B3Asset asset) {
		B3AssetModel entity = (B3AssetModel) asset;
		b3AssetDao.save(entity);
	}

}
