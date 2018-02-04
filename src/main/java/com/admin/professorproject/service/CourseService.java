package com.admin.professorproject.service;

import java.util.List;

import com.admin.professorproject.model.Course;

public interface CourseService {

	void saveCourse(Course course);
	void updateCourse(Course course);
	void deleteCourse(Long idCourse);
	
	Course findCourseByID(Long idCourse);
	Course findCourseByName(String name);
	List<Course> findCourseByIdTeacher(Long idTeacher);
	List<Course> getAllCourses();
}
