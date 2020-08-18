package com.courseexample.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.courseexample.model.Lesson;
@Repository
@Transactional
public interface LessonRepo extends CrudRepository<Lesson, String> {

	
	Lesson findByLesId(String lesId);
	//@Query(value = "select * from course where topic=?1",nativeQuery = true)
	List<Lesson> findByCourseCoId(String courseCoId);

	//@Query(value = "select * from course where c_id=?1 and topic=?2",nativeQuery = true)
	Lesson findByLesIdAndCourseCoId(String lesId,String courseCoId);
	@Modifying
	
	//@Query(value = "delete from course where c_id=?1 and topic=?2",nativeQuery = true)
	void deleteByLesIdAndCourseCoId(String lesId, String courseCoId);
}
