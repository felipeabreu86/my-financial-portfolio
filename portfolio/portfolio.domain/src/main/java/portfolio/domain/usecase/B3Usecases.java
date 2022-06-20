package portfolio.domain.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import portfolio.domain.usecase.b3.FindAllAssetsUsecase;
import portfolio.domain.usecase.b3.SaveAssetUsecase;

/**
 * Class responsible for gathering all use cases related to B3 assets
 * 
 * @author Felipe Abreu
 * @version 0.01
 * @since 0.01
 */
@Service
public class B3Usecases {

	/**
	 * Reference to 'find all assets' use case implementation
	 */
	@Autowired
	public FindAllAssetsUsecase findAllAssetsUseCase;

	/**
	 * Reference to 'save asset' use case implementation
	 */
	@Autowired
	public SaveAssetUsecase saveAssetUsecase;

}
