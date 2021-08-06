package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IOrderMethodDao;
import com.app.model.OrderMethod;
@Repository
public class OrderMethodDaoImpl implements IOrderMethodDao {
	@Autowired
	private HibernateTemplate ht;

	@Override
	public Integer saveOrderMethod(OrderMethod om) {

		return (Integer)ht.save(om);
	}

	@Override
	public void updateOrderMethod(OrderMethod om) {
		ht.update(om);
	}

	@Override
	public void deleteOrderMethod(Integer id) {
		OrderMethod om=new OrderMethod();
		om.setOrderId(id);
		ht.delete(om);
	}

	
	@Override
	public OrderMethod getOrderMethodById(Integer id) {
		OrderMethod om=ht.get(OrderMethod.class, id);
		return om;
	}

	@Override
	public List<OrderMethod> getAllOrderMethodTypes() {
		List<OrderMethod> lts=ht.loadAll(OrderMethod.class);

		return lts;
	}

	
	public List<Object[]> getOrderMethodCountByMode() {
		String hql=
				" select orderMode,count(orderMode) "
				+" from " + OrderMethod.class.getName()
				+" group by orderMode ";
		List<Object[]>list=(List<Object[]>)ht.find(hql);
		return list;

		
	}

}
