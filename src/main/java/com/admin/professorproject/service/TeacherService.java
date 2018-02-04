package com.admin.professorproject.service;

import java.util.List;

import com.admin.professorproject.model.Teacher;

public interface TeacherService {

	void saveTeacher(Teacher teacher);	
	void deleteTeacherById(Long idTeacher);
	void updateTeacher(Teacher teacher);
	
	List<Teacher> findAllTeachers();
	Teacher findTeacherByID(Long idTeacher);
	Teacher findTeacherByName(String name);
}
