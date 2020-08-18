package com.courseexample.dao;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.courseexample.model.Topic;
@Repository
public interface TopicDao {
	
	
	boolean saveTopic(Topic topic);
	
	boolean update(Topic topic);
	
	List<Topic> getAllTopics();
	Topic getTopic(String tId);
	
	boolean deleteTopic(String tId);
	

}
