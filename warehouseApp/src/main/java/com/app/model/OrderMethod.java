package com.app.model;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OrderColumn;
import javax.persistence.Table;


@Entity
@Table(name="omtab")
public class OrderMethod {
	@Id
	@GeneratedValue
	@Column(name="omid")
	private Integer orderId;
	@Column(name="ommode")
	private String orderMode;
	@Column(name="omcode")
	private String orderCode;
	@Column(name="omextype")
	private String exeType;
	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(name="omacpttab",joinColumns=@JoinColumn(name="omid"))
	@OrderColumn(name="pos")
	@Column(name="data")
	private List<String>orderAccepts;
	@Column(name="omnote")
	private String note;
	public OrderMethod() {
		super();
	}
	public OrderMethod(Integer orderId) {
		super();
		this.orderId = orderId;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public String getOrderMode() {
		return orderMode;
	}
	public void setOrderMode(String orderMode) {
		this.orderMode = orderMode;
	}
	public String getOrderCode() {
		return orderCode;
	}
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
	public String getExeType() {
		return exeType;
	}
	public void setExeType(String exeType) {
		this.exeType = exeType;
	}
	public List<String> getOrderAccepts() {
		return orderAccepts;
	}
	public void setOrderAccepts(List<String> orderAccepts) {
		this.orderAccepts = orderAccepts;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	@Override
	public String toString() {
		return "OrderMethod [orderId=" + orderId + ", orderMode=" + orderMode + ", orderCode=" + orderCode
				+ ", exeType=" + exeType + ", orderAccepts=" + orderAccepts + ", note=" + note + "]";
	}
	
	
}
