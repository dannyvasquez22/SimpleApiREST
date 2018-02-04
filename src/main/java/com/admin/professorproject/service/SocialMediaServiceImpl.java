package com.admin.professorproject.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.professorproject.dao.SocialMediaDao;
import com.admin.professorproject.model.SocialMedia;
import com.admin.professorproject.model.TeacherSocialMedia;

@Service("socialMediaService")
@Transactional
public class SocialMediaServiceImpl implements SocialMediaService{

	@Autowired
	private SocialMediaDao _socialMediaDao;
	
	@Override
	public void saveSocialMedia(SocialMedia socialMedia) {
		_socialMediaDao.saveSocialMedia(socialMedia);
	}

	@Override
	public void updateSocialMedia(SocialMedia socialMedia) {
		_socialMediaDao.updateSocialMedia(socialMedia);
	}

	@Override
	public void deleteSocialMedia(Long socialMedia) {
		_socialMediaDao.deleteSocialMedia(socialMedia);
	}

	@Override
	public SocialMedia findSocialMediaByID(Long idSocialMedia) {
		return _socialMediaDao.findSocialMediaByID(idSocialMedia);
	}

	@Override
	public List<SocialMedia> getAllSocialMedia() {
		return _socialMediaDao.getAllSocialMedia();
	}

	@Override
	public SocialMedia findSocialMediaByName(String nameSocialMedia) {
		return _socialMediaDao.findSocialMediaByName(nameSocialMedia);
	}

	@Override
	public TeacherSocialMedia findSocialMediaByIDAndNickname(Long idSocialMedia, String nickname) {
		return _socialMediaDao.findSocialMediaByIDAndNickname(idSocialMedia, nickname);
	}

	@Override
	public TeacherSocialMedia findSocialMediaByIDTeacherAndIDSocialMedia(Long idTeacher, Long idSocialMedia) {
		return _socialMediaDao.findSocialMediaByIDTeacherAndIDSocialMedia(idTeacher, idSocialMedia);
	}

}
