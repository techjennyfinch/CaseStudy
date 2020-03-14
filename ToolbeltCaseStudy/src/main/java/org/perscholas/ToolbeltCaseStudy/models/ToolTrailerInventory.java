
package org.perscholas.ToolbeltCaseStudy.models;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


/**
 * @author Jenny
 *This class contains the tools in an individual trailer.
 */
@Entity
public class ToolTrailerInventory implements Serializable {
	
	/**
	 * serialversionUID required for Serializable which is required for the composite table.
	 */
	private static final long serialVersionUID = 1L;
	
	private Trailer trailer;
	private Tool tool;
	
//	private int trailerId;
//	private int toolId;
	private int expectedNumOfTool;
	//Expected Inventory is different for each Trailer and may change based on additions and losses.
	private int actualNumOfTool;
	private int newTool;  // new tool to the trailer.  New overall should be set in tool class
	private int brokenTool; // broken tool tracker, this may indicate need to buy a replacement
	private int usedTool;  // no longer usable tools like paint rollers
	// to keep track of how inventory is changing.
	//usedTool may be paint related for example.
	private LocalDate dateOfLastInventory;
	private LocalDate dateOfCurrentInventory;
	
	
	//Constructors
	
	public ToolTrailerInventory() {
		
	}


	protected ToolTrailerInventory(Trailer trailer, Tool tool, int expectedNumOfTool, int actualNumOfTool, int newTool,
			int brokenTool, int usedTool, LocalDate dateOfLastInventory, LocalDate dateOfCurrentInventory) {
		super();
		this.trailer = trailer;
		this.tool = tool;
		this.expectedNumOfTool = expectedNumOfTool;
		this.actualNumOfTool = actualNumOfTool;
		this.newTool = newTool;
		this.brokenTool = brokenTool;
		this.usedTool = usedTool;
		this.dateOfLastInventory = dateOfLastInventory;
		this.dateOfCurrentInventory = dateOfCurrentInventory;
	}

	/**
	 * @return the trailer
	 */
	@Id
	@ManyToOne
	@JoinColumn
	public Trailer getTrailer() {
		return trailer;
	}

	/**
	 * @param trailer the trailer to set
	 */
	public void setTrailer(Trailer trailer) {
		this.trailer = trailer;
	}

	/**
	 * @return the tool
	 */

	@Id
	@ManyToOne
	@JoinColumn
	public Tool getTool() {
		return tool;
	}

	/**
	 * @param tool the tool to set
	 */
	public void setTool(Tool tool) {
		this.tool = tool;
	}

	/**
	 * @return the expectedNumOfTool
	 */
	@Basic
	@Column(name = "expectedNumOfTool", nullable = false)
	public int getExpectedNumOfTool() {
		return expectedNumOfTool;
	}

	/**
	 * @param expectedNumOfTool the expectedNumOfTool to set
	 */
	public void setExpectedNumOfTool(int expectedNumOfTool) {
		this.expectedNumOfTool = expectedNumOfTool;
	}

	/**
	 * @return the actualNumOfTool
	 */
	@Basic
	@Column(name = "actualNumOfTool", nullable = false)
	public int getActualNumOfTool() {
		return actualNumOfTool;
	}

	/**
	 * @param actualNumOfTool the actualNumOfTool to set
	 */
	public void setActualNumOfTool(int actualNumOfTool) {
		this.actualNumOfTool = actualNumOfTool;
	}

	/**
	 * @return the newTool
	 */
	@Basic
	@Column(name = "newTool")
	public int getNewTool() {
		return newTool;
	}

	/**
	 * @param newTool the newTool to set
	 */
	public void setNewTool(int newTool) {
		this.newTool = newTool;
	}

	/**
	 * @return the brokenTool
	 */
	@Basic
	@Column(name = "brokenTool")
	public int getBrokenTool() {
		return brokenTool;
	}

	/**
	 * @param brokenTool the brokenTool to set
	 */
	public void setBrokenTool(int brokenTool) {
		this.brokenTool = brokenTool;
	}

	/**
	 * @return the usedTool
	 */
	@Basic
	@Column(name = "usedTool")
	public int getUsedTool() {
		return usedTool;
	}

	/**
	 * @param usedTool the usedTool to set
	 */
	public void setUsedTool(int usedTool) {
		this.usedTool = usedTool;
	}

	/**
	 * @return the dateOfLastInventory
	 */
	@Basic
	@Column(name = "lastdate")
	public LocalDate getDateOfLastInventory() {
		return dateOfLastInventory;
	}

	/**
	 * @param dateOfLastInventory the dateOfLastInventory to set
	 */
	public void setDateOfLastInventory(LocalDate dateOfLastInventory) {
		this.dateOfLastInventory = dateOfLastInventory;
	}

	/**
	 * @return the dateOfCurrentInventory
	 */
	@Basic
	@Column(name = "currentdate")
	public LocalDate getDateOfCurrentInventory() {
		return dateOfCurrentInventory;
	}

	/**
	 * @param dateOfCurrentInventory the dateOfCurrentInventory to set
	 */
	public void setDateOfCurrentInventory(LocalDate dateOfCurrentInventory) {
		this.dateOfCurrentInventory = dateOfCurrentInventory;
	}
	
	
	

}
