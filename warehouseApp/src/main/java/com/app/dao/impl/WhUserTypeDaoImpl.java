package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IWhUserTypeDao;
import com.app.model.WhUserType;
@Repository
public class WhUserTypeDaoImpl implements IWhUserTypeDao{
	@Autowired
	private HibernateTemplate ht;

	@Override
	public Integer saveWhUserType(WhUserType u) {
		return (Integer)ht.save(u);
	}

	@Override
	public void updateWhUserType(WhUserType u) {
		
		ht.update(u);
	}

	
	public void deleteWhUserType(Integer id) {
		WhUserType wt=new WhUserType();
		wt.setUserId(id);
		ht.delete(wt);
	}

	@Override
	public WhUserType getWhUserTypeById(Integer id) {
		WhUserType u=ht.get(WhUserType.class, id);
		return u;
	}

	@Override
	public List<WhUserType> getAllWhUserTypes() {
		List<WhUserType>lts=ht.loadAll(WhUserType.class);
		return lts;
	}

	@Override
	public List<Object[]> getWhUserCountByType() {
		String hql=
				" select userType,count(userType) "
				+" from " + WhUserType.class.getName()
				+" group by userType ";
		List<Object[]> list=(List<Object[]>)ht.find(hql);
		return list;
	}

}
