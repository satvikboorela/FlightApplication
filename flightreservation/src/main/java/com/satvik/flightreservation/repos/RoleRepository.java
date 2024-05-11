package com.satvik.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.satvik.flightreservation.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
