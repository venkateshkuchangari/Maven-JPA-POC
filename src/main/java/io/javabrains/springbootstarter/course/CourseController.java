package io.javabrains.springbootstarter.course;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.springbootstarter.topic.Topic;

@RestController
public class CourseController {
	
	@Autowired
	private CourseService courseService;

	@RequestMapping("/topics")
	public List<Course> getListCourses() {
		return courseService.getAllCourses();
	}
	
	@RequestMapping("/topics/{topicId}/courses/{courseId}")
	public Course getCourse(@PathVariable String courseId) {
		return courseService.getSpecificCourse(courseId);
	}
	
	@RequestMapping(method=RequestMethod.POST ,value="/topics/{topicId}/courses")
	public void postCourse(@RequestBody Course course, @PathVariable String topicId) {
		course.setTopic(new Topic(topicId, "", ""));
		courseService.postSpecificCourse(course);
	}
	
	@RequestMapping(method=RequestMethod.PUT ,value="/topics/{topicId}/courses/{courseId}")
	public void putCourse(@RequestBody Course course, @PathVariable String topicId , @PathVariable String courseId) {
		course.setTopic(new Topic(topicId, "", ""));
		courseService.updateSpecificCourse(course);
	}
	
	@RequestMapping(method=RequestMethod.DELETE ,value="/topics/{topicId}/courses/{courseId}")
	public void deleteCourse(@PathVariable String courseId) {
		 courseService.deleteCourse(courseId);
	}
	
}
