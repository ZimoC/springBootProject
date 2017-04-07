package com.dogaozdemir.springBootProject.model.comp;

import java.io.Serializable;

public class MeterId implements Serializable{
	private String meterId;
	private String profile;
	private String month;

	public MeterId() {

	}

	public MeterId(String meterId, String profile, String month) {
		super();
		this.meterId = meterId;
		this.profile = profile;
		this.month = month;
	}

	public String getMeterId() {
		return meterId;
	}

	public void setMeterId(String meterId) {
		this.meterId = meterId;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((meterId == null) ? 0 : meterId.hashCode());
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
		MeterId other = (MeterId) obj;
		if (meterId == null) {
			if (other.meterId != null)
				return false;
		} else if (!meterId.equals(other.meterId))
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
		return "MeterId [meterId=" + meterId + ", profile=" + profile
				+ ", month=" + month + "]";
	}

	
}
