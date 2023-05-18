package com.hibernate.Hibernate.one.to.one.mapping.Repository;

import com.hibernate.Hibernate.one.to.one.mapping.Model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Optional<Role> findByName(String name);
}
