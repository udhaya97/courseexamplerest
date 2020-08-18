package com.courseexample.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.courseexample.model.Topic;
@Repository
public interface TopicRepo extends CrudRepository<Topic, String> {

	Topic findByToId(String toId);

}
