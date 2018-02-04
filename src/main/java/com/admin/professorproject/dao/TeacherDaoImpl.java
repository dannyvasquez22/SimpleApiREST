package com.admin.professorproject.dao;

import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.admin.professorproject.model.Teacher;
import com.admin.professorproject.model.TeacherSocialMedia;

@Repository
@Transactional
public class TeacherDaoImpl extends AbstractSession implements TeacherDao {
	
	public void saveTeacher(Teacher teacher) {
		getSession().persist(teacher);
	}

	public void deleteTeacherById(Long idTeacher) {
		Teacher teacher = findTeacherByID(idTeacher);
		if (teacher != null) {
			Iterator<TeacherSocialMedia> i = teacher.getTeacherSocialMedia().iterator();
			while(i.hasNext()) {
				TeacherSocialMedia teacherSocialMedia = i.next();
				i.remove();
				getSession().delete(teacherSocialMedia);
			}
			teacher.getTeacherSocialMedia().clear();
			getSession().delete(teacher);
		}
	}

	public void updateTeacher(Teacher teacher) {
		getSession().update(teacher);
	}

	public List<Teacher> findAllTeachers() {		
		return getSession().createQuery("from Teacher").list();
	}

	public Teacher findTeacherByID(Long idTeacher) {
		return (Teacher) getSession().get(Teacher.class, idTeacher);
	}

	public Teacher findTeacherByName(String name) {
		return (Teacher) getSession().createQuery("from Teacher where name = :name").setString("name", name).uniqueResult();
	}

}
