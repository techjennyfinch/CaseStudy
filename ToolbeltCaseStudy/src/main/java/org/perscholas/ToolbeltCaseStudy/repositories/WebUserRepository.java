/**
 * 
 */
package org.perscholas.ToolbeltCaseStudy.repositories;

import org.perscholas.ToolbeltCaseStudy.models.WebUser;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

/**
 * @author Jenny
 *
 */
@Repository
public interface WebUserRepository extends JpaRepository <WebUser, String> {

	
	//findby Username and delete by username are likely not needed as it is the primary key. 
	//but it appears to be Optional which may be if it exists. find.
	WebUser findByUserName(String userName);


	WebUser  deleteByUserName (String userName);

}