package com.app.dao;

import java.util.List;

import com.app.model.WhUserType;

public interface IWhUserTypeDao {
	public Integer saveWhUserType(WhUserType u);
	public void updateWhUserType(WhUserType u);
	public void deleteWhUserType(Integer id);
	public WhUserType getWhUserTypeById(Integer id);
	public List<WhUserType> getAllWhUserTypes();
	public List<Object[]> getWhUserCountByType();

}
