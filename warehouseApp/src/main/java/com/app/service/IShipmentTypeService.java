package com.app.service;

import java.util.List;

import com.app.model.ShipmentType;

public interface IShipmentTypeService {
	public Integer saveShipmentType(ShipmentType s);
	public void updateShipmentType(ShipmentType s);
	public void deleteShipmentType(Integer id);
	public ShipmentType getShipmentTypeById(Integer id);
	public List<ShipmentType>getAllShipmentTypes();
	public List<Object[]> getShipmentCountByMode();

}
