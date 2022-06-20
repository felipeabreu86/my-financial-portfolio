package portfolio.domain.usecase.b3;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import portfolio.domain.entity.b3.B3Asset;
import portfolio.domain.repository.B3AssetRepository;

/**
 * Class responsible for implementing the use case that lists all B3 assets
 * 
 * @author Felipe Abreu
 * @version 0.01
 * @since 0.01
 */
@Service
public class FindAllAssetsUsecase {

	/**
	 * B3 Asset Repository
	 */
	@Autowired
	private B3AssetRepository b3AssetRepository;

	/**
	 * Query the repository to search for all B3 assets registered in the database
	 * 
	 * @return List of all B3 assets
	 */
	public List<B3Asset> call() {
		return b3AssetRepository.findAll();
	}

}
