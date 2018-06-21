package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Utilisateur")
public class User {

	@Id
	@GeneratedValue
	@Column(name="ID_USER")
	public Long id;
	public String login;
	public String password;
	public String role;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String login, String password, String role) {
		super();
		this.login = login;
		this.password = password;
		this.role = role;
	}
	
}
