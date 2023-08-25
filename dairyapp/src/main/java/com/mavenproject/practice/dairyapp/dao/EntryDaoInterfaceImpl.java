package com.mavenproject.practice.dairyapp.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mavenproject.practice.dairyapp.entities.Entry;

@Component
@Repository
public class EntryDaoInterfaceImpl implements EntryDaoInterface {
	
	EntryDaoInterfaceImpl(){
	}
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Transactional(readOnly = false)
	public void save(Entry entry) {
		// TODO Auto-generated method stub
		hibernateTemplate.save(entry);
		

	}
	
	@Transactional(readOnly = false)
	public void update(Entry entry) {
		// TODO Auto-generated method stub
		hibernateTemplate.update(entry);

	}
	
	@Transactional(readOnly = false)
	public void delete(Entry entry) {
		// TODO Auto-generated method stub
		hibernateTemplate.delete(entry);
		
	}

	
	public Entry findById(int id) {
		// TODO Auto-generated method stub
		return hibernateTemplate.get(Entry.class, id);
	}

	public List<Entry> findAll() {
		// TODO Auto-generated method stub
		List<Entry> list = hibernateTemplate.loadAll(Entry.class);
		return list;
	}
	

	public List<Entry> findByUserid(int id) {
		// TODO Auto-generated method stub
		DetachedCriteria criteria = DetachedCriteria.forClass(Entry.class);
		criteria.add(Restrictions.eq("userid",id));		
		List<Entry> entries = (List<Entry>)hibernateTemplate.findByCriteria(criteria);
		return entries;
	}
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
}
