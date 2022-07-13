package portfolio.dataprovider.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import portfolio.dataprovider.model.b3.B3AssetModel;

/**
 * JPA Repository for B3 Asset
 * 
 * @author Felipe Abreu
 * @version 0.01
 * @since 0.01
 */
@Repository
public interface B3AssetDao extends JpaRepository<B3AssetModel, Long> {

}
