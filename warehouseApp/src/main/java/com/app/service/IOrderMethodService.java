package com.app.service;

import java.util.List;

import com.app.model.OrderMethod;

public interface IOrderMethodService {
	public Integer saveOrderMethod(OrderMethod om);
	public void updateOrderMethod(OrderMethod om);
	public void deleteOrderMethod(Integer id);
	public OrderMethod getOrderMethodById(Integer id);
	public List<OrderMethod> getAllOrderMethodTypes();
	public List<Object[]> getOrderMethodCountByMode();


}
