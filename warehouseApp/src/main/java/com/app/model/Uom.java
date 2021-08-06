package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="uom")
public class Uom {
	@Id
	@GeneratedValue
	@Column(name="id")
	private Integer uId;
	@Column(name="type")
	private String uType;
	@Column(name="model")
	private String uModel;
	@Column(name="note")
	private String uDes;
	public Uom() {
		super();
	}
	public Uom(Integer uId) {
		super();
		this.uId = uId;
	}
	public Integer getuId() {
		return uId;
	}
	public void setuId(Integer uId) {
		this.uId = uId;
	}
	public String getuType() {
		return uType;
	}
	public void setuType(String uType) {
		this.uType = uType;
	}
	public String getuModel() {
		return uModel;
	}
	public void setuModel(String uModel) {
		this.uModel = uModel;
	}
	public String getuDes() {
		return uDes;
	}
	public void setuDes(String uDes) {
		this.uDes = uDes;
	}
	@Override
	public String toString() {
		return "Uom [uId=" + uId + ", uType=" + uType + ", uModel=" + uModel + ", uDes=" + uDes + "]";
	}
	
	

}
