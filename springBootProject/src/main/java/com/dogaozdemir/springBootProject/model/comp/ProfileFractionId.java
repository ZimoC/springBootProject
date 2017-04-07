package com.dogaozdemir.springBootProject.model.comp;

import java.io.Serializable;

public class ProfileFractionId implements Serializable{
	private String month;
	private String profile;

	public ProfileFractionId() {

	}

	public ProfileFractionId(String month, String profile) {
		super();
		this.month = month;
		this.profile = profile;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((month == null) ? 0 : month.hashCode());
		result = prime * result + ((profile == null) ? 0 : profile.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProfileFractionId other = (ProfileFractionId) obj;
		if (month == null) {
			if (other.month != null)
				return false;
		} else if (!month.equals(other.month))
			return false;
		if (profile == null) {
			if (other.profile != null)
				return false;
		} else if (!profile.equals(other.profile))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ProfileFractionId [month=" + month + ", profile=" + profile
				+ "]";
	}

}
