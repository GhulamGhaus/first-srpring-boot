package com.ghulam.springboot.bootstrap.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ghulam.springboot.bootstrap.resources.services.Course;
import com.ghulam.springboot.bootstrap.resources.services.CourseProvider;

@RestController
public class SpringBootResources {
	
	@Autowired
	CourseProvider courseProvider;
	
	@RequestMapping("/course")
	public String getCourse() {
		 return "Java";
		
	}
	
	@RequestMapping("/courses")
	public List<Course> getCources() {
		return courseProvider.getCources();
	}
	
	
	@RequestMapping(value = "/courses/{id}", method = RequestMethod.GET, produces = "application/json")
	public  ResponseEntity<Course> getMatcheCourse(@PathVariable String id) {
	
		Course course = null;
		try {
			course = courseProvider.getCourseMatchById(id);
		} catch(Exception e) {
			return new ResponseEntity<Course>(course, HttpStatus.EXPECTATION_FAILED);
		}
		
		return new ResponseEntity<Course>(course, HttpStatus.ACCEPTED);
	
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/course")
	public void addCourse(@RequestBody final Course course) {
		courseProvider.addCourse(course);
	}

	@RequestMapping(method=RequestMethod.DELETE, value= "/courses/{id}")
	public void deleteCourse(@PathVariable String id) {
		courseProvider.deleteCourse(id);
	}
}
