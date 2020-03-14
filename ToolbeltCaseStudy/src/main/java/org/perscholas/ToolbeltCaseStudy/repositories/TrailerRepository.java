/**
 * 
 */
package org.perscholas.ToolbeltCaseStudy.repositories;

import org.perscholas.ToolbeltCaseStudy.models.Trailer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Jenny
 *
 */
@Repository
public interface TrailerRepository extends JpaRepository <Trailer, Integer>{

}
