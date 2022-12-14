package dev.boscolo.hroauth.entities;

import java.io.Serializable;
import java.util.Objects;

public class Role implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String authority;

	public Role() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	@Override
	public int hashCode() {
		return Objects.hash(authority, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Role other = (Role) obj;
		return Objects.equals(authority, other.authority) && Objects.equals(id, other.id);
	}

}