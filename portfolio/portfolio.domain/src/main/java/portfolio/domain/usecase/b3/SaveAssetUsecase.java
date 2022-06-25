package portfolio.domain.usecase.b3;

import org.springframework.stereotype.Service;

import portfolio.domain.entity.b3.B3Asset;
import portfolio.domain.repository.B3AssetRepository;

/**
 * Class responsible for implementing the use case that saves a new B3 asset
 * 
 * @author Felipe Abreu
 * @version 0.01
 * @since 0.01
 */
@Service
public class SaveAssetUsecase {

	/**
	 * Reference to B3 Asset Repository implementation
	 */
	private final B3AssetRepository b3AssetRepository;

	/**
	 * Constructor Injection
	 * 
	 * @param b3AssetRepository - Implementation of B3 Asset Repository interface
	 */
	public SaveAssetUsecase(B3AssetRepository b3AssetRepository) {
		this.b3AssetRepository = b3AssetRepository;
	}

	/**
	 * Saves a new B3 asset in the database through the repository
	 * 
	 * @param asset - B3 asset to be saved in the database
	 * @return B3Asset saved in database
	 */
	public B3Asset call(B3Asset asset) {
		if (asset == null || asset.getB3AssetData() == null) {
			throw new NullPointerException("B3 Asset and its data must not be null.");
		}
		return b3AssetRepository.save(asset);
	}

}
