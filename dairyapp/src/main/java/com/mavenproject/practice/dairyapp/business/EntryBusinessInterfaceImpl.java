package com.mavenproject.practice.dairyapp.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mavenproject.practice.dairyapp.dao.EntryDaoInterface;
import com.mavenproject.practice.dairyapp.entities.Entry;
@Component
public class EntryBusinessInterfaceImpl implements EntryBusinessInterface {
	@Autowired
	private EntryDaoInterface entryDaoInterface;
	public void save(Entry entry) {
		// TODO Auto-generated method stub
		entryDaoInterface.save(entry);
	}

	public void update(Entry entry) {
		// TODO Auto-generated method stub
		entryDaoInterface.update(entry);

	}

	public void delete(Entry entry) {
		// TODO Auto-generated method stub
		entryDaoInterface.delete(entry);

	}

	public Entry findById(int id) {
		// TODO Auto-generated method stub
		return entryDaoInterface.findById(id);
	}

	public List<Entry> findAll() {
		// TODO Auto-generated method stub
		return entryDaoInterface.findAll();
	}
	
	public List<Entry> findByUserid(int id) {
		// TODO Auto-generated method stub
		return entryDaoInterface.findByUserid(id);
	}

}
