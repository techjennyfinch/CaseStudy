/**
 * 
 */
package org.perscholas.ToolbeltCaseStudy.controllers;

import java.util.List;

import org.perscholas.ToolbeltCaseStudy.models.Tool;
import org.perscholas.ToolbeltCaseStudy.services.ToolService;
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

//Controller mapping for sites and actions related to the tools 

@Controller
public class ToolController {

	@Autowired
	private ToolService toolservice;

	@RequestMapping("/tool")
	public String viewTools(Model model) {
		List<Tool> toolList = toolservice.listAll();

		System.out.println(toolList.size());
		model.addAttribute("toolList", toolList);
		return "tool";
	}

	@RequestMapping("new_tool")
	public String showNewToolForm(Model model) {
		Tool tool = new Tool();
		model.addAttribute("tool", tool);
		return "new_tool";
	}

	@RequestMapping(value = "/save_tool", method = RequestMethod.POST)
	public String savetool(@ModelAttribute("tool") Tool tool) {
		toolservice.save(tool);
		return "redirect:/tool";
	}

	@RequestMapping("/edit_tool/{toolId}")
	public ModelAndView showEditToolForm(@PathVariable(name = "toolId") int toolId) {

		ModelAndView mav = new ModelAndView("edit_tool");
		Tool tool = toolservice.get(toolId);
		mav.addObject("tool", tool);

		return mav;
	}

	@RequestMapping("/delete_tool/{toolId}")
	public String deleteTool(@PathVariable(name = "toolId") int toolId) {

		toolservice.delete(toolId);
		return "redirect:/tool";
	}

}
