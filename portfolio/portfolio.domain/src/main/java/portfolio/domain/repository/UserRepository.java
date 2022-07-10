package portfolio.domain.repository;

import portfolio.domain.entity.user.User;

/**
 * Interface that exposes all the features to be implemented regarding the
 * repository of users
 * 
 * @author Felipe Abreu
 * @version 0.01
 * @since 0.01
 */
public interface UserRepository {

	User findByUsername(String username);

}
