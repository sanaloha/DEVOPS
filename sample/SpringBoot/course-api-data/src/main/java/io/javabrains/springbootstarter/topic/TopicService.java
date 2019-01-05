package io.javabrains.springbootstarter.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	/**
	 * Business Services are singleton in Spring
	 * when the application starts it detects in the class path with all the classes
	 * with this annotation make instance of it and register it. Spring sees this annotation it creates and instance of this class
	 * and register it with Spring and put into the memory. Whenever any class
	 * requesting this instance Spring provides via injection.
	 * **/
	@Autowired
	TopicRepository topicRepository;
	
	
	
	public List<Topic> getAllTopics(){
		List<Topic> topics = new ArrayList<>();
		topicRepository.findAll()
		.forEach(topics::add);
		return topics;
	}
	
	public Topic getTopic(String id){
	
		//return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		return topicRepository.findOne(id);
	}

	public void addTopic(Topic topic) {
		//topics.add(topic);
		topicRepository.save(topic);
		
	}

	public void updateTopic(Topic topic, String id) {
		/*
		for(int i =0; i < topics.size();i++){
			Topic t = topics.get(i);
			if(t.getId().equals(id)){
				topics.set(i, topic);
				return;
			}
		}*/
		
		topicRepository.save(topic);
	}

	public void deleteTopic(String id) {
		
		//topics.removeIf(t->t.getId().equals(id));
		topicRepository.delete(id);
	}
}
