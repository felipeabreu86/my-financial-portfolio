package portfolio.domain.repository;

import java.util.List;

import portfolio.domain.entity.b3.B3Asset;

/**
 * Interface that exposes all the features to be implemented regarding the
 * repository of B3 assets
 * 
 * @author Felipe Abreu
 * @version 0.01
 * @since 0.01
 */
public interface B3AssetRepository {

	/**
	 * Performs a database search to bring up a list of all B3 assets
	 * 
	 * @return List of all B3 assets
	 */
	List<B3Asset> findAll();

	/**
	 * Saves a new B3 asset in the database
	 * 
	 * @param asset - B3 asset to be saved in the database
	 */
	void save(B3Asset asset);

}
