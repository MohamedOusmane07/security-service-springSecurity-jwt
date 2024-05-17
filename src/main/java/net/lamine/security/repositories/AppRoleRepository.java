package net.lamine.security.repositories;

import net.lamine.security.entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRoleRepository extends JpaRepository<AppRole,Long> {
     AppRole findByRoleName(String roleName);
}
