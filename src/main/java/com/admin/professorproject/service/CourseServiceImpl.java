package com.admin.professorproject.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.professorproject.dao.CourseDao;
import com.admin.professorproject.model.Course;

@Service("courseService")
@Transactional
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseDao _courseDao;
	
	@Override
	public void saveCourse(Course course) {
		_courseDao.saveCourse(course);
	}

	@Override
	public void updateCourse(Course course) {
		_courseDao.updateCourse(course);
	}

	@Override
	public void deleteCourse(Long idCourse) {
		_courseDao.deleteCourse(idCourse);
	}

	@Override
	public Course findCourseByID(Long idCourse) {
		return _courseDao.findCourseByID(idCourse);
	}

	@Override
	public Course findCourseByName(String name) {
		return _courseDao.findCourseByName(name);
	}

	@Override
	public List<Course> findCourseByIdTeacher(Long idTeacher) {
		return _courseDao.findCourseByIdTeacher(idTeacher);
	}

	@Override
	public List<Course> getAllCourses() {
		return _courseDao.getAllCourses();
	}

}
