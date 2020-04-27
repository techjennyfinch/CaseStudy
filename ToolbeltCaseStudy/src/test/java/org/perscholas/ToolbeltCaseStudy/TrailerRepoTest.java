/**
 * 
 */
package org.perscholas.ToolbeltCaseStudy;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.perscholas.ToolbeltCaseStudy.models.ToolTrailerInventory;
import org.perscholas.ToolbeltCaseStudy.models.Trailer;
import org.perscholas.ToolbeltCaseStudy.repositories.TrailerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;


/**
 * @author Jenny
 *
 */
class TrailerRepoTest {

	
	@Autowired 
	TrailerRepository trailerRepo;
	
	List<ToolTrailerInventory> toolTrailerInventory = new ArrayList();
	
	
	@Test
	public void testtrailersave() throws Exception{
		List<ToolTrailerInventory> toolTrailerInventory = new ArrayList();
		Trailer trailer = new Trailer (4, null, null, toolTrailerInventory);
		trailerRepo.save(trailer);
		
		   
		   Assertions.assertNotNull(trailerRepo.getOne(4));
	
		
	}

}
