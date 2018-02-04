package com.admin.professorproject.dao;

import java.util.List;

import com.admin.professorproject.model.Teacher;

public interface TeacherDao {

	void saveTeacher(Teacher teacher);	
	void deleteTeacherById(Long idTeacher);
	void updateTeacher(Teacher teacher);
	
	List<Teacher> findAllTeachers();
	Teacher findTeacherByID(Long idTeacher);
	Teacher findTeacherByName(String name);
}
