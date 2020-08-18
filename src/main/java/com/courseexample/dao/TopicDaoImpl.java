package com.courseexample.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.courseexample.model.Topic;
@Repository
public class TopicDaoImpl implements TopicDao {

	@Autowired
	TopicRepo toRepo;
	
	@Override
	public boolean saveTopic(Topic topic) {
		toRepo.save(topic);
		return true;
	}

	@Override
	public boolean update(Topic topic) {
		
		toRepo.save(topic);
		return true;
	}

	@Override
	public List<Topic> getAllTopics() {
		List<Topic> lisTopic = (List<Topic>) toRepo.findAll();
		return lisTopic;
	}

	@Override
	public Topic getTopic(String toId) {
		Topic top = toRepo.findByToId(toId);
		return top;
	}

	@Override
	public boolean deleteTopic(String tId) {
		toRepo.deleteById(tId);
		return true;
	}

}
