package com.bruxelas.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class LanguagesYouSpeak {

	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne
	private Talker talker;

	@ManyToOne
	private Language language;

	private Boolean learning;

	private LearningLevelType level;

	public LanguagesYouSpeak() {
	}

	public LanguagesYouSpeak(Long id, Talker talker, Language language, Boolean learning, LearningLevelType level) {
		this.id = id;
		this.talker = talker;
		this.language = language;
		this.learning = learning;
		this.level = level;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Talker getTalker() {
		return talker;
	}

	public void setTalker(Talker talker) {
		this.talker = talker;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public Boolean getLearning() {
		return learning;
	}

	public void setLearning(Boolean learning) {
		this.learning = learning;
	}

	public LearningLevelType getLevel() {
		return level;
	}

	public void setLevel(LearningLevelType level) {
		this.level = level;
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
		LanguagesYouSpeak other = (LanguagesYouSpeak) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "LanguagesYouSpeak [id=" + id + ", talker=" + talker + ", language=" + language + ", learning="
				+ learning + ", level=" + level + "]";
	}

}
