package com.admin.professorproject.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.professorproject.dao.TeacherDao;
import com.admin.professorproject.model.Teacher;

@Service("teacherService")
@Transactional
public class TeacherServiceImpl implements TeacherService {

	@Autowired
	private TeacherDao _teacherDao;
	
	@Override
	public void saveTeacher(Teacher teacher) {
		_teacherDao.saveTeacher(teacher);
	}

	@Override
	public void deleteTeacherById(Long idTeacher) {
		_teacherDao.deleteTeacherById(idTeacher);
	}

	@Override
	public void updateTeacher(Teacher teacher) {
		_teacherDao.updateTeacher(teacher);
	}

	@Override
	public List<Teacher> findAllTeachers() {
		return _teacherDao.findAllTeachers();
	}

	@Override
	public Teacher findTeacherByID(Long idTeacher) {
		return _teacherDao.findTeacherByID(idTeacher);
	}

	@Override
	public Teacher findTeacherByName(String name) {
		return _teacherDao.findTeacherByName(name);
	}

}
