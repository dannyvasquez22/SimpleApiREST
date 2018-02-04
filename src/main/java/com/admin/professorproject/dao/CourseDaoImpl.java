package com.admin.professorproject.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.admin.professorproject.model.Course;

@Repository
@Transactional
public class CourseDaoImpl extends AbstractSession implements CourseDao {

	@Override
	public void saveCourse(Course course) {
		getSession().persist(course);
	}

	@Override
	public void updateCourse(Course course) {
		getSession().update(course);
	}

	@Override
	public void deleteCourse(Long idCourse) {
		Course course = findCourseByID(idCourse);
		if (course != null) {
			getSession().delete(course);
		}
	}

	@Override
	public Course findCourseByID(Long idCourse) {
		return (Course) getSession().get(Course.class, idCourse);
	}

	@Override
	public Course findCourseByName(String name) {
		return (Course) getSession().createQuery("from Course where name = :name").setParameter("name", name).uniqueResult();
	}

	@Override
	public List<Course> getAllCourses() {
		return (List<Course>) getSession().createQuery("from Course").list();
	}

	@Override
	public List<Course> findCourseByIdTeacher(Long idTeacher) {
		return (List<Course>) getSession().createQuery("from Course c join c.teacher t where t.idTeacher = :idTeacher").setParameter("idTeacher", idTeacher).list();
	}

}
