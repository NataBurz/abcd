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
import javax.persistence.OneToOne;

@Entity
public class Comment {
	
	@Id	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name = "textComment")
	private String textComment;
	@Column(name = "timeComment")
	private String timeComment;
	@Column(name = "dateComment")
	private String dateComment;
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "user_comment", joinColumns = 
	@JoinColumn(name = "fk_comment"), inverseJoinColumns = 
	@JoinColumn(name = "fk_user"))
	private List<User> users;
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "topic_comment", joinColumns = 
	@JoinColumn(name = "fk_comment"), inverseJoinColumns = 
	@JoinColumn(name = "fk_topic"))
	private List<Topic> topics;
	
	public Comment(){
		
	}

	public Comment(String textComment, String timeComment, String dateComment,
			List<User> users, List<Topic> topics) {
		this.textComment = textComment;
		this.timeComment = timeComment;
		this.dateComment = dateComment;
		this.users = users;
		this.topics = topics;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTextComment() {
		return textComment;
	}

	public void setTextComment(String textComment) {
		this.textComment = textComment;
	}

	public String getTimeComment() {
		return timeComment;
	}

	public void setTimeComment(String timeComment) {
		this.timeComment = timeComment;
	}

	public String getDateComment() {
		return dateComment;
	}

	public void setDateComment(String dateComment) {
		this.dateComment = dateComment;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<Topic> getTopics() {
		return topics;
	}

	public void setTopics(List<Topic> topics) {
		this.topics = topics;
	}

	
}
