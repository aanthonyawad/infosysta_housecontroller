package com.awad.anthony.housecontroller.service.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.awad.anthony.housecontroller.entitities.Activity;
import com.awad.anthony.housecontroller.entitities.Mobile;
import com.awad.anthony.housecontroller.repositories.MobileRepository;
import com.awad.anthony.housecontroller.service.MobileService;

@Service("MobileService")
@Repository
@Transactional
public class MobileServiceImpl implements MobileService {
	
	@PersistenceContext
	private EntityManager em;

	@Autowired
	MobileRepository mobileRepository;

	@Override
	public List<Mobile> findAll() {
		return mobileRepository.findAll();
	}

	@Override
	public Mobile save(Mobile mobile) {
		return mobileRepository.save(mobile);
	}


	@Override
	public Mobile findOne(int id) {
		Optional<Mobile> oMobile = mobileRepository.findById(id);
		return oMobile.orElse(new Mobile());
	}

	@Override
	public Mobile findOneConnected(int id) {
		String query = "SELECT mobile from Mobile mobile where mobile.id = ?1 and mobile.connected = true ";
		List<Mobile> mobiles = em.createQuery(query).setParameter(1, id)
				.getResultList();
		if(mobiles.size() > 0) {
			return mobiles.get(0);
		}
		return null;
	}

}
