package io.javabrains.springbootstarter.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	/**
	 * Business Services are singleton in Spring when the application starts it detects in 
	 * the class path with all the classes with this annotation make instance of it and 
	 * register it. Spring sees this annotation it creates an instance of this class and
	 * register it with Spring and put into the memory. Whenever any class requesting this
	 * instance Spring provides via injection.
	 * **/
	
	
	
	private List<Topic> topics = new ArrayList<>(Arrays.asList(
			new Topic("Spring", "Spring Framework","Spring Desc"),
			new Topic("Java","Java Fe=ramework","Java desc"),
			new Topic("JavaScript","JS Framework","Js desc")
			));

	public List<Topic> getAllTopics(){
		
		return topics;
	}
	
	public Topic getTopic(String id){
	
		return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		
	}

	public void addTopic(Topic topic) {
		topics.add(topic);
		
	}

	public void updateTopic(Topic topic, String id) {
		
		for(int i =0; i < topics.size();i++){
			Topic t = topics.get(i);
			if(t.getId().equals(id)){
				topics.set(i, topic);
				return;
			}
		}
	}

	public void deleteTopic(String id) {
		
		topics.removeIf(t->t.getId().equals(id));
	}
}
