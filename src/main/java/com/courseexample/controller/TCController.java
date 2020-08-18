package com.courseexample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.courseexample.exception.DataNotFoundException;
import com.courseexample.model.Course;
import com.courseexample.model.Lesson;
import com.courseexample.model.Topic;
import com.courseexample.service.Courseservice;
import com.courseexample.service.LessonService;
import com.courseexample.service.TopicService;

@RestController
public class TCController {

	@Autowired
	TopicService tpService;
	@Autowired
	LessonService lessService;
	@Autowired
	Courseservice courseServ;

	@PostMapping("/topics")
	public ResponseEntity<?> saveTopic(@RequestBody(required = false) Topic topic) {
		if (topic == null) {
			
			return new ResponseEntity<>("no value present ! please  enter the details in request body ",
					HttpStatus.METHOD_NOT_ALLOWED);
		} else {
			System.out.println("controller value" + topic.getToId());
			tpService.saveTopic(topic);
			return new ResponseEntity<>("Data Addedd Successfully", HttpStatus.CREATED);
		}
	}

	@GetMapping("/topics")
	public ResponseEntity<?> getAllTopics() {

		List<Topic> lisTopic = tpService.getAllTopics();
		if (lisTopic.isEmpty()) {
			return new ResponseEntity<>("Values are empty ! please add one", HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<List<Topic>>(lisTopic, HttpStatus.OK);
	}

	@GetMapping("/topics/{tId}")
	public ResponseEntity<?> getTopic(@PathVariable String tId) {
		
			Topic top = tpService.getTopic(tId);

			if (top == null) {
				 return new ResponseEntity<>("please enter correct values ", HttpStatus.METHOD_NOT_ALLOWED);
						
				
			} 
			 return new ResponseEntity<>(top, HttpStatus.OK);

			
		
			
	}

	@PutMapping("/topics/{tId}")
	public ResponseEntity<?> updateTopic(@RequestBody(required = false) Topic topic, @PathVariable String tId) {
		if (topic == null || tId == null) {
			return new ResponseEntity<>("please enter correct values", HttpStatus.METHOD_NOT_ALLOWED);
		} else {
			Topic top = tpService.getTopic(tId);
			if(top !=null)
			{
			topic.setToId(tId);
			tpService.update(topic);

			return new ResponseEntity<>("updated successfully", HttpStatus.OK);
			}else
			{
				return new ResponseEntity<>("no value found for update", HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
	}

	@DeleteMapping("topics/{tId}")
	public ResponseEntity<?> deleteTopic(@PathVariable String tId) {
		if (tId == null) {
			return new ResponseEntity<>("Please enter the values", HttpStatus.METHOD_NOT_ALLOWED);
		} else {
			tpService.deleteTopic(tId);
			return new ResponseEntity<>("deleted successfully", HttpStatus.OK);
		}
	}

	@PostMapping("/topics/{tId}/courses")
	public ResponseEntity<?> saveCourse(@RequestBody(required = false) Course course, @PathVariable String tId) {
		// System.out.println("controller value"+topic.gettId());

		if (course == null || tId == null) {
			return new ResponseEntity<>("please enter the values in body or url",HttpStatus.METHOD_NOT_ALLOWED);
		} else {
			System.out.println("cou id controller "+course.getCoId() + "tId "+tId);
			Topic topi = new Topic();
			topi.setToId(tId);
			course.setTopic(topi);
			courseServ.saveCourse(course);
			return new ResponseEntity<>("Course Saved successfully successfully", HttpStatus.OK);
		}
	}

	@GetMapping("/topics/{tId}/courses")
	public ResponseEntity<?> getAllCourses(@PathVariable String tId) {
		if (tId == null) {
			return new ResponseEntity<>("please enter the id ", HttpStatus.BAD_REQUEST);
		} else {
			System.out.println(" id at controller " + tId);

			List<Course> lisCour = courseServ.getAllCourse(tId);
			

			if (lisCour.isEmpty()) {
				//System.out.println("get val "+lisCour.get(0).getCoName());
				return new ResponseEntity<>("No Value present for this id " +tId, HttpStatus.INTERNAL_SERVER_ERROR);
			} else {

				return new ResponseEntity<List<Course>>(lisCour, HttpStatus.OK);
			}
		}
	}

	@GetMapping("/topics/{tId}/courses/{cId}")
	public ResponseEntity<?> getCourse(@PathVariable String tId, @PathVariable String cId) {
		if (tId == null || cId == null) {
			return new ResponseEntity<>("Please enter the values ", HttpStatus.NOT_FOUND);
		}
		Course cou = courseServ.getCourse(tId, cId);
		if (cou == null) {
			return new ResponseEntity<>("Values are not available,please add values for this Id "+cId, HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			return new ResponseEntity<Course>(cou, HttpStatus.OK);
		}
	}

	@PutMapping("/topics/{tId}/courses/{cId}")
	public ResponseEntity<?> updateCourse(@RequestBody(required = false) Course course, @PathVariable String tId,
			@PathVariable String cId) {
		if (course == null || tId == null || cId == null) {
			return new ResponseEntity<>("please enter correct values ,either in body or url", HttpStatus.BAD_REQUEST);
		}
		Course cou = courseServ.getCourse(tId, cId);
		if(cou != null)
		{
		
		Topic toe = new Topic();
		toe.setToId(tId);
		course.setTopic(toe);
		course.setCoId(cId);
		courseServ.updateCourse(course);
		return new ResponseEntity<>("updated successfully", HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>("No Value found for updating", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("topics/{tId}/courses/{cId}")
	public ResponseEntity<?> deleteCourse(@PathVariable String tId, @PathVariable String cId) {
		if (tId == null || cId == null) {
			return new ResponseEntity<>("please enter the values ", HttpStatus.METHOD_NOT_ALLOWED);
		}
		courseServ.deleteCourse(tId, cId);
		return new ResponseEntity<>("deleted successfully", HttpStatus.OK);
	}

	@PostMapping("/topics/{tId}/courses/{cId}/lessons")
	public ResponseEntity<?> saveLessons(@RequestBody(required = false) Lesson lesson, @PathVariable String cId) {

		if (lesson == null || cId == null) {
			return new ResponseEntity<>("Please enter the values successfully", HttpStatus.METHOD_NOT_ALLOWED);
		}
		Course cour = new Course();
		cour.setCoId(cId);
		lesson.setCourse(cour);
		lessService.saveLesson(lesson);
		return new ResponseEntity<>("Data Addedd Successfully", HttpStatus.CREATED);
	}

	@GetMapping("/topics/{tId}/courses/{cId}/lessons")
	public ResponseEntity<?> getAllLessons(@PathVariable String cId) {
		if (cId == null) {
			return new ResponseEntity<>("Please enter the values", HttpStatus.METHOD_NOT_ALLOWED);
		}

		System.out.println(" id at controller " + cId);

		List<Lesson> lisLess = lessService.getAllLesson(cId);
		if (lisLess.isEmpty()) {
			return new ResponseEntity<>("Values are not present", HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<List<Lesson>>(lisLess, HttpStatus.OK);
	}

	@GetMapping("/topics/{tId}/courses/{cId}/lessons/{lId}")
	public ResponseEntity<?> getLessons(@PathVariable String cId, @PathVariable String lId) {
		if (cId == null || lId == null) {
			return new ResponseEntity<>("please enter correct values", HttpStatus.METHOD_NOT_ALLOWED);
		} else {
			Lesson less = lessService.getLesson(lId, cId);
			if (less == null) {
				return new ResponseEntity<>("no data available forthis id1 "+cId+ "id2 "+lId, HttpStatus.INTERNAL_SERVER_ERROR);
			}

			return new ResponseEntity<Lesson>(less, HttpStatus.OK);
		}
	}

	@PutMapping("/topics/{tId}/courses/{cId}/lessons/{lId}")
	public ResponseEntity<?> updateLessons(@RequestBody Lesson lesson, @PathVariable String lId,
			@PathVariable String cId) {
		if (lesson == null || lId == null || cId == null) {
			return new ResponseEntity<>("Please enter correct values",HttpStatus.METHOD_NOT_ALLOWED);
		} else {

			Lesson less = lessService.getLesson(lId, cId);
			if(less != null)
			{
			Course cor = new Course();
			cor.setCoId(cId);
			lesson.setLesId(lId);
			lesson.setCourse(cor);
			lessService.saveLesson(lesson);

			return new ResponseEntity<>("updated successfully", HttpStatus.OK);
			}else
			{
				return new ResponseEntity<>("no data found for update",  HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
	}

	@DeleteMapping("topics/{tId}/courses/{cId}/lessons/{lId}")
	public ResponseEntity<?> deleteLessons(@PathVariable String lId, @PathVariable String cId)

	{

		if (lId == null || cId == null) {
			return new ResponseEntity<>("Please enter correct values", HttpStatus.METHOD_NOT_ALLOWED);
		} else {
			lessService.deleteLesson(lId, cId);
			return new ResponseEntity<>("deleted successfully", HttpStatus.OK);
		}
	}
}
