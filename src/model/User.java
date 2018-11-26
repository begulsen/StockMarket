package model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.data.annotation.Id;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@ApiModelProperty(notes = "user id")
	@Column(name = "user_id")
	private Integer id;
	@ApiModelProperty(notes = "login")
	@Column(name = "login")
	private String login;
	@ApiModelProperty(notes = "user mail")
	@Column(name = "user_mail")
	private String userMail;
	@ApiModelProperty(notes = "profile")
	@Column(name = "user_profile")
	private boolean profile;
	@ApiModelProperty(notes = "created date")
	@Column(name = "create_date")
	private Date createDate;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getUserMail() {
		return userMail;
	}
	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}
	public boolean getProfile() {
		return profile;
	}
	public void setProfile(boolean profile) {
		this.profile = profile;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	public static class UserBuilder {
		private String login;
		private String userMail;
		private boolean isAdmin;
		private Date createDate;
		
		public UserBuilder setLogin(String login) {
			this.login = login;
			return this;
		}
		
		public UserBuilder setUserMail(String userMail) {
			this.userMail = userMail;
			return this;
		}

		public UserBuilder setIsAdmin(boolean isAdmin) {
			this.isAdmin = isAdmin;
			return this;
		}
		
		public UserBuilder setCreateDate(Date createDate) {
			this.createDate = createDate;
			return this;
		}
		
		public User build() {
			User user = new User();
			user.login = this.login;
			user.userMail = this.userMail;
			user.profile = this.isAdmin;
			user.createDate = this.createDate;
			return user;
		}
	}
}
