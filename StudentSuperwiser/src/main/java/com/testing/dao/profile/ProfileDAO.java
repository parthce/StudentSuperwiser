package com.testing.dao.profile;

import java.util.List;

import com.testing.model.profile.ProfileEntity;

public interface ProfileDAO {

	public void addProfile(ProfileEntity profileEntity);
	public List<ProfileEntity> getProfile();
	public ProfileEntity get(Integer id);
	 public void updateProfile(ProfileEntity profileEntity);
	 public void updatePicture(ProfileEntity profileEntity);
	
}
