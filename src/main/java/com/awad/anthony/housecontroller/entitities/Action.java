package com.awad.anthony.housecontroller.entitities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.awad.anthony.housecontroller.entititiesserilalizer.ActionSerliazer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@Table(name="action")
@JsonSerialize(using = ActionSerliazer.class)
public class Action {
	
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	

    @ManyToOne
    @JoinColumn(name = "mobile_id")
    Mobile mobile;
    

    @ManyToOne
    @JoinColumn(name = "activity_id")
    Activity activity;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="insert_date")
	private Date insertDate;
	
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="update_date")
	private Date updateDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Mobile getMobile() {
		return mobile;
	}

	public void setMobile(Mobile mobile) {
		this.mobile = mobile;
	}

	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	public Date getInsertDate() {
		return insertDate;
	}

	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public Action() {}
	public Action(int id, Mobile mobile, Activity activity, Date insertDate, Date updateDate) {
		super();
		this.id = id;
		this.mobile = mobile;
		this.activity = activity;
		this.insertDate = insertDate;
		this.updateDate = updateDate;
	}
	

}
