package com.kate.notflixapp.repositories.Mysql;

import com.kate.notflixapp.domainClasses.Mysql.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
