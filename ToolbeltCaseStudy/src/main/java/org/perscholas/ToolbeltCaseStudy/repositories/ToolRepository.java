/**
 * 
 */
package org.perscholas.ToolbeltCaseStudy.repositories;


import org.perscholas.ToolbeltCaseStudy.models.Tool;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Jenny
 *
 */
@Repository
public interface ToolRepository extends JpaRepository <Tool, Integer>{
	


}
