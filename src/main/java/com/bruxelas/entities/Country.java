package com.bruxelas.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Country {

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String nativeName;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "country_languages", joinColumns = {
			@JoinColumn(name = "country_id", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "language_id", referencedColumnName = "id") })
	private List<Language> languages;

	public Country() {
	}

	public Country(Long id, String name, String nativeName) {
		this.id = id;
		this.name = name;
		this.nativeName = nativeName;
	}

	public Country(Long id, String name, String nativeName, List<Language> languages) {
		this(id, name, nativeName);
		this.languages = languages;
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

	public List<Language> getLanguages() {
		return languages;
	}

	public void setLanguages(List<Language> languages) {
		this.languages = languages;
	}

	public String getNativeName() {
		return nativeName;
	}

	public void setNativeName(String nativeName) {
		this.nativeName = nativeName;
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
		Country other = (Country) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Country [id=" + id + ", name=" + name + ", nativeName=" + nativeName + ", languages=" + languages + "]";
	}

}
