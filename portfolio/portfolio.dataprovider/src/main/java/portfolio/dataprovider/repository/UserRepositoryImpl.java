package portfolio.dataprovider.repository;

import org.springframework.stereotype.Component;

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
@Component
public class UserRepositoryImpl implements UserRepository {

	private final UserDao userDao;

	public UserRepositoryImpl(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public User findByUsername(String username) {
		return userDao.findByUsername(username);
	}

}
