package org.perscholas.ToolbeltCaseStudy.repositories;

import org.perscholas.ToolbeltCaseStudy.models.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository <UserRole, Integer> {

}
