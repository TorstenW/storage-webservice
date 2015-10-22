package net.wmann.cloud.storage.webservice.model.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import net.wmann.cloud.storage.webservice.model.Role;

public class UserDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String name;
	
    private String email;
    
    private Set<Role> roles;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Role> getRoles() {
		return roles == null ? new HashSet<Role>() : roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserDto [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", email=");
		builder.append(email);
		builder.append(", roles=");
		builder.append(roles);
		builder.append("]");
		return builder.toString();
	}

}
