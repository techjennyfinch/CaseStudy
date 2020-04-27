/**
 * 
 */
package org.perscholas.ToolbeltCaseStudy.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * @author Jenny This class is for information about individual tool types...ie,
 *         hammer, circulating saw, etc.
 *
 */

@Entity
public class Tool {

	private int toolId;
	private String toolName;
	private String toolDescription;
	private int toolQuantity;
	private String powerType; // power type: gas, electric, manual etc.
	private int requiredPerTrailer; // Goal set by organization for all trailers

	private Set<ToolTrailerInventory> toolTrailerInventory = new HashSet<>();

	// constructors

	public Tool() {

	}

	public Tool(int toolId, String toolName, String toolDescription, int toolQuantity, String powerType,
			int requiredPerTrailer) {
		this.toolId = toolId;
		this.toolName = toolName;
		this.toolDescription = toolDescription;
		this.toolQuantity = toolQuantity;
		this.powerType = powerType;
		this.requiredPerTrailer = requiredPerTrailer;
	}

	// Getters and Setters and Entity Data

	// switched from Auto to Identity to test. MariaDB had an issue with auto &
	// sequence
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getToolId() {
		return toolId;
	}

	public void setToolId(int toolId) {
		this.toolId = toolId;
	}

	@Column(name = "toolname", nullable = false, length = 50)
	public String getToolName() {
		return toolName;
	}

	public void setToolName(String toolName) {
		this.toolName = toolName;
	}

	@Column(name = "tooldescription", length = 100)
	public String getToolDescription() {
		return toolDescription;
	}

	public void setToolDescription(String toolDescription) {
		this.toolDescription = toolDescription;
	}

	@Column(name = "toolQuantity", nullable = false)
	public int getToolQuantity() {
		return toolQuantity;
	}

	public void setToolQuantity(int toolQuantity) {
		this.toolQuantity = toolQuantity;
	}

	@Column(name = "powerType", length = 20)
	public String getPowerType() {
		return powerType;
	}

	public void setPowerType(String powerType) {
		this.powerType = powerType;
	}

	@Column(name = "requiredPerTrailer", nullable = false)
	public int getRequiredPerTrailer() {
		return requiredPerTrailer;
	}

	/**
	 * @param requiredPerTrailer the requiredPerTrailer to set
	 */
	public void setRequiredPerTrailer(int requiredPerTrailer) {
		this.requiredPerTrailer = requiredPerTrailer;
	}

	// removed orphanremoval=true
	@OneToMany(mappedBy = "tool", cascade = CascadeType.ALL)
	public Set<ToolTrailerInventory> getToolTrailerInventory() {
		return toolTrailerInventory;
	}

	public void setToolTrailerInventory(Set<ToolTrailerInventory> toolTrailerInventory) {
		this.toolTrailerInventory = toolTrailerInventory;
	}

}
