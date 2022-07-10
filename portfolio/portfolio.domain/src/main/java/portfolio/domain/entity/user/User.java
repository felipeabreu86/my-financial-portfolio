package portfolio.domain.entity.user;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class User {

	@Id
	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;

	@Column(name = "enabled")
	private Boolean enabled;

	public String getUsername() {
		return this.username;
	}

	public String getPassword() {
		return this.password;
	}

	public Boolean getEnabled() {
		return this.enabled;
	}

}