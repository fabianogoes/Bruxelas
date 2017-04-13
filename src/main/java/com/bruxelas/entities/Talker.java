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

import com.bruxelas.helpers.CalendarToStringSerializerHelpser;
import com.bruxelas.helpers.StringToCalendarDeserializerHelper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
public class Talker {

	@Id
	@GeneratedValue
	private Long id;
	private String name;

	@JsonSerialize(using = CalendarToStringSerializerHelpser.class)
	@JsonDeserialize(using = StringToCalendarDeserializerHelper.class)
	@Temporal(TemporalType.DATE)
	private Calendar birthDate;

	@Enumerated(EnumType.STRING)
	private GenderType gender;

	@ManyToOne
	private Country bornIn;

	@ManyToOne
	private Country livingIn;

	@ManyToOne
	private Language nativeLanguage;

	public Talker() {
	}

	public Talker(Long id, String name, Calendar birthDate, GenderType gender, Country bornIn, Country livingIn) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
		this.gender = gender;
		this.bornIn = bornIn;
		this.livingIn = livingIn;
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

	public Calendar getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Calendar birthDate) {
		this.birthDate = birthDate;
	}

	public GenderType getGender() {
		return gender;
	}

	public void setGender(GenderType gender) {
		this.gender = gender;
	}

	public Country getBornIn() {
		return bornIn;
	}

	public void setBornIn(Country bornIn) {
		this.bornIn = bornIn;
	}

	public Country getLivingIn() {
		return livingIn;
	}

	public void setLivingIn(Country livingIn) {
		this.livingIn = livingIn;
	}

	public Language getNativeLanguage() {
		return nativeLanguage;
	}

	public void setNativeLanguage(Language nativeLanguage) {
		this.nativeLanguage = nativeLanguage;
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
		return "Talker [id=" + id + ", name=" + name + ", birthDate=" + birthDate + ", gender=" + gender + ", bornIn="
				+ bornIn + ", livingIn=" + livingIn + ", nativeLanguage=" + nativeLanguage + "]";
	}

}
