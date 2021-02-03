package io.javabrains.springbootstarter.course;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courserepo;
	
//	private List<Course> courses = new ArrayList<> ( Arrays.asList(
//			new Course("Spring","Spring boot","Spring boot framework"),
//			new Course("UI","Angular","Angular framework")
//			)
//	);
	public List<Course> getAllCourses() {
//		return topics;
		List<Course> courses = new ArrayList<>();
		courserepo.findAll().forEach(courses:: add);
		return courses;
	}
	
	public Course getSpecificCourse(String courseId) {
//	public Optional<Topic> getSpecificTopic(String id) {
//		return topics.stream().filter(ele -> ele.getId().equals(id)).findFirst().get();
		return courserepo.findById(courseId);
	}

	public void postSpecificCourse(Course course) {
//		topics.add(topic);
		courserepo.save(course);
	}

	public void updateSpecificCourse(Course course
//			, String id
			) {
//		for(int i=0; i < topics.size(); i++) {
//			Topic t = topics.get(i);
//			if(t.getId().equals(id)) {
//			   topics.set(i, topic);
//				return;
//			}
//		}
		courserepo.save(course);
	}

	public void deleteCourse(String id) {
		
		// Approach - I
//		for(int i=0; i < topics.size(); i++) {
//			Topic t = topics.get(i);
//			if(t.getId().equals(id)) {
//				topics.remove(i);
//				return;
//			}
//		}
		
		// Approach - II
//		topics.removeIf(t -> t.getId().equals(id));
		courserepo.deleteById(id);
	}

}
