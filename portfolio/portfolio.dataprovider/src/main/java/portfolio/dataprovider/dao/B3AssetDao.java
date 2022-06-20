package portfolio.dataprovider.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import portfolio.dataprovider.model.B3AssetModel;

@Repository
public interface B3AssetDao extends JpaRepository<B3AssetModel, Long> {

}
