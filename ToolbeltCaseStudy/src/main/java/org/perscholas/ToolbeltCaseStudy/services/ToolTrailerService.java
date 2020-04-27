/**
 * 
 */
package org.perscholas.ToolbeltCaseStudy.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.perscholas.ToolbeltCaseStudy.models.Tool;
import org.perscholas.ToolbeltCaseStudy.models.ToolTrailerId;
import org.perscholas.ToolbeltCaseStudy.models.ToolTrailerInventory;
import org.perscholas.ToolbeltCaseStudy.models.Trailer;
import org.perscholas.ToolbeltCaseStudy.repositories.ToolTrailerInventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Jenny
 *
 */
@Service
public class ToolTrailerService {

	@Autowired
	private ToolTrailerInventoryRepository toolTrailerRepo;


	@Autowired

	private TrailerService trailerservice;

	@Autowired
	private ToolService toolService;

	public List<ToolTrailerInventory> listAll() {

		return toolTrailerRepo.findAll();
	}

	// CRUD

	public void save(ToolTrailerInventory toolTrailerInventory) {
		toolTrailerRepo.save(toolTrailerInventory);
	}

	public ToolTrailerInventory get(ToolTrailerId toolTrailerId) {
		return toolTrailerRepo.findById(toolTrailerId).get();
	}

	public void delete(ToolTrailerId id) {
		System.out.println("Testing delete");
		toolTrailerRepo.deleteById(id);
		System.out.println("item deleted.");
	}

	public ToolTrailerInventory getItem(int toolId, int trailerId) {
		System.out.println("finding item");
		ToolTrailerId findId = new ToolTrailerId(toolId, trailerId);
		// toolid, trailerid
		System.out.println("looking for it.");
		ToolTrailerInventory findInv = get(findId);
		System.out.println(findInv);
		System.out.println("was that helpful?");
		return findInv;
	}

	// This method saves an individual inventory item, including updating dates
	// editInventoryItem
	public void saveItem(ToolTrailerInventory tooltrailerinventory) {

		ToolTrailerInventory temp = tooltrailerinventory;
		// getting values from the webpage and storing in temp.
		int trailerId = tooltrailerinventory.getTrailer().getTrailerId();
		System.out.println("trailer id is : " + trailerId);
		int toolId = tooltrailerinventory.getTool().getToolId();
		System.out.println("tool id is : " + toolId);
		System.out.println("Acquiring original record");
		ToolTrailerInventory originalItem = getItem(toolId, trailerId);
		System.out.println("Found original item.");

//		int expectedNumOfTool = originalItem.getExpectedNumOfTool();
//		originalItem.setExpectedNumOfTool(expectedNumOfTool);

		// Originally had it where old data and new data were added, and can be changed
		// back, but changed to avoid user confusion.

		int actualNumOfTool = temp.getActualNumOfTool();
		originalItem.setActualNumOfTool(actualNumOfTool);
		int newTool = temp.getNewTool();
		originalItem.setNewTool(newTool);
		System.out.println("new tool total: " + newTool);
		int brokenTool = temp.getBrokenTool();
		originalItem.setBrokenTool(brokenTool);
		System.out.println("new broken tool total: " + brokenTool);
		int usedTool = temp.getUsedTool();
		originalItem.setUsedTool(usedTool);
		System.out.println("new usedtool total: " + usedTool);

		LocalDate dateOfLastInventory = originalItem.getDateOfLastInventory();
		LocalDate dateOfCurrentInventory = originalItem.getDateOfCurrentInventory();

		if (temp.getDateOfCurrentInventory() != LocalDate.now()) {
			dateOfLastInventory = originalItem.getDateOfCurrentInventory();
			dateOfCurrentInventory = LocalDate.now();
		} else {
			dateOfLastInventory = originalItem.getDateOfLastInventory();
			dateOfCurrentInventory = LocalDate.now();
		}

		originalItem.setDateOfCurrentInventory(dateOfCurrentInventory);
		originalItem.setDateOfLastInventory(dateOfLastInventory);
		System.out.println("while we are checking dates:  " + LocalDate.now());

		Trailer trailer = trailerservice.get(trailerId);
		Tool tool = toolService.get(toolId);
		System.out.println("Setting up all the values");

		System.out.println("About to save...");
		save(originalItem);
		System.out.println("Saving");

	} // end of method

	// method to delete item.
	public void deleteInventoryItem(int toolId, int trailerId) {

		ToolTrailerId sadId = new ToolTrailerId(toolId, trailerId);
		// toolid, trailerid
		ToolTrailerInventory sadInv = get(sadId);
		// it's sad because it is going to be deleted.
		System.out.println("Removing..." + sadInv);
		delete(sadId);
		// Farewell sad item.
	}

//BuildToolTrailer is a method to set up a trailer for the first time when it has 0 tools.
//It will check all existing trailers and if empty will load with existing tool items.  This should only be used
	// After a trailer has been added to set up the new

	public void buildToolTrailer() {

		// pull current trailer and tool lists.
		List<Trailer> trailerList = trailerservice.listAll();
		List<Tool> toolList = toolService.listAll();

		// check each tooltrailer for contents

		for (Trailer trailer : trailerList) {

			int trailerId = trailer.getTrailerId();

			// need to find by trailer

			List<ToolTrailerInventory> tooltrailerListbyTrailer = toolTrailerRepo.findByIdTrailerId(trailerId);
			System.out.println("<<<<<<<<<printing tooltrailer by trailer<<<<<");
			System.out.println(tooltrailerListbyTrailer.toString());
			System.out.println("<<<<<<<<<completed printing tooltrailer by trailer<<<<<");

			// tooltrailer is empty then fill it
			if ((tooltrailerListbyTrailer != null) && !tooltrailerListbyTrailer.isEmpty()) {

				System.out.println("This Trailer has already been filled.");
			} else {

				// for each tool need to build an entry in tool trailer
				for (Tool tool : toolList) {

					int expectedNumOfTool = tool.getRequiredPerTrailer();
					int actualNumOfTool = 0;
					int newTool = 0;
					int brokenTool = 0;
					int usedTool = 0;
					LocalDate dateOfLastInventory = LocalDate.of(2020, 01, 01);
					LocalDate dateOfCurrentInventory = LocalDate.of(2020, 01, 01);

					ToolTrailerInventory newtooltrailer = new ToolTrailerInventory(trailer, tool, expectedNumOfTool,
							actualNumOfTool, newTool, brokenTool, usedTool, dateOfLastInventory,
							dateOfCurrentInventory);

					save(newtooltrailer);

				} // end of tool for loop to check each tool
			} // end of if statement about tool trailer being empty
		} // end of checking each trailer in the list
	} // end of method

// method to load new tool types to inventory. This will load any individual tool types 
	// to a trailer after new tools have been added to the system.

//this uses int id for trailer.
	public void loadNewTools(int id) {

		int thisTrailerId = id;
		Trailer selectedTrailer = trailerservice.get(id);

		// pull current trailer and tool lists.

		List<Tool> toolList = toolService.listAll();
		System.out.println("starting load new tools method");

		for (Tool tool : toolList) {

			System.out.println("in the tool loop");
			int thisToolId = tool.getToolId();

			ToolTrailerId thisToolTrailerId = new ToolTrailerId(tool.getToolId(), selectedTrailer.getTrailerId());
			System.out.println("Looking for inventory item.");
			// find by id trailer and tool did not Work
			Optional<ToolTrailerInventory> inventory = toolTrailerRepo.findById(thisToolTrailerId);

			if (inventory.isPresent()) {
				System.out.println("trailer id:" + selectedTrailer.getTrailerId());
				System.out.println("tool id:" + tool.getToolId());
				// checking for null and a value
				System.out.println("<<<<<<<<<printing tooltrailer Inventory Item by trailerand tool<<<<<");
				System.out.println(inventory.toString());
				System.out.println("<<<<<<<<<completed printing tooltrailer Inventory Item by trailerand tool<<<<<");
				System.out.println("This Tool is already in this trailer..");
			} else {

				System.out.println("building a tool");
				int expectedNumOfTool = tool.getRequiredPerTrailer();
				int actualNumOfTool = 0;
				int newTool = 0;
				int brokenTool = 0;
				int usedTool = 0;
				LocalDate dateOfLastInventory = LocalDate.of(2020, 01, 01);
				LocalDate dateOfCurrentInventory = LocalDate.of(2020, 01, 01);
				System.out.println("trailer id:" + selectedTrailer.getTrailerId());
				System.out.println("tool id:" + tool.getToolId());

				ToolTrailerInventory newtooltrailer = new ToolTrailerInventory(selectedTrailer, tool, expectedNumOfTool,
						actualNumOfTool, newTool, brokenTool, usedTool, dateOfLastInventory, dateOfCurrentInventory);
				System.out.println("saving new tool");

				save(newtooltrailer);

			} // end of tool for loop to check/add each tool

		} // end of checking each tool

	} // end of method

	// This shows the inventory for just the one trailer.
	public List<ToolTrailerInventory> selectedTrailerInventory(int id) {
		Trailer selectedTrailer = trailerservice.get(id);
		int trailerId = id;
		return toolTrailerRepo.findByIdTrailerId(trailerId);
	}

	public ToolTrailerInventory findbyToolId(ToolTrailerId toolId) {
		return toolTrailerRepo.findById(toolId).get();
	}

}
