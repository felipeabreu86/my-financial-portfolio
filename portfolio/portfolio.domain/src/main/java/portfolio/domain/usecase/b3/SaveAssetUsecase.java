package portfolio.domain.usecase.b3;

import org.springframework.beans.factory.annotation.Autowired;
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
	 * B3 Asset Repository
	 */
	@Autowired
	private B3AssetRepository b3AssetRepository;

	/**
	 * Saves a new B3 asset in the database through the repository
	 * 
	 * @param asset - B3 asset to be saved in the database
	 */
	public void call(B3Asset asset) {
		b3AssetRepository.save(asset);
	}

}
