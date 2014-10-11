package com.testing.model.profile;



import java.sql.Blob;
import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.BatchSize;
import org.springframework.stereotype.Component;
@Component
@Entity
@Table(name="profile")
@org.hibernate.annotations.Entity(
		dynamicUpdate = true
)
public class ProfileEntity {
	@Id
    @Column(name="profileid")
    @GeneratedValue
    private int profileid;
	@Column(name="country", nullable = true)
    private String country;
	@Column(name="gender", nullable = true)
	private String gender;
	@Column(name="postalcode", nullable = true)
	private int postalcode;
	@Column(name="dateofbirth", nullable = true)
	private Date dob;
	@Column(name="phone", nullable = true)
	private int phone;
	@Column(name="language", nullable = true)
	private String language;
	@Column(name="bio", nullable = true)
	private String bio;
	@Column(name="occupation", nullable = true)
	private String occupation;
	@Column(name="interests", nullable = true)
	private String interests;
	@Column(name="activities", nullable = true)
	private String activities;
	@Column(name="image" , nullable=false)
	@Lob
	private Blob image;
	
	public Blob getImage() {
		return image;
	}
	public void setImage(Blob image) {
		this.image = image;
	}
	@Column(name="whatsonmind", nullable = true)
	private String whatsonmind;
	
	public int getProfileid() {
		return profileid;
	}
	public void setProfileid(int profileid) {
		this.profileid = profileid;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getPostalcode() {
		return postalcode;
	}
	public void setPostalcode(int postalcode) {
		this.postalcode = postalcode;
	}
	
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getBio() {
		return bio;
	}
	public void setBio(String bio) {
		this.bio = bio;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	
	public String getActivities() {
		return activities;
	}
	public void setActivities(String activities) {
		this.activities = activities;
	}
	
	
	public String getWhatsonmind() {
		return whatsonmind;
	}
	public void setWhatsonmind(String whatsonmind) {
		this.whatsonmind = whatsonmind;
	}
	public ProfileEntity() {
		
	}
	public ProfileEntity(int profileid, String country, String gender,
			int postalcode, Date dob, int phone, String language,
			String bio, String occupation, String interests, String activities,
			Blob image, String whatsonmind) {
				this.profileid = profileid;
		this.country = country;
		this.gender = gender;
		this.postalcode = postalcode;
		this.dob = dob;
		this.phone = phone;
		this.language = language;
		this.bio = bio;
		this.occupation = occupation;
		this.interests = interests;
		this.activities = activities;
		
	
		this.whatsonmind = whatsonmind;
	}
	
	public String getInterests() {
		return interests;
	}
	public void setInterests(String interests) {
		this.interests = interests;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	


}
