package com.courseexample.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.courseexample.model.Course;
@Repository
@Transactional
public interface CourseRepo extends CrudRepository<Course, String> {

	Course findByCoId(String coId);
	//@Query(value = "select * from course where topic=?1",nativeQuery = true)
	List<Course> findByTopicToId(String topicToId);

	//@Query(value = "select * from course where c_id=?1 and topic=?2",nativeQuery = true)
	Course findByCoIdAndTopicToId(String coId,String topicToId);
	@Modifying
	
	//@Query(value = "delete from course where c_id=?1 and topic=?2",nativeQuery = true)
	void deleteByCoIdAndTopicToId(String coId, String topicToId);

}
