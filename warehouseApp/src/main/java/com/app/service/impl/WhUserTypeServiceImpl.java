package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IWhUserTypeDao;
import com.app.model.WhUserType;
import com.app.service.IWhUserTypeService;
@Service
public class WhUserTypeServiceImpl  implements IWhUserTypeService{
	@Autowired
	private IWhUserTypeDao dao;

	@Transactional
	public Integer saveWhUserType(WhUserType u) {
		return (Integer)dao.saveWhUserType(u);
	}

	@Transactional
	public void updateWhUserType(WhUserType u) {
		dao.updateWhUserType(u);
	}

	@Transactional
	public void deleteWhUserType(Integer id) {
		dao.deleteWhUserType(id);
	}
	@Transactional(readOnly=true)
	public WhUserType getWhUserTypeById(Integer id) {

		return dao.getWhUserTypeById(id);
	}

	@Transactional(readOnly=true)

	public List<WhUserType> getAllWhUserTypes() {
		return dao.getAllWhUserTypes();
	}

	@Override
	public List<Object[]> getWhUserCountByType() {

		return dao.getWhUserCountByType();
	}

}
