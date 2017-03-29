package com.bruxelas.entities;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Talker {

	@Id
	@GeneratedValue
	private Long id;
	private String name;

	@Enumerated(EnumType.STRING)
	private NacionalityType nacionality;

	@Enumerated(EnumType.STRING)
	private NacionalityType livingIn;

	@Temporal(TemporalType.DATE)
	private Calendar birthDate;

	@Enumerated(EnumType.STRING)
	private GenderType gender;

	@Enumerated(EnumType.STRING)
	private NacionalityType languagesYouSpeak;

	public Talker() {
	}

	public Talker(Long id, String name, NacionalityType nacionality, NacionalityType livingIn, Calendar birthDate,
			GenderType gender, NacionalityType languagesYouSpeak) {
		this.id = id;
		this.name = name;
		this.nacionality = nacionality;
		this.livingIn = livingIn;
		this.birthDate = birthDate;
		this.gender = gender;
		this.languagesYouSpeak = languagesYouSpeak;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public NacionalityType getNacionality() {
		return nacionality;
	}

	public void setNacionality(NacionalityType nacionality) {
		this.nacionality = nacionality;
	}

	public NacionalityType getLivingIn() {
		return livingIn;
	}

	public void setLivingIn(NacionalityType livingIn) {
		this.livingIn = livingIn;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Talker other = (Talker) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Talker [id=" + id + ", name=" + name + ", nacionality=" + nacionality + ", livingIn=" + livingIn
				+ ", birthDate=" + birthDate + ", gender=" + gender + ", languagesYouSpeak=" + languagesYouSpeak + "]";
	}

}
