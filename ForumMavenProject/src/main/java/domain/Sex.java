package domain;
	
	import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Entity;

@Entity
	public class Sex {
		
		@Id	
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private int id;
		@Column(name = "sex")
		private String sex;
		@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "sex")
		private List<User> users;
		
		public Sex(){
			
		}

		public Sex(String sex, List<User> users) {
			this.sex = sex;
			this.users = users;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getSex() {
			return sex;
		}

		public void setSex(String sex) {
			this.sex = sex;
		}

		public List<User> getUsers() {
			return users;
		}

		public void setUsers(List<User> users) {
			this.users = users;
		}

}
