package com.eduardoPortfolio.springForum.models;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class User {
	
	private Long id;
	@Size(max=128) @NotNull @NotEmpty
	private String name;
	@Email(message="This is not a valid email") @NotNull @NotEmpty
	private String email;
	@NotNull
	private Date registryDate;
	@NotNull @NotEmpty
	@Size(min=8, max=32, message="Only accept min. 8 and max. 32 characters")
	private String login;
	private String password;
	
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
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
