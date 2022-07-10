package portfolio.dataprovider.repository;

import org.springframework.stereotype.Repository;

import portfolio.dataprovider.dao.UserDao;
import portfolio.domain.entity.user.User;
import portfolio.domain.repository.UserRepository;

/**
 * Implementation of the UserRepository interface
 * 
 * @author Felipe Abreu
 * @version 0.01
 * @since 0.01
 */
@Repository
public class UserRepositoryImpl implements UserRepository {

	/**
	 * Reference to JPA Repository for User entity
	 */
	private final UserDao userDao;

	/**
	 * Constructor Injection
	 * 
	 * @param userDao - Implementation of User DAO interface with JpaRepository
	 */
	public UserRepositoryImpl(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public User findByUsername(String username) {
		return userDao.findByUsername(username);
	}

}
