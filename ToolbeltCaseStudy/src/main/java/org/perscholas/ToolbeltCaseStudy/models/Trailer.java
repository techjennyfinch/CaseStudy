/**
 * 
 */
package org.perscholas.ToolbeltCaseStudy.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

//This class is for the individual tool trailers to track location and VIN when available.


@Entity
public class Trailer {
	private int trailerId;
	private String trailerVIN;
	private String location;
	
	
	private Set<ToolTrailerInventory> toolTrailerInventory = new HashSet<>();
	//should this really be  a list?
	
	
	//constructors
	protected Trailer() {
		
	}
	
	/**
	 * @param trailerId
	 * @param trailerVIN
	 * @param location
	 */
	protected Trailer(int trailerId, String trailerVIN, String location, Set <ToolTrailerInventory> toolTrailerInventory) {
		this.trailerId = trailerId;
		this.trailerVIN = trailerVIN;
		this.location = location;
		this.toolTrailerInventory = toolTrailerInventory;
	}
	
	//Getters and Setters
	
	/**
	 * @return the trailerId
	 */
	
	//changed to Identity from auto because mariadb had an error.
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getTrailerId() {
		return trailerId;
	}
	/**
	 * @param trailerId the trailerId to set
	 */
	public void setTrailerId(int trailerId) {
		this.trailerId = trailerId;
	}
	/**
	 * @return the trailerVIN
	 */
	
	@Basic
	@Column(name = "trailerVIN",  length=30)
	public String getTrailerVIN() {
		return trailerVIN;
	}
	/**
	 * @param trailerVIN the trailerVIN to set
	 */
	public void setTrailerVIN(String trailerVIN) {
		this.trailerVIN = trailerVIN;
	}
	/**
	 * @return the location
	 */
	@Basic
	@Column(name = "location",  length=30)
	public String getLocation() {
		return location;
	}
	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	
	
	/**
	 * @return the toolTrailerInventory
	 */
	
	@OneToMany (mappedBy = "trailer")
	public Set<ToolTrailerInventory> getToolTrailerInventory() {
		return toolTrailerInventory;
	}

	/**
	 * @param toolTrailerInventory the toolTrailerInventory to set
	 */
	public void setToolTrailerInventory(Set<ToolTrailerInventory> toolTrailerInventory) {
		this.toolTrailerInventory = toolTrailerInventory;
	}
	
	
	

}
