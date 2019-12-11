package com.awad.anthony.housecontroller.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.awad.anthony.housecontroller.entitities.Action;

public interface ActionRepository extends JpaRepository<Action, Integer> {
	
}

