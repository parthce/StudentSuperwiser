package com.testing.dao.profile;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.testing.model.profile.ProfileEntity;


@Repository
public class ProfileDAOImpl implements ProfileDAO {
		private int profileId;
		@Autowired
	    private SessionFactory sessionFactory;
		
	public void addProfile(ProfileEntity profileEntity){
		profileId= (Integer) sessionFactory.getCurrentSession().save(profileEntity);
	}
	
	@SuppressWarnings("unchecked")
	public List<ProfileEntity> getProfile(){
		 return sessionFactory.getCurrentSession().createQuery("from ProfileEntity p where p.profileid=:id").setParameter("id", profileId).list();
	                
	}
	public ProfileEntity get(Integer profileid){
		 Session session = sessionFactory.getCurrentSession();
	        return (ProfileEntity)session.get(ProfileEntity.class, profileid);
	}
	 public void updateProfile(ProfileEntity profileEntity){
		 sessionFactory.getCurrentSession().createQuery("update ProfileEntity set country = :country,postalcode= :postalcode,gender= :gender,dob =:dob,phone=:phone,language=:language,bio=:bio,occupation=:occupation,interests=:interests,activities=:activities where profileid = :profileid")
		 .setParameter("profileid", profileEntity.getProfileid())
		 .setParameter("country", profileEntity.getCountry())
		 .setParameter("gender", profileEntity.getGender())
		 .setParameter("dob", profileEntity.getDob())
		 .setParameter("phone", profileEntity.getPhone())
		 .setParameter("language", profileEntity.getLanguage())
		 .setParameter("bio", profileEntity.getBio())
		 .setParameter("occupation", profileEntity.getOccupation())
		 .setParameter("interests", profileEntity.getInterests())
		 .setParameter("activities", profileEntity.getActivities())
		 .setParameter("postalcode", profileEntity.getPostalcode())
		 .executeUpdate();
	 }
	 public void updatePicture(ProfileEntity profileEntity){
		 sessionFactory.getCurrentSession().createQuery("update ProfileEntity set image = :image where profileid = :profileid")
		 .setParameter("image", profileEntity.getImage())
		 .setParameter("profileid",profileId)
		 .executeUpdate();
	 }
	 
}
