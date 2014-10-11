package com.testing.controller.profile;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.IOUtils;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.testing.model.profile.ProfileEntity;
import com.testing.service.profile.ProfileService;

@Controller
public class ProfileController {

	@Autowired
	private ProfileService profileService;
	
	@Autowired
	private ProfileEntity profileEntity;
	
		@InitBinder
	 	 public void initBinder(WebDataBinder binder)
	 	 {
	 	  SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	 	  dateFormat.setLenient(false);
	 	  binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	 	 }
	 @RequestMapping(value= "/addProfile", method = RequestMethod.POST,params="finish")
		public ModelAndView addProfile(Map<String, Object> map, @ModelAttribute("profile")ProfileEntity profileEntity , BindingResult result,
				@RequestParam(value= "image") MultipartFile image){
		 try {
		        Blob blob = Hibernate.createBlob(image.getInputStream());
		    	profileEntity.setImage(blob);
		       }
		       catch(Exception e) {
		    	   e.printStackTrace();
		       }
		 profileService.addProfile(profileEntity);
		 map.put("profileDetail", profileService.getProfile());
		 return new ModelAndView("showProfile");
	 }
	 @RequestMapping(value= "/addProfile", method = RequestMethod.POST,params="skip")
	 public ModelAndView addProfile() {
		 return new ModelAndView("showProfile");
	 }
	 
	@RequestMapping(value="/getUserImage/{profileid}")
	public void getUserImage(HttpServletResponse response , @PathVariable("profileid") int profileid) throws IOException{
		
		response.setContentType("image/png");
		Blob blob = profileService.get(profileid).getImage();
		try{
			int blobLength = (int) blob.length(); 
			byte[] buffer = blob.getBytes(1, blobLength);
	  
			InputStream in1 = new ByteArrayInputStream(buffer);
			IOUtils.copy(in1, response.getOutputStream());   
		}
		catch(Exception e) {
 	   		e.printStackTrace();
		}
	}
	@RequestMapping(value="/showProfile", method=RequestMethod.POST, params="editProfile")
	public ModelAndView viewProfile(Map<String, Object> map){
		map.put("profileDetail", profileService.getProfile());
		
			return new ModelAndView("editProfile");
	}
	@RequestMapping(value="/showProfile", method=RequestMethod.POST, params="editPicture")
	public ModelAndView viewPicture(Map<String, Object> map){
		map.put("profileDetail", profileService.getProfile());
			return new ModelAndView("editPicture");
	}
	@RequestMapping(value="/editPicture", method=RequestMethod.POST ,params = "update")
	public ModelAndView updatePicture(@RequestParam("image") MultipartFile image,
			Map<String, Object> map){
		  try {
		        Blob blob = Hibernate.createBlob(image.getInputStream());
		    	profileEntity.setImage(blob);
		       }
		       catch(Exception e) {
		    	   e.printStackTrace();
		       }
		  profileService.updatePicture(profileEntity);
		  map.put("profileDetail", profileService.getProfile());
		return new ModelAndView("editPicture");
	}
	@RequestMapping(value="/editPicture", method=RequestMethod.POST ,params = "ok")
	public ModelAndView updatePicture(Map<String, Object> map){
		 map.put("profileDetail", profileService.getProfile());
		return new ModelAndView("showProfile");
	}
	@RequestMapping(value="/editProfile", method=RequestMethod.POST)
	public ModelAndView updateProfile(Map<String, Object> map,@RequestParam("country")String country,
			@RequestParam("profileid")int profileid,
			@RequestParam("postalcode")int postalcode,
			@RequestParam("gender")String gender,
			@RequestParam("phone")int phone,
			@RequestParam("language")String language,
			@RequestParam(value="bio", required = false)String bio,
			@RequestParam("activities")String activities,
			@RequestParam("interests")String interests,
			@RequestParam("occupation")String occupation, 
			@RequestParam("whatsonmind")String whatsonmind
			){
		profileEntity.setCountry(country);
		profileEntity.setProfileid(profileid);
		profileEntity.setGender(gender);
		profileEntity.setPostalcode(postalcode);
		profileEntity.setPhone(phone);
		profileEntity.setLanguage(language);
		profileEntity.setBio(bio);
		profileEntity.setActivities(activities);
		profileEntity.setInterests(interests);
		profileEntity.setOccupation(occupation);
		profileEntity.setWhatsonmind(whatsonmind);
		profileService.updateProfile(profileEntity);
		map.put("profileDetail", profileService.getProfile());
			return new ModelAndView("showProfile");
	}
}
