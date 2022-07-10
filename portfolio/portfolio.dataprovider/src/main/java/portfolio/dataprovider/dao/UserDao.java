package portfolio.dataprovider.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import portfolio.domain.entity.user.User;

/**
 * JPA Repository for Users
 * 
 * @author Felipe Abreu
 * @version 0.01
 * @since 0.01
 */
@Repository
public interface UserDao extends JpaRepository<User, Long> {

	User findByUsername(String username);

}
