/**
 * 
 */
package org.perscholas.ToolbeltCaseStudy.controllers;

import java.util.List;

import org.perscholas.ToolbeltCaseStudy.models.Tool;
import org.perscholas.ToolbeltCaseStudy.models.ToolTrailerInventory;
import org.perscholas.ToolbeltCaseStudy.models.Trailer;
import org.perscholas.ToolbeltCaseStudy.services.ToolService;
import org.perscholas.ToolbeltCaseStudy.services.ToolTrailerService;
import org.perscholas.ToolbeltCaseStudy.services.TrailerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Jenny
 *
 */
//Controls pages and actions/methods related to the contents of a tool trailer.

@Controller
public class ToolTrailerController {

	@Autowired
	private ToolService toolService;

	@Autowired
	private TrailerService trailerService;

	@Autowired
	private ToolTrailerService toolTrailerService;

	// 1st inventory page..
	@RequestMapping("/trailerinventory")
	public String viewInventory(Model model) {
		List<ToolTrailerInventory> tooltrailerList = toolTrailerService.listAll();
		List<Trailer> trailerList = trailerService.listAll();

		model.addAttribute("trailerList", trailerList);
		// need tool trailer list
		// but also need tool list for the name of the tool

		model.addAttribute("tooltrailerList", tooltrailerList);

		return "trailerinventory";
	}

	// test button changed action depending on what needed to be tested. Can result
	// in magic or Doom.
//	@RequestMapping (value ="/magicdoom", method=RequestMethod.POST)
//	public String magicDoom() {
//		toolTrailerService.magicDoom();
//		return "redirect:/";
//	}

	// This loads any trailer with 0 inventory for first time.

	@RequestMapping(value = "/build", method = RequestMethod.POST)
	public String buildToolTrailer() {
		toolTrailerService.buildToolTrailer();
		return "redirect:/trailerinventory";
	}

	// inventory page.. has all items (very long)
	@RequestMapping("/fulltrailerinventory")
	public String viewFullInventory(Model model) {
		List<ToolTrailerInventory> tooltrailerList = toolTrailerService.listAll();

		System.out.println("<<<<<--- testing viewIntentory  " + tooltrailerList.size());
		// need tool trailer list
		// but also need tool list for the name of the tool

		model.addAttribute("tooltrailerList", tooltrailerList);
		return "fulltrailerinventory";
	}

	// This loads any tools that have not been added to an individual trailer. to
	// build a trailer from 0 use build.
	@RequestMapping("/load_trailer/{trailerId}")
	public ModelAndView loadTrailerShowSelectedInventory(@PathVariable(name = "trailerId") int trailerId) {

		ModelAndView mav = new ModelAndView("inventorybytrailer");

		toolTrailerService.loadNewTools(trailerId);
		List<ToolTrailerInventory> selectedToolTrailerList = toolTrailerService.selectedTrailerInventory(trailerId);
		mav.addObject("selectedToolTrailerList", selectedToolTrailerList);

		return mav;
	}

	// having issues with following delete/ edit.. so added trailerlist and toollist
	// to test
	// This shows the inventory of ONE trailer.
	@RequestMapping("/inventory/{trailerId}")
	public ModelAndView showSelectedInventory(@PathVariable(name = "trailerId") int trailerId) {

		ModelAndView mav = new ModelAndView("inventorybytrailer");

		List<ToolTrailerInventory> selectedToolTrailerList = toolTrailerService.selectedTrailerInventory(trailerId);
		List<Trailer> trailerList = trailerService.listAll();
		List<Tool> toolList = toolService.listAll();
		mav.addObject("selectedToolTrailerList", selectedToolTrailerList);
		mav.addObject("trailerList", trailerList);
		mav.addObject("toolList", toolList);

		return mav;
	}

	// this deletes one inventory item (tooltrailerinventory item) from a trailer.
	@RequestMapping("/delete_inventory_item/{trailerId}/{toolId}")
	public String deleteInventoryItem(@PathVariable(name = "trailerId") Integer trailerId,
			@PathVariable(value = "toolId") int toolId) {

		toolTrailerService.deleteInventoryItem(toolId, trailerId);
		return "redirect:/inventory/{trailerId}";
	}

	// page to perform detailed inventory for an individual item
	@RequestMapping("/edit_inventory_item/{trailerId}/{toolId}")
	public ModelAndView editInventoryItem(@PathVariable(name = "trailerId") Integer trailerId,
			@PathVariable(value = "toolId") int toolId) {
		ModelAndView mav = new ModelAndView("iteminventory");
		ToolTrailerInventory tooltrailerinventory = toolTrailerService.getItem(toolId, trailerId);
		mav.addObject("tooltrailerinventory", tooltrailerinventory);
		return mav;
	}

	@RequestMapping(value = "/save_item", method = RequestMethod.POST)
	public String saveItem(@ModelAttribute("tooltrailerinventory") ToolTrailerInventory tooltrailerinventory) {
		toolTrailerService.saveItem(tooltrailerinventory);
		// would prefer to redirect to /inventory/{trailerId}
		return "redirect:/trailerinventory/";
	}

}
