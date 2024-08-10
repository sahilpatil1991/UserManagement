package com.curdapp.dto;

public class UserDto {

	public int userId;

	public String userName;

	public String userDepartment;

	public String userProfile;

	public String userQualification;

	public String userLocation;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserDepartment() {
		return userDepartment;
	}

	public void setUserDepartment(String userDepartment) {
		this.userDepartment = userDepartment;
	}

	public String getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(String userProfile) {
		this.userProfile = userProfile;
	}

	public String getUserQualification() {
		return userQualification;
	}

	public void setUserQualification(String userQualification) {
		this.userQualification = userQualification;
	}

	public String getUserLocation() {
		return userLocation;
	}

	public void setUserLocation(String userLocation) {
		this.userLocation = userLocation;
	}

	@Override
	public String toString() {
		return "UserDto [userId=" + userId + ", userName=" + userName + ", userDepartment=" + userDepartment
				+ ", userProfile=" + userProfile + ", userQualification=" + userQualification + ", userLocation="
				+ userLocation + "]";
	}

}
