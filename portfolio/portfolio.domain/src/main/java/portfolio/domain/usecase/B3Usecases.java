package portfolio.domain.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import portfolio.domain.usecase.b3.FindAllAssetsUsecase;
import portfolio.domain.usecase.b3.SaveAssetUsecase;

/**
 * Class responsible for gathering all use cases related to B3 assets
 * 
 * @author Felipe Abreu
 * @version 0.01
 * @since 0.01
 */
@Component
public class B3Usecases {

	@Autowired
	public FindAllAssetsUsecase findAllAssetsUseCase;

	@Autowired
	public SaveAssetUsecase saveAssetUsecase;

}
