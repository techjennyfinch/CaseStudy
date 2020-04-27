/**
 * 
 */
package org.perscholas.ToolbeltCaseStudy.controllers;

import java.util.List;

import org.perscholas.ToolbeltCaseStudy.models.Trailer;
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

@Controller
public class TrailerController {

	@Autowired
	private TrailerService trailerservice;

	// starting site for trailer
	@RequestMapping("/trailer")
	public String viewTrailers(Model model) {
		List<Trailer> trailerList = trailerservice.listAll();

		System.out.println(trailerList.size());
		model.addAttribute("trailerList", trailerList);
		return "trailer";
	}

	// this loads site to add new trailer
	@RequestMapping("newtrailer")
	public String showNewTrailerForm(Model model) {
		Trailer trailer = new Trailer();
		model.addAttribute("trailer", trailer);
		return "newtrailer";
	}

	// saves a trailer after adding or editing.
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveTrailer(@ModelAttribute("trailer") Trailer trailer) {
		trailerservice.save(trailer);
		return "redirect:/trailer";
	}

	// site to edit a trailer
	@RequestMapping("/edit_trailer/{trailerId}")
	public ModelAndView showEditTrailerForm(@PathVariable(name = "trailerId") int trailerId) {

		ModelAndView mav = new ModelAndView("edit_trailer");
		Trailer trailer = trailerservice.get(trailerId);
		mav.addObject("trailer", trailer);

		return mav;
	}

	// delete a trailer. Careful..
	@RequestMapping("/delete/{trailerId}")
	public String deleteTrailer(@PathVariable(name = "trailerId") int trailerId) {

		trailerservice.delete(trailerId);
		return "redirect:/trailer";
	}

}
