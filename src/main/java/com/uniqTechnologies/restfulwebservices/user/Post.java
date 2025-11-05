package com.uniqTechnologies.restfulwebservices.user;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Post {

	@Id
	@GeneratedValue
	private Integer id;

	private String description;

	// This means that when the entity is loaded, the related entity is not loaded
	// immediately but only when it is accessed.
	// typically when using libraries like Jackson to convert Java objects to JSON
	// and vice versa.
	//Even though @JoinColumn is not explicitly defined, 
	//JPA will still create a foreign key column in the Post table
	//pointing to the User table (usually named user_id by default).
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonIgnore
	private User user;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getUser() {

		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return String.format("Post [id=%s, description=%s]", id, description);
	}

}
