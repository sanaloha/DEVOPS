package io.javabrains.springbootstarter.topic;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {
	
	@Autowired
	TopicService topicService;
	//Spring sees it, check registry for its instance and inject the instance of service here.
	
	@RequestMapping("/topics")
	public List<Topic> getallTopics(){
		
		return topicService.getAllTopics();
		/*return Arrays.asList(
				new Topic("Spring", "Spring Framework","Spring Desc"),
				new Topic("Java","Java Fe=ramework","Java desc"),
				new Topic("JavaScript","JS Framework","Js desc")
				);*/
				
	}
	@RequestMapping("/topics/{id}")
	public Topic getTopic(@PathVariable String id){
		
		return topicService.getTopic(id);
	}
	
	
	@RequestMapping(method=RequestMethod.POST, value="/topics")
	public void addTopic(@RequestBody Topic topic){ 
		/**pick this instance from the request body Tells Spring MVC that ur req payload
		 * is going to contain a json representation of this Topic instance, u r asking 
		 * spring mvc to take this request body and convert it into the Topic instance and
		 * pass it to the addTopic method when this url is hit with the Post method args 
		 * tell spring mvc to get the request body and convert it to topic instance, spring
		 * mvc is smart enough to get the topic object from request payload and convert to 
		 * topic instance Get the post body, convert it into a topic instance and then 
		 * add that in the Topic Service **/
		
		
		topicService.addTopic(topic);
		}
	@RequestMapping(method=RequestMethod.PUT, value="/topics/{id}")
	public void updateTopic(@RequestBody Topic topic, @PathVariable String id){
		
		topicService.updateTopic(topic, id );
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{id}")
	public void deleteTopic(@PathVariable String id){
		
		topicService.deleteTopic(id);
	}
	
	

}
