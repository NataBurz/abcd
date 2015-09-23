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
import javax.persistence.OneToOne;

@Entity
public class Topic {
	
	@Id	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name = "title")
	private String title;
	@Column(name = "text")
	private String text;
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "createTopic_id")
	private CreateTopic createTopic;
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "user_topic", joinColumns = 
	@JoinColumn(name = "fk_topic"), inverseJoinColumns = 
	@JoinColumn(name = "fk_user"))
	private List<User> users;
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "comment_topic", joinColumns = 
	@JoinColumn(name = "fk_topic"), inverseJoinColumns = 
	@JoinColumn(name = "fk_comment"))
	private List<Comment> comments;
	
	public Topic(){
		
	}

	public Topic(String title, String text, List<User> users,
			List<Comment> comments, CreateTopic createTopic) {
		this.title = title;
		this.text = text;
		this.users = users;
		this.comments = comments;
		this.createTopic = createTopic;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public CreateTopic getCreateTopic() {
		return createTopic;
	}

	public void setCreateTopic(CreateTopic createTopic) {
		this.createTopic = createTopic;
	}

	
}
