package com.va.spring.rest.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class FootballTeam {

	private String name;

	private String city;

	private String owner;

	private int stadiumCapacity;

	private String competition;

	private int numberOfPlayers;

	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dateOfCreation;

	public FootballTeam(){}
	
	public FootballTeam(String name, String city, String owner, int stadiumCapacity, String competition, int numberOfPlayers, Date dateOfCreation) {
        this.name = name;
        this.city = city;
        this.owner = owner;
        this.stadiumCapacity = stadiumCapacity;
        this.competition = competition;
        this.numberOfPlayers = numberOfPlayers;
        this.dateOfCreation = dateOfCreation;
    }
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the owner
	 */
	public String getOwner() {
		return owner;
	}

	/**
	 * @param owner the owner to set
	 */
	public void setOwner(String owner) {
		this.owner = owner;
	}

	/**
	 * @return the stadiumCapacity
	 */
	public int getStadiumCapacity() {
		return stadiumCapacity;
	}

	/**
	 * @param stadiumCapacity the stadiumCapacity to set
	 */
	public void setStadiumCapacity(int stadiumCapacity) {
		this.stadiumCapacity = stadiumCapacity;
	}

	/**
	 * @return the competition
	 */
	public String getCompetition() {
		return competition;
	}

	/**
	 * @param competition the competition to set
	 */
	public void setCompetition(String competition) {
		this.competition = competition;
	}

	/**
	 * @return the numberOfPlayers
	 */
	public int getNumberOfPlayers() {
		return numberOfPlayers;
	}

	/**
	 * @param numberOfPlayers the numberOfPlayers to set
	 */
	public void setNumberOfPlayers(int numberOfPlayers) {
		this.numberOfPlayers = numberOfPlayers;
	}

	/**
	 * @return the dateOfCreation
	 */
	public Date getDateOfCreation() {
		return dateOfCreation;
	}

	/**
	 * @param dateOfCreation the dateOfCreation to set
	 */
	public void setDateOfCreation(Date dateOfCreation) {
		this.dateOfCreation = dateOfCreation;
	}
	
	public boolean equals (Object footballTeam){
		FootballTeam team = (FootballTeam) footballTeam;
		return getName().equalsIgnoreCase(team.getName());
	}
	
	public int hashCode(){
		return name.toUpperCase().hashCode();
	}
	

}
