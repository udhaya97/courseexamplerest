package com.courseexample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.courseexample.dao.TopicDao;
import com.courseexample.model.Topic;
@Service
public class TopicServiceImpl implements TopicService {

	@Autowired
	
	TopicDao toDao;
	
	@Override
	public boolean saveTopic(Topic topic) {
		toDao.saveTopic(topic);
		return true;
	}

	@Override
	public boolean update(Topic topic) {
		toDao.saveTopic(topic);
		return false;
	}

	@Override
	public List<Topic> getAllTopics() {
		List<Topic> lisTopic = toDao.getAllTopics();
		return lisTopic;
	}

	@Override
	public Topic getTopic(String tId) {
		Topic top = toDao.getTopic(tId);
		return top;
	}

	@Override
	public boolean deleteTopic(String tId) {
		toDao.deleteTopic(tId);
		return true;
	}

}
