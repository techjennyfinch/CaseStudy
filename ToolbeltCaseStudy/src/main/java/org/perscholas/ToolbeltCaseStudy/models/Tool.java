/**
 * 
 */
package org.perscholas.ToolbeltCaseStudy.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * @author Jenny
 * This class is for information about individual tool types...ie, hammer, circulating saw, etc.
 *
 */

@Entity
public class Tool {
	
	private int toolId;
	private String toolName;
	private String toolDescription;
	private int toolQuantity;
	private String powerType;
	private int requiredPerTrailer;
	

	private Set<ToolTrailerInventory> toolTrailerInventory = new HashSet<>();
	//should this really be  a list?
	
	
	/**
	 * @param toolId
	 * @param toolName
	 * @param toolDescription
	 * @param toolQuantity
	 * @param powerType
	 * @param requiredperTrailer
	 */
	
	//constructors
	
	public Tool(int toolId, String toolName, String toolDescription, int toolQuantity, String powerType,
			int requiredPerTrailer) {
		super();
		this.toolId = toolId;
		this.toolName = toolName;
		this.toolDescription = toolDescription;
		this.toolQuantity = toolQuantity;
		this.powerType = powerType;
		this.requiredPerTrailer = requiredPerTrailer;
	}
	
	public Tool() {
		
	}
	
	//Getters and Setters and Entity Data

	/**
	 * @return the toolId
	 */
	//switched from Auto to Identity to test.  MariaDB had an issue with auto & sequence
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	public int getToolId() {
		return toolId;
	}

	/**
	 * @param toolId the toolId to set
	 */
	public void setToolId(int toolId) {
		this.toolId = toolId;
	}

	/**
	 * @return the toolName
	 */
	@Column(name = "toolname", nullable = false, length=50)
	public String getToolName() {
		return toolName;
	}

	/**
	 * @param toolName the toolName to set
	 */
	public void setToolName(String toolName) {
		this.toolName = toolName;
	}

	/**
	 * @return the toolDescription
	 */
	@Column(name = "tooldescription", length=100)
	public String getToolDescription() {
		return toolDescription;
	}

	/**
	 * @param toolDescription the toolDescription to set
	 */
	public void setToolDescription(String toolDescription) {
		this.toolDescription = toolDescription;
	}

	/**
	 * @return the toolQuantity
	 */
	@Column(name = "toolQuantity", nullable = false)
	public int getToolQuantity() {
		return toolQuantity;
	}

	/**
	 * @param toolQuantity the toolQuantity to set
	 */
	public void setToolQuantity(int toolQuantity) {
		this.toolQuantity = toolQuantity;
	}

	/**
	 * @return the powerType
	 */
	@Column(name = "powerType", length=20)
	public String getPowerType() {
		return powerType;
	}

	/**
	 * @param powerType the powerType to set
	 */
	public void setPowerType(String powerType) {
		this.powerType = powerType;
	}

	/**
	 * @return the requiredPerTrailer
	 */
	
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

	/**
	 * @return the toolTrailerInventory
	 */
	@OneToMany (mappedBy = "tool")
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
