package com.awad.anthony.housecontroller.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.awad.anthony.housecontroller.entitities.Activity;

public interface ActivityRepository extends JpaRepository<Activity, Integer> {
	
}
