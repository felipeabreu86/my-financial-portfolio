package portfolio.dataprovider.model.user;

import javax.persistence.Entity;
import javax.persistence.Table;

import portfolio.domain.entity.user.User;

@Entity
@Table(name = "users")
public class UserModel extends User {

}
