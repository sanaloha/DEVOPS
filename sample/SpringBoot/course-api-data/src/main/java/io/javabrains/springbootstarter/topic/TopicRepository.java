package io.javabrains.springbootstarter.topic;

import org.springframework.data.repository.CrudRepository;

public interface TopicRepository extends CrudRepository<Topic, String> {
	
	//This is custome repository provides all below methods implicitely
	//getTopic getAllTopics, addTopic, deleteTopic
	

}
