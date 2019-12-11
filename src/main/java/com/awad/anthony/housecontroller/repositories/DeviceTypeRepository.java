package com.awad.anthony.housecontroller.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.awad.anthony.housecontroller.entitities.DeviceType;

public interface DeviceTypeRepository extends JpaRepository<DeviceType, Integer> {
	
}
