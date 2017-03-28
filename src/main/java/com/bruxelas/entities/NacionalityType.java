package com.bruxelas.entities;

public enum NacionalityType {
	BRAZILIAN("Brazilian"),
	AMERICAN("American"),
	BRITISH("British"),
	GERMAN("German"),
	NORWEGIAN("Norwegian"),
	ARGENTINIAN("Argentinian"),
	SPANISH("Spanish"),
	URUGUAYAN("Uruguayan"),
	PARAGUAYAN("Paraguayan"),
	ITALIAN("Italian"),
	BELGIAN("Belgian"),
	OTHERS("Others");
	
	private String description;
	
	/**
	 * Constructor for Nacionalidade.
	 * @param description String
	 */
	private NacionalityType(String description){
		this.description = description;
	}
	
	/**
	 * Method getDescription.
	
	 * @return String */
	public String getDescription(){
		return description;
	}
}
