package com.admin.professorproject.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriComponentsBuilder;

import com.admin.professorproject.model.Course;
import com.admin.professorproject.service.CourseService;
import com.admin.professorproject.util.CustomErrorType;

@Controller
@RequestMapping("/v1")
public class CourseController {

	@Autowired
	CourseService _courseService;
	
	//GET
	@RequestMapping(value="/courses", method=RequestMethod.GET, headers="Accept=application/json")
	public ResponseEntity<List<Course>> getCourses(@RequestParam(value="name", required=false) String name, @RequestParam(value="id_teacher", required=false) Long id_teacher) {
		List<Course> courses = new ArrayList<Course>();
		
		if (id_teacher != null) {
			courses = _courseService.findCourseByIdTeacher(id_teacher);
			
			if (courses.isEmpty()) {
				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}
		}
		
		if (name != null) {
			Course course = _courseService.findCourseByName(name);
			if (course == null) {
				return new ResponseEntity(HttpStatus.NOT_FOUND);
			}
			
			courses.add(course);
		}		
		
		
		if (name == null && id_teacher == null) {
			courses = _courseService.getAllCourses();
			
			if (courses.isEmpty()) {
				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}			
		}			
		
		return new ResponseEntity<List<Course>>(courses, HttpStatus.OK);
	}
	
	//GET BY ID
	@RequestMapping(value="/courses/{id}", method=RequestMethod.GET, headers="Accept=application/json")
	public ResponseEntity<Course> getCourseByID(@PathVariable("id") Long idCourse) {
		if (idCourse == null || idCourse <= 0) {
			return new ResponseEntity(new CustomErrorType("idCourse is required."), HttpStatus.CONFLICT);
		}
		
		Course course = _courseService.findCourseByID(idCourse);
		if (course == null ) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<Course>(course, HttpStatus.OK);
	}
	
	//CREATE
	@RequestMapping(value="/courses", method=RequestMethod.POST, headers="Accept=application/json")
	public ResponseEntity<?> createCourse(@RequestBody Course course, UriComponentsBuilder uriComponentBuilder) {
		if(_courseService.findCourseByName(course.getName()) != null) {
			return new ResponseEntity(new CustomErrorType("Unable to create. A course with name " + course.getName() + " already exists."), HttpStatus.CONFLICT);
		}
		
		_courseService.saveCourse(course);
		
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uriComponentBuilder.path("/v1/courses/{id}")
				.buildAndExpand(course.getIdCourse())
				.toUri());
		
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}
	
	//UPDATE
	@RequestMapping(value="/courses/{id}", method=RequestMethod.PATCH, headers="Accept=application/json")
	public ResponseEntity<Course> updateCourse(@PathVariable("id") Long idCourse, @RequestBody Course course) {
		Course currentCourse = _courseService.findCourseByID(idCourse);
		
		if (currentCourse == null ) {
			return new ResponseEntity(new CustomErrorType("Unable to update. Course with id " + idCourse + " not found."), HttpStatus.NOT_FOUND);
		}
		
		currentCourse.setName(course.getName());
		currentCourse.setThemes(course.getThemes());
		currentCourse.setProject(course.getProject());
//		currentCourse.setTeacher(course.getTeacher());
		
		_courseService.updateCourse(currentCourse);
		
		
		return new ResponseEntity<Course>(currentCourse, HttpStatus.OK);
	}
	
	//DELETE
	@RequestMapping(value="/courses/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<?> deleteCourse(@PathVariable("id") Long idCourse) {
		Course course = _courseService.findCourseByID(idCourse);
		if (course == null) {
			return new ResponseEntity(new CustomErrorType("Unable to delete. Course with id " + idCourse + " not found."), HttpStatus.NOT_FOUND);
		}
		
		_courseService.deleteCourse(idCourse);
		return new ResponseEntity<Course>(HttpStatus.OK); 
	}
}
