package com.admin.professorproject.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.admin.professorproject.model.SocialMedia;
import com.admin.professorproject.model.TeacherSocialMedia;

@Repository
@Transactional
public class SocialMediaDaoImpl extends AbstractSession implements SocialMediaDao {

	public void saveSocialMedia(SocialMedia socialMedia) {
		getSession().persist(socialMedia);
	}

	public void updateSocialMedia(SocialMedia socialMedia) {
		getSession().update(socialMedia);
	}

	public void deleteSocialMedia(Long idSocialMedia) {
		SocialMedia socialMedia = findSocialMediaByID(idSocialMedia);
		if (socialMedia != null) {
			getSession().delete(socialMedia);
		}		
	}

	public SocialMedia findSocialMediaByID(Long idSocialMedia) {
		return (SocialMedia) getSession().get(SocialMedia.class, idSocialMedia);
	}

	public List<SocialMedia> getAllSocialMedia() {
		return getSession().createQuery("from SocialMedia").list();
	}

	public SocialMedia findSocialMediaByName(String nameSocialMedia) {
		return (SocialMedia) getSession().createQuery("from SocialMedia where name = :name").setParameter("name", nameSocialMedia).uniqueResult();
	}

	@Override
	public TeacherSocialMedia findSocialMediaByIDAndNickname(Long idSocialMedia, String nickname) {
		List<Object[]> objects = getSession().createQuery(
				  "from TeacherSocialMedia tsm "
				+ "join tsm.socialMedia sm "
				+ "where sm.idSocialMedia = :idSocialMedia and tsm.nickname = :nickname")
				.setParameter("idSocialMedia", idSocialMedia)
				.setParameter("nickname", nickname)
				.list();
		
		if (objects.size() > 0) {			
			for (Object[] o : objects) {
				for (Object o2 : o) {
					if (o2 instanceof TeacherSocialMedia) {
						return (TeacherSocialMedia) o2;
					}
				}
			}
		}
		
		return null;
	}
	
	@Override
	public TeacherSocialMedia findSocialMediaByIDTeacherAndIDSocialMedia(Long idTeacher, Long idSocialMedia) {
		List<Object[]> objs = getSession().createQuery(
				    "from TeacherSocialMedia tsm "
				  + "join tsm.socialMedia sm "
				  + "join tsm.teacher t "
				  + "where sm.idSocialMedia = :idSocialMedia and t.idTeacher = :idTeacher")
				.setParameter("idSocialMedia", idSocialMedia)
				.setParameter("idTeacher", idTeacher)
				.list();
		
		if (objs.size() > 0) {
			for (Object[] objects : objs) {
				for (Object object : objects) {
					if (object instanceof TeacherSocialMedia) {
						return (TeacherSocialMedia) object;
					}
				}
			}
		}
		
		return null;
	}
	
}
