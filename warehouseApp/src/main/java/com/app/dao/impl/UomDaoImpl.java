package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IUomDao;
import com.app.model.Uom;
@Repository
public class UomDaoImpl implements IUomDao {
	@Autowired
	private HibernateTemplate ht;

	
	public Integer saveUom(Uom u) {

		return (Integer)ht.save(u);
	}

	
	public void updateUom(Uom u) {
		ht.update(u);

	}

	
	public void deleteUom(Integer id) {
		
		Uom u=new Uom();
		u.setuId(id);
		ht.delete(u);
	}

	
	public Uom getUomById(Integer id) {
		Uom u=ht.get(Uom.class, id);
		return u;
	}

	
	public List<Uom> getAllUoms() {
		List<Uom>lts=ht.loadAll(Uom.class);
		return lts;
	}


	@Override
	public List<Object[]> getUomCountByType() {
		
		String hql=
				" select uType,count(uType) "
				+" from " + Uom.class.getName()
						+" group by uType ";
		List<Object[]> list=(List<Object[]>)ht.find(hql);
		return list;
	}

}
