/**
 * 
 */
package org.perscholas.ToolbeltCaseStudy.repositories;

import java.util.List;

import org.perscholas.ToolbeltCaseStudy.models.ToolTrailerId;
import org.perscholas.ToolbeltCaseStudy.models.ToolTrailerInventory;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Jenny
 *
 */
public interface ToolTrailerInventoryRepository extends JpaRepository<ToolTrailerInventory, ToolTrailerId> {

	//need extra methods to be able to find an item more easily.
	
	public List <ToolTrailerInventory> findByIdTrailerId (int trailerId);
	
	public List <ToolTrailerInventory> findByIdToolId (int toolId);
	

}
