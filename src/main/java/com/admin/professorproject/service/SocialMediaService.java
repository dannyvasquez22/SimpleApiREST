package com.admin.professorproject.service;

import java.util.List;

import com.admin.professorproject.model.SocialMedia;
import com.admin.professorproject.model.TeacherSocialMedia;

public interface SocialMediaService {

	void saveSocialMedia(SocialMedia socialMedia);
	void updateSocialMedia(SocialMedia socialMedia);
	void deleteSocialMedia(Long socialMedia);
	
	SocialMedia findSocialMediaByID(Long idSocialMedia);
	List<SocialMedia> getAllSocialMedia();
	SocialMedia findSocialMediaByName(String nameSocialMedia);

	TeacherSocialMedia findSocialMediaByIDAndNickname(Long idSocialMedia, String nickname);
	TeacherSocialMedia findSocialMediaByIDTeacherAndIDSocialMedia(Long idTeacher, Long idSocialMedia);
}
