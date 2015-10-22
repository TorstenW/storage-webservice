package net.wmann.cloud.storage.webservice.domain;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import net.wmann.cloud.storage.webservice.domain.converter.LocalDateTimeConverter;
import net.wmann.cloud.storage.webservice.model.Role;

@Entity
@Table(name="users")
public class UserEntity {
	
	@Id
	@GeneratedValue
	@Column(name = "id", nullable = false)
	private Long id;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "email", nullable = false, unique = true)
    private String email;
	
	@Column(name = "password_hash", nullable = false)
    private String passwordHash;
	
	@Column(name = "activated", nullable = false)
	private boolean activated;
	
	@Column(name = "suspended", nullable = false)
	private boolean suspended = false;
	
	@Convert(converter = LocalDateTimeConverter.class)
	@Column(name = "created", nullable = false, updatable = false)
	private LocalDateTime created;
	
	@Convert(converter = LocalDateTimeConverter.class)
	@Column(name = "updated", nullable = false)
	private LocalDateTime updated;
	
	@ElementCollection(targetClass=Role.class, fetch = FetchType.EAGER)
	@JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
	@Enumerated(EnumType.STRING)
	@Column(name = "roles", nullable = false)
	private Set<Role> roles = new HashSet<>();
	
	public Long getId() {
		return id;
	}

	protected void setId(Long id) {
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

	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public boolean isActivated() {
		return activated;
	}

	public void setActivated(boolean activated) {
		this.activated = activated;
	}

	public boolean isSuspended() {
		return suspended;
	}

	public void setSuspended(boolean suspended) {
		this.suspended = suspended;
	}

	public LocalDateTime getCreated() {
		return created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

	public LocalDateTime getUpdated() {
		return updated;
	}

	public void setUpdated(LocalDateTime updated) {
		this.updated = updated;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	@PrePersist
	private void onCreate() {
		this.setCreated(LocalDateTime.now());
		this.setUpdated(this.getCreated());
	}
	
	@PreUpdate
	private void onUpdate() {
		this.setUpdated(LocalDateTime.now());
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserEntity [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", email=");
		builder.append(email);
		builder.append(", activated=");
		builder.append(activated);
		builder.append(", suspended=");
		builder.append(suspended);
		builder.append(", roles=");
		builder.append(roles);
		builder.append("]");
		return builder.toString();
	}

}
