
package org.perscholas.ToolbeltCaseStudy.models;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

/**
 * @author Jenny This class contains the tools in an individual trailer.
 */
@Entity
public class ToolTrailerInventory {

	// Using ToolTrailerID for the embeddedId for the composite key.

	@EmbeddedId
	private ToolTrailerId id = new ToolTrailerId();

	@ManyToOne
	@MapsId("trailerId")
	private Trailer trailer;

	@ManyToOne
	@MapsId("toolId")
	private Tool tool;

	private int expectedNumOfTool = 0;
	// Expected Inventory is different for each Trailer and may change based on
	// additions and losses.
	private int actualNumOfTool = 0;
	private int newTool = 0; // new tool to the trailer. New overall should be set in tool class
	private int brokenTool = 0; // broken tool tracker, this may indicate need to buy a replacement
	private int usedTool = 0; // no longer usable tools like paint rollers

	private LocalDate dateOfLastInventory;
	private LocalDate dateOfCurrentInventory;

	// Constructors

	public ToolTrailerInventory() {

	}

	// constructor without id
	public ToolTrailerInventory(Trailer trailer, Tool tool, int expectedNumOfTool, int actualNumOfTool, int newTool,
			int brokenTool, int usedTool, LocalDate dateOfLastInventory, LocalDate dateOfCurrentInventory) {

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

	// constructor with id
	public ToolTrailerInventory(ToolTrailerId id, Trailer trailer, Tool tool, int expectedNumOfTool,
			int actualNumOfTool, int newTool, int brokenTool, int usedTool, LocalDate dateOfLastInventory,
			LocalDate dateOfCurrentInventory) {

		this.id = id;
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

	// Getters and Setters

	public ToolTrailerId getId() {
		return id;
	}

	public void setId(ToolTrailerId id) {
		this.id = id;
	}

	public Trailer getTrailer() {
		return trailer;
	}

	public void setTrailer(Trailer trailer) {
		this.trailer = trailer;
	}

	public Tool getTool() {
		return tool;
	}

	public void setTool(Tool tool) {
		this.tool = tool;
	}

	@Basic
	@Column(name = "expectedNumOfTool", nullable = false)
	public int getExpectedNumOfTool() {
		return expectedNumOfTool;
	}

	public void setExpectedNumOfTool(int expectedNumOfTool) {
		this.expectedNumOfTool = expectedNumOfTool;
	}

	@Basic
	@Column(name = "actualNumOfTool", nullable = false)
	public int getActualNumOfTool() {
		return actualNumOfTool;
	}

	public void setActualNumOfTool(int actualNumOfTool) {
		this.actualNumOfTool = actualNumOfTool;
	}

	@Basic
	@Column(name = "newTool")
	public int getNewTool() {
		return newTool;
	}

	public void setNewTool(int newTool) {
		this.newTool = newTool;
	}

	@Basic
	@Column(name = "brokenTool")
	public int getBrokenTool() {
		return brokenTool;
	}

	public void setBrokenTool(int brokenTool) {
		this.brokenTool = brokenTool;
	}

	@Basic
	@Column(name = "usedTool")
	public int getUsedTool() {
		return usedTool;
	}

	public void setUsedTool(int usedTool) {
		this.usedTool = usedTool;
	}

	@Basic
	@Column(name = "lastdate")
	public LocalDate getDateOfLastInventory() {
		return dateOfLastInventory;
	}

	public void setDateOfLastInventory(LocalDate dateOfLastInventory) {
		this.dateOfLastInventory = dateOfLastInventory;
	}

	@Basic
	@Column(name = "currentdate")
	public LocalDate getDateOfCurrentInventory() {
		return dateOfCurrentInventory;
	}

	public void setDateOfCurrentInventory(LocalDate dateOfCurrentInventory) {
		this.dateOfCurrentInventory = dateOfCurrentInventory;
	}

	// had to find fields that were not int
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof ToolTrailerInventory))
			return false;
		ToolTrailerInventory that = (ToolTrailerInventory) o;
		return Objects.equals(tool.getToolName(), that.tool.getToolName())
				&& Objects.equals(trailer.getLocation(), that.trailer.getLocation())
				&& Objects.equals(dateOfCurrentInventory, that.dateOfCurrentInventory);
	}

//check this
	@Override
	public String toString() {
		return "ToolTrailerInventory [id=" + id + ", trailer=" + trailer + ", tool=" + tool + ", expectedNumOfTool="
				+ expectedNumOfTool + ", actualNumOfTool=" + actualNumOfTool + ", newTool=" + newTool + ", brokenTool="
				+ brokenTool + ", usedTool=" + usedTool + ", dateOfLastInventory=" + dateOfLastInventory
				+ ", dateOfCurrentInventory=" + dateOfCurrentInventory + "]";
	}

}
