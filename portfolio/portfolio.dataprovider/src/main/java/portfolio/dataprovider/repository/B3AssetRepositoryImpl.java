package portfolio.dataprovider.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import portfolio.dataprovider.dao.B3AssetDao;
import portfolio.domain.entity.b3.B3Asset;
import portfolio.domain.repository.B3AssetRepository;

/**
 * Implementation of the B3AssetRepository interface
 * 
 * @author Felipe Abreu
 * @version 0.01
 * @since 0.01
 */
@Repository
public class B3AssetRepositoryImpl implements B3AssetRepository {

	/**
	 * Reference to JPA Repository for B3AssetModel entity
	 */
	private final B3AssetDao b3AssetDao;

	/**
	 * Constructor Injection
	 * 
	 * @param b3AssetDao - Implementation of B3 Asset DAO interface with
	 *                   JpaRepository
	 */
	public B3AssetRepositoryImpl(B3AssetDao b3AssetDao) {
		this.b3AssetDao = b3AssetDao;
	}

	@Override
	public List<B3Asset> findAll() {
		return b3AssetDao.findAll();
	}

	@Override
	public B3Asset save(B3Asset asset) {
		return b3AssetDao.save(asset);
	}

}
