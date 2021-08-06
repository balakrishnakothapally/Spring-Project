package com.app.dao.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IUserDao;
import com.app.model.User;
@Repository
public class UserDaoImpl implements IUserDao {
	@Autowired
	private HibernateTemplate ht;
	

	public Integer saveUser(User u) {
		return (Integer) ht.save(u);
	}

	
	public void updateUser(User u) {
		ht.update(u);
	}

	
	public void deleteUser(Integer id) {
		User u=new User();
		u.setUserId(id);
		ht.delete(u);
		
	}

	
	public User getUserById(Integer id) {
		User u=ht.get(User.class, id);
		return u;
	}

	
	public List<User> getAllUsers() {
		List<User> ur=ht.loadAll(User.class);
		return ur;
	}


	@Override
	public List<Object[]> getUserCountByRole() {
		String hql=" select userName,count(userName) "
				+" from " + User.class.getName()
				+" group by userName ";
		List<Object[]>list=(List<Object[]>)ht.find(hql);
		
		return list;
	}

}
