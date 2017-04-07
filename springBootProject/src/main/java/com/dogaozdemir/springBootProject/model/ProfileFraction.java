package com.dogaozdemir.springBootProject.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import com.dogaozdemir.springBootProject.model.comp.ProfileFractionId;

@Entity
@IdClass(ProfileFractionId.class)
public class ProfileFraction {

	@Id
	private String month;
	@Id
	private String profile;
	private Double fraction;

	public ProfileFraction() {
		super();
	}

	public ProfileFraction(String month, String profile, Double fraction) {
		super();
		this.month = month;
		this.profile = profile;
		this.fraction = fraction;
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

	public Double getFraction() {
		return fraction;
	}

	public void setFraction(Double fraction) {
		this.fraction = fraction;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((fraction == null) ? 0 : fraction.hashCode());
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
		ProfileFraction other = (ProfileFraction) obj;
		if (fraction == null) {
			if (other.fraction != null)
				return false;
		} else if (!fraction.equals(other.fraction))
			return false;
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
		return "ProfileFraction [month=" + month + ", profile=" + profile
				+ ", fraction=" + fraction + "]";
	}
	

	
}
