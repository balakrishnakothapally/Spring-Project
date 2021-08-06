package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IShipmentTypeDao;
import com.app.model.ShipmentType;
@Repository
public class ShipmentTypeDaoImpl implements IShipmentTypeDao {
	@Autowired
	private HibernateTemplate ht;

	public Integer saveShipmentType(ShipmentType s) {
		return (Integer) ht.save(s);
	}

	public void updateShipmentType(ShipmentType s) {
		ht.update(s);

	}

	public void deleteShipmentType(Integer id) {
		ShipmentType s=new ShipmentType();
		s.setShipmentId(id);
		ht.delete(s);

	}

	public ShipmentType getShipmentTypeById(Integer id) {
		ShipmentType s=ht.get(ShipmentType.class, id);
		// TODO Auto-generated method stub
		return s;
	}

	public List<ShipmentType> getAllShipmentTypes() {
		List<ShipmentType>lts=ht.loadAll(ShipmentType.class);
		return lts;
	}

	@Override
	public List<Object[]> getShipmentCountByMode() {
		String hql=" select shipmentMode,count(shipmentMode) "
				   +"  from " + ShipmentType.class.getName()
				   +"  group by shipmentMode ";

		List<Object[]>list=(List<Object[]>)ht.find(hql);
		
		return list;
	}

}
