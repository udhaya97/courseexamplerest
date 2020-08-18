package com.courseexample.service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.courseexample.model.Topic;
@Service
public interface TopicService {
	
boolean saveTopic(Topic topic);
	
	boolean update(Topic topic);
	
	List<Topic> getAllTopics();
	Topic getTopic(String tId);
	
	boolean deleteTopic(String tId);

}
