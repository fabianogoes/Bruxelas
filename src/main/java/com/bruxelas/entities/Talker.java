package com.bruxelas.entities;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Talker {

	@Id
	@GeneratedValue
	private Long id;
	private String name;

	@Temporal(TemporalType.DATE)
	private Calendar birthDate;

	@Enumerated(EnumType.STRING)
	private GenderType gender;

	@ManyToOne
	private Country nacionality;
	
	@ManyToOne
	private Country livingIn;
	
	@ManyToOne
	private Country languageYouSpeak;

	public Talker() {
	}

	public Talker(Long id, String name, Country nacionality, Country livingIn, Calendar birthDate,
			GenderType gender, Country languageYouSpeak) {
		this.id = id;
		this.name = name;
		this.nacionality = nacionality;
		this.livingIn = livingIn;
		this.birthDate = birthDate;
		this.gender = gender;
		this.languageYouSpeak = languageYouSpeak;
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

	public Country getNacionality() {
		return nacionality;
	}

	public void setNacionality(Country nacionality) {
		this.nacionality = nacionality;
	}

	public Country getLivingIn() {
		return livingIn;
	}

	public void setLivingIn(Country livingIn) {
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
				+ ", birthDate=" + birthDate + ", gender=" + gender + ", languagesYouSpeak=" + languageYouSpeak + "]";
	}

}
