package com.mavenproject.practice.dairyapp.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mavenproject.practice.dairyapp.entities.User;

@Component
@Repository
public class UserDaoInterfaceImpl implements UserDaoInterface {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Transactional
	public void save(User user) {
		// TODO Auto-generated method stub
		hibernateTemplate.save(user);

	}
	
	@Transactional
	public void update(User user) {
		// TODO Auto-generated method stub
		hibernateTemplate.update(user);

	}
	
	@Transactional
	public void delete(User user) {
		// TODO Auto-generated method stub
		hibernateTemplate.delete(user);

	}
	
	@Transactional
	public User findById(int id) {
		// TODO Auto-generated method stub
		
		return hibernateTemplate.get(User.class, id);
	}

	public List<User> findAll() {
		// TODO Auto-generated method stub
		
		return hibernateTemplate.loadAll(User.class);
	}
	
	public User findByUsername(String username){
	
DetachedCriteria criteria = DetachedCriteria.forClass(User.class);
		
		criteria.add(Restrictions.eq("username", username));

		User user = null;
		
		try {
			user=(User)hibernateTemplate.findByCriteria(criteria).get(0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return user;
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

}
