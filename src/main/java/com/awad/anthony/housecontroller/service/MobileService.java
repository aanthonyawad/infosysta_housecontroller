package com.awad.anthony.housecontroller.service;

import java.util.ArrayList;
import java.util.List;

import com.awad.anthony.housecontroller.entitities.Mobile;

public interface MobileService {

	List<Mobile> findAll();

	Mobile save(Mobile mobile);

	Mobile findOne(int id);

	Mobile findOneConnected(int id);

}
