/**
 * 
 */
package org.perscholas.ToolbeltCaseStudy.services;

import java.util.List;

import org.perscholas.ToolbeltCaseStudy.models.Tool;
import org.perscholas.ToolbeltCaseStudy.repositories.ToolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Jenny
 *
 */
//This service handles tasks for Tool Class

@Service
public class ToolService {
	
@Autowired
private ToolRepository toolRepo;

//CRUD methods

public List<Tool> listAll() {
	
	return toolRepo.findAll();
}

public void save(Tool tool) {
	toolRepo.save(tool);
}

public Tool get (int id) {
	return toolRepo.findById(id).get();
}

public void delete 	(int id) {
	toolRepo.deleteById(id);
}
	

}
