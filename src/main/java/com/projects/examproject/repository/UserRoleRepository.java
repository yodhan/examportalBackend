package com.projects.examproject.repository;

import com.projects.examproject.entity.Role;
import com.projects.examproject.entity.UserRoles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRoles, Long> {
    public void save(Role userRoles);
}
