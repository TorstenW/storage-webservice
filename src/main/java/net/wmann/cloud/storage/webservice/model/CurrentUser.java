package net.wmann.cloud.storage.webservice.model;

import java.util.Set;

import net.wmann.cloud.storage.webservice.domain.UserEntity;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

public class CurrentUser extends User {

	private static final long serialVersionUID = -6151338025014019878L;
	
	private UserEntity user;

	public CurrentUser(UserEntity user) {
		super(user.getEmail(), user.getPasswordHash(), AuthorityUtils.createAuthorityList(
				user.getRoles().stream().map(u -> u.name()).toArray(String[]::new)));
		this.user = user;
	}

	public UserEntity getUser() {
		return user;
	}

	public Long getId() {
		return user.getId();
	}

	public Set<Role> getRole() {
		return user.getRoles();
	}

	@Override
	public String toString() {
		return "CurrentUser{" + "user=" + user + "} " + super.toString();
	}
}
