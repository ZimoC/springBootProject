package com.dogaozdemir.springBootProject.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import com.dogaozdemir.springBootProject.model.comp.MeterId;
import com.dogaozdemir.springBootProject.model.comp.ProfileFractionId;

@Entity
@IdClass(MeterId.class)
public class Meter {

	@Id
	private String meterId;
	@Id
	private String profile;
	@Id
	private String month;
	private Integer meterReading;

	public Meter() {
		super();
	}

	public Meter(String meterId, String profile, String month,
			Integer meterReading) {
		super();
		this.meterId = meterId;
		this.profile = profile;
		this.month = month;
		this.meterReading = meterReading;
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

	public Integer getMeterReading() {
		return meterReading;
	}

	public void setMeterReading(Integer meterReading) {
		this.meterReading = meterReading;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((meterId == null) ? 0 : meterId.hashCode());
		result = prime * result
				+ ((meterReading == null) ? 0 : meterReading.hashCode());
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
		Meter other = (Meter) obj;
		if (meterId == null) {
			if (other.meterId != null)
				return false;
		} else if (!meterId.equals(other.meterId))
			return false;
		if (meterReading == null) {
			if (other.meterReading != null)
				return false;
		} else if (!meterReading.equals(other.meterReading))
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
		return "Meter [meterId=" + meterId + ", profile=" + profile
				+ ", month=" + month + ", meterReading=" + meterReading + "]";
	}


	
}
