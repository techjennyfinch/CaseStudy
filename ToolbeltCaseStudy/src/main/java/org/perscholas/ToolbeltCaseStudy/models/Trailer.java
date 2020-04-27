/**
 * 
 */
package org.perscholas.ToolbeltCaseStudy.models;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
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

	private List<ToolTrailerInventory> toolTrailerInventory;

	// constructors
	
	public Trailer() {

	}

	public Trailer(int trailerId, String trailerVIN, String location, List<ToolTrailerInventory> toolTrailerInventory) {
		this.trailerId = trailerId;
		this.trailerVIN = trailerVIN;
		this.location = location;
		this.toolTrailerInventory = toolTrailerInventory;
	}

	// Getters and Setters

	// changed to Identity from auto because mariadb had an error.
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getTrailerId() {
		return trailerId;
	}

	public void setTrailerId(int trailerId) {
		this.trailerId = trailerId;
	}

	@Basic
	@Column(name = "trailerVIN", length = 30)
	public String getTrailerVIN() {
		return trailerVIN;
	}

	/**
	 * @param trailerVIN the trailerVIN to set
	 */
	public void setTrailerVIN(String trailerVIN) {
		this.trailerVIN = trailerVIN;
	}

	@Basic
	@Column(name = "location", length = 30)
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	// removed orphanRemoval =true
	@OneToMany(mappedBy = "trailer", cascade = CascadeType.ALL)
	public List<ToolTrailerInventory> getToolTrailerInventory() {
		return toolTrailerInventory;
	}

	public void setToolTrailerInventory(List<ToolTrailerInventory> toolTrailerInventory) {
		this.toolTrailerInventory = toolTrailerInventory;
	}

}
