/**
 * 
 */
package org.perscholas.ToolbeltCaseStudy.repositories;

import org.perscholas.ToolbeltCaseStudy.models.WebUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author Jenny
 *
 */
@Repository
public interface WebUserRepository extends JpaRepository <WebUser, String> {

	WebUser findByUserName(String userName);

//	@Query("SELECT w FROM WebUser WHERE w.userName")
//	WebUser findByUsername (String userName);
	
//	@Query("SELECT w FROM WebUser WHERE w.userName")
	WebUser  deleteByUserName (String userName);

}