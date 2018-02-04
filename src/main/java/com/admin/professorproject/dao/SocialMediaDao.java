package com.admin.professorproject.dao;

import java.util.List;

import com.admin.professorproject.model.SocialMedia;
import com.admin.professorproject.model.TeacherSocialMedia;

public interface SocialMediaDao {
	
	void saveSocialMedia(SocialMedia socialMedia);
	void updateSocialMedia(SocialMedia socialMedia);
	void deleteSocialMedia(Long socialMedia);
	
	SocialMedia findSocialMediaByID(Long idSocialMedia);
	List<SocialMedia> getAllSocialMedia();
	SocialMedia findSocialMediaByName(String nameSocialMedia);

	TeacherSocialMedia findSocialMediaByIDAndNickname(Long idSocialMedia, String nickname);
	
	TeacherSocialMedia findSocialMediaByIDTeacherAndIDSocialMedia(Long idTeacher, Long idSocialMedia);
}
