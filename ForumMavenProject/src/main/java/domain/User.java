package domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity

public class User {
	
		
		@Id	
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private int id;
		@Column(name = "nickname")
		private String nickname;
		@Column(name = "login")
		private String login;
		@Column(name = "password")
		private String password;
		@Column(name = "registrationDate")
		private String registrationDate;
		@Column(name = "skype")
		private String skype;
		@Column(name = "age")
		private int age;
		@ManyToOne
		@JoinColumn
		private Sex sex;
		@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
		@JoinTable(name = "topic_user", joinColumns = 
		@JoinColumn(name = "fk_user"), inverseJoinColumns = 
		@JoinColumn(name = "fk_topic"))
		private List<Topic> topics;
		@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
		@JoinTable(name = "comment_user", joinColumns = 
		@JoinColumn(name = "fk_user"), inverseJoinColumns = 
		@JoinColumn(name = "fk_comment"))
		private List<Comment> comments;
	
	public User(){
		
	}

	public User(String nickname, String login, String password,
			String registrationDate, String skype, int age, Sex sex) {
		this.nickname = nickname;
		this.login = login;
		this.password = password;
		this.registrationDate = registrationDate;
		this.skype = skype;
		this.age = age;
		this.sex = sex;
		this.topics = topics;
		this.comments = comments;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
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

	public String getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(String registrationDate) {
		this.registrationDate = registrationDate;
	}

	public String getSkype() {
		return skype;
	}

	public void setSkype(String skype) {
		this.skype = skype;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}
	
	public List<Topic> getTopics() {
		return topics;
	}

	public void setTopics(List<Topic> topics) {
		this.topics = topics;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

}
