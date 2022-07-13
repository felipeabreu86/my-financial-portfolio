package portfolio.dataprovider.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import portfolio.dataprovider.dao.B3AssetDao;
import portfolio.dataprovider.model.b3.B3AssetModel;
import portfolio.domain.entity.b3.B3Asset;
import portfolio.domain.repository.B3AssetRepository;

/**
 * Implementation of the B3AssetRepository interface
 * 
 * @author Felipe Abreu
 * @version 0.01
 * @since 0.01
 */
@Component
public class B3AssetRepositoryImpl implements B3AssetRepository {

	private final B3AssetDao b3AssetDao;

	public B3AssetRepositoryImpl(B3AssetDao b3AssetDao) {
		this.b3AssetDao = b3AssetDao;
	}

	@Override
	public List<B3Asset> findAll() {
		return new ArrayList<>(b3AssetDao.findAll());
	}

	@Override
	public Optional<B3Asset> save(B3Asset asset) {
		B3Asset savedAsset = null;

		if (asset instanceof B3AssetModel) {
			B3AssetModel model = (B3AssetModel) asset;
			if (model.isValid()) {
				savedAsset = b3AssetDao.save(model);
			}
		}

		return Optional.ofNullable(savedAsset);
	}

}
