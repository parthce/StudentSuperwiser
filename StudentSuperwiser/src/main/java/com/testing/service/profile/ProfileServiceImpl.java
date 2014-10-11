package com.testing.service.profile;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.testing.dao.profile.ProfileDAO;
import com.testing.model.profile.ProfileEntity;


@Service
public class ProfileServiceImpl implements ProfileService {
	
	@Autowired
	private ProfileDAO profileDAO;
	@Transactional
	public void addProfile(ProfileEntity profileEntity){
		profileDAO.addProfile(profileEntity);
	}
	@Transactional
	public List<ProfileEntity> getProfile(){
		return profileDAO.getProfile();
	}
	@Transactional
	public ProfileEntity get(Integer profileid){
		return profileDAO.get(profileid);
	}
	@Transactional
	 public void updateProfile(ProfileEntity profileEntity){
		profileDAO.updateProfile(profileEntity);
		 
	 }
	@Transactional
	 public void updatePicture(ProfileEntity profileEntity){
		profileDAO.updatePicture(profileEntity);
		 
	 }
	

}