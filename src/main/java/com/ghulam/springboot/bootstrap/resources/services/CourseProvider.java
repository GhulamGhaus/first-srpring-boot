package com.ghulam.springboot.bootstrap.resources.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.ws.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class CourseProvider {
	
	Logger log = LogManager.getLogger();
	
	private List<Course> courses = new ArrayList<>(Arrays.asList(
			new Course("1", "Java", "Core java course"),
			 new Course("2", "JavaScript", "javaScript course"),
			 new Course("3", "Jee", "jee course")
			
			));
	
	
	public List<Course> getCources() {
		return courses;
		
			
	}

	public Course getCourseMatchById(String id) {
			return getCourseById(id);
		
	}
	
	private Course getCourseById(String id) {
		return courses.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		
	}

	public void addCourse(Course course) {
		log.info("input course {}", course);
		courses.add(course);
		log.info("After adding new course{}", courses);
	}

	public void deleteCourse(String id) {
		log.info("input course {}", id);	
		courses.removeIf(t->t.getId().equals(id));
		log.info("After delete new course{}", courses);
		
	}

}
