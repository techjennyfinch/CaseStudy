/**
 * 
 */
package org.perscholas.ToolbeltCaseStudy.models;

import java.io.Serializable;

import javax.persistence.Embeddable;

/**
 * @author Jenny
 *
 */
//This class creates an id through embeddable means in order to work with items in a tool trailer.
//This was used because of the many to one bidirectional relationship with extra data in the tooltrailerinventory class.
//This class implements Serializable    serialversionUID required for Serializable which is required for the
// composite table. private static final long serialVersionUID = 1L; also required for same.

@Embeddable
public class ToolTrailerId implements Serializable {

	private static final long serialVersionUID = 1L;

	private int toolId;
	private int trailerId;

	// Constructors

	public ToolTrailerId() {

	}

	public ToolTrailerId(int toolId, int trailerId) {
		this.toolId = toolId;
		this.trailerId = trailerId;
	}

	// Getters and Setters

	public int getToolId() {
		return toolId;
	}

	public void setToolId(int toolId) {
		this.toolId = toolId;
	}

	public int getTrailerId() {
		return trailerId;
	}

	public void setTrailerId(int trailerId) {
		this.trailerId = trailerId;
	}

	@Override
	public String toString() {
		return "ToolTrailerId [toolId=" + toolId + ", trailerId=" + trailerId + "]";

	}

}
