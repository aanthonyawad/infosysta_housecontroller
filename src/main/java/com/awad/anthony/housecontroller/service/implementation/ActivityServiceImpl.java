package com.awad.anthony.housecontroller.service.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.awad.anthony.housecontroller.entitities.Activity;
import com.awad.anthony.housecontroller.repositories.ActivityRepository;
import com.awad.anthony.housecontroller.service.ActivityService;

@Service("ActivityService")
@Repository
@Transactional
public class ActivityServiceImpl implements ActivityService {

	@PersistenceContext
	private EntityManager em;

	@Autowired
	ActivityRepository activityRepository;


	@Override
	public Activity findByName(String name) {
		String query = "SELECT activity from Activity activity where activity.name = ?1 ";
		List<Activity> activities = em.createQuery(query).setParameter(1, name)
				.getResultList();
		if(activities.size() > 0) {
			return activities.get(0);
		}
		return null;
	}

}
