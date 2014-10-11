package com.testing.service.profile;

import java.util.List;

import com.testing.model.profile.ProfileEntity;

public interface ProfileService {

	public void addProfile(ProfileEntity profileEntity);
	public List<ProfileEntity> getProfile();
	 public ProfileEntity get(Integer profileid);
	 public void updateProfile(ProfileEntity profileEntity);
	 public void updatePicture(ProfileEntity profileEntity);
}
