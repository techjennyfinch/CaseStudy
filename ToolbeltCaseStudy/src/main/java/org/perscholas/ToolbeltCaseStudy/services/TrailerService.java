/**
 * 
 */
package org.perscholas.ToolbeltCaseStudy.services;

import java.util.List;

import org.perscholas.ToolbeltCaseStudy.models.Trailer;
import org.perscholas.ToolbeltCaseStudy.repositories.TrailerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Jenny
 *
 */
@Service
public class TrailerService {
	
@Autowired
private TrailerRepository trailerRepo;

public List<Trailer> listAll() {
	
	return trailerRepo.findAll();
}

public void save(Trailer trailer) {
	trailerRepo.save(trailer);
}

public Trailer get (int id) {
	return trailerRepo.findById(id).get();
}

public void delete 	(int id) {
	trailerRepo.deleteById(id);
}
	

}
