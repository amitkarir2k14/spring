package app.pojos;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.sun.istack.internal.NotNull;

@Component
public class Spitter {

	@NotNull
	private String email;
	private long id;
	@NotNull
	private String lastName;
	@NotNull
	private String username;
	@NotNull
	private String password;
	@NotNull
	private String profilePicPath;
	private Date registrationDate;

	public Spitter(long id, String firstName, String lastName, String username, String password, String email, Date registrationDate) {
		this.id=id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.setEmail(email);
		this.registrationDate = registrationDate;

	}

	public Spitter() {
		// TODO Auto-generated constructor stub
	}

	@NotNull
	private String firstName;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getProfilePicPath() {
		return profilePicPath;
	}

	public void setProfilePicPath(String profilePicPath) {
		this.profilePicPath = profilePicPath;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	

}
