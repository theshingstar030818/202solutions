package app.account;

import com.fasterxml.jackson.annotation.JsonIgnore;
import parse4j.ParseUser;

import java.time.Instant;

@SuppressWarnings("serial")
public class Account extends ParseUser implements java.io.Serializable {

	private Long id;

	private String email;

	@JsonIgnore
	private String password;

	private String role = "ROLE_USER";

	private Instant created;

    protected Account() {

	}

	public Account(String email, String password, String role) {
		this.email = email;
		this.password = password;
		this.role = role;
		this.created = Instant.now();
	}

	public Long getId() {
		return id;
	}

    public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Instant getCreated() {
		return created;
	}
}
