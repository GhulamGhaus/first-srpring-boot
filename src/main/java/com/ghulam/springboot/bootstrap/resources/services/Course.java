package com.ghulam.springboot.bootstrap.resources.services;

import org.springframework.stereotype.Service;

@Service
public class Course {
 private String id;
 private String name;
 private String description;
 
 
 public Course() {
	 
	} 
 
@Override
public String toString() {
	return "Course [id=" + id + ", name=" + name + ", description=" + description + "]";
}

public Course(String id, String name, String description) {
	super();
	this.id = id;
	this.name = name;
	this.description = description;
}


public String getId() {
	return id;
}
public String getName() {
	return name;
}
public String getDescription() {
	return description;
}
public void setId(String id) {
	this.id = id;
}
public void setName(String name) {
	this.name = name;
}
public void setDescription(String description) {
	this.description = description;
}
	
	
}
