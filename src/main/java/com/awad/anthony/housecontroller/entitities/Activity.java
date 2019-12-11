package com.awad.anthony.housecontroller.entitities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.awad.anthony.housecontroller.entititiesserilalizer.ActivitySerliazer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@Table(name="activity")
@JsonSerialize(using = ActivitySerliazer.class)
public class Activity {
	
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	@Column(name="name")
	String name;
	
	@OneToMany(mappedBy = "activity")
    List<Action> actions;
	public Activity() {
		
	}
	public Activity(int id, String name, List<Action> actions) {
		super();
		this.id = id;
		this.name = name;
		this.actions = actions;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Action> getActions() {
		return actions;
	}

	public void setActions(List<Action> actions) {
		this.actions = actions;
	}
	
}
