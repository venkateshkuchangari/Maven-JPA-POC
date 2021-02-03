package io.javabrains.springbootstarter.course;

import javax.persistence.Entity;
import javax.persistence.Id;

import io.javabrains.springbootstarter.topic.Topic;

@Entity
public class Course {

	@Id
	public String id;
	public String name;
	public String description;
	
	private Topic topic;
	
	public Course() {

		
	}
	
	public Course(String id, String name, String description, String topicId) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.setTopic(new Topic(topicId, "", ""));
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	
	
}
