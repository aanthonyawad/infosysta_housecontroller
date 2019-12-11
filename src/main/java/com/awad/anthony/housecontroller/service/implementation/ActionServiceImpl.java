package com.awad.anthony.housecontroller.service.implementation;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.awad.anthony.housecontroller.entitities.Action;
import com.awad.anthony.housecontroller.repositories.ActionRepository;
import com.awad.anthony.housecontroller.service.ActionService;

@Service("ActionService")
@Repository
@Transactional
public class ActionServiceImpl implements ActionService {

	@PersistenceContext
	private EntityManager em;

	@Autowired
	ActionRepository actionRepository;
	
	@Override
	public Action insert(Action action) {
		return actionRepository.save(action);
		
	}

}
