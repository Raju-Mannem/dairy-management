package com.mavenproject.practice.dairyapp.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mavenproject.practice.dairyapp.business.UserBusinessInterface;
import com.mavenproject.practice.dairyapp.business.EntryBusinessInterface;
import com.mavenproject.practice.dairyapp.entities.User;
import com.mavenproject.practice.dairyapp.entities.Entry;

@Controller
public class HomeController {
	
	@Autowired
	private UserBusinessInterface userBusinessInterface;
	
	@Autowired
	HttpSession session;
	
	@Autowired
	private EntryBusinessInterface entryBusinessInterface;
	
	@RequestMapping("home")
	public ModelAndView homepage() {
		ModelAndView model = new ModelAndView("home");
		
		return model;
	}
	
	@RequestMapping("register")
	public ModelAndView registrationpage() {
		ModelAndView model = new ModelAndView("register");
		
		return model;
	}
	
	@RequestMapping(value="userregister", method=RequestMethod.POST)
	public ModelAndView saveUser(@ModelAttribute("user") User user) {
		ModelAndView model =  new ModelAndView("registersucess");
		userBusinessInterface.save(user);
		return model;
	}
	
	@RequestMapping(value="login", method=RequestMethod.POST)
	public ModelAndView login(@ModelAttribute("user") User user) {
		
		ModelAndView model = new ModelAndView("home");
		
		User user1 = userBusinessInterface.findByUsername(user.getUsername());
		
		if(user1!=null && user.getPassword().equals(user1.getPassword())) {
			model.setViewName("userhome");
			model.addObject("user",user1);
			
			session.setAttribute("user", user1);
			List<Entry> entries = null;
			
			
			try {
				entries = entryBusinessInterface.findByUserid(user.getId());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			model.addObject("entrieslist",entries);
		}
		
		return model;
	}
	
	@RequestMapping(value="addentry")
	public ModelAndView addEntry() {
		
		ModelAndView model = new ModelAndView("addentry");
		return model;
	}
	
	@RequestMapping("saveentry")
	public ModelAndView saveentry(@ModelAttribute("entry") Entry entry){
		ModelAndView model = new ModelAndView("userhome");
		entryBusinessInterface.save(entry);
		User user1 = (User)session.getAttribute("user");
		
		List<Entry> entries=null;
		try {
			entries = entryBusinessInterface.findByUserid(user1.getId());
		}
		catch(Exception e){
			e.printStackTrace();
		}
		model.addObject("entrieslist",entries);
		return model;
	}
	
	@RequestMapping(value="viewentry")
	public ModelAndView viewEntry(@RequestParam("id") int id) {
		
		ModelAndView model = new ModelAndView("displayentry");
		
		Entry entry = entryBusinessInterface.findById(id);
		model.addObject("entry",entry);
		return model;
	}
	
	@RequestMapping("userhomepage")
	public ModelAndView userhome() {
		ModelAndView model = new ModelAndView("userhome");
		User user1 = (User)session.getAttribute("user");
		List<Entry> entries = null;
		try {
			entries = entryBusinessInterface.findByUserid(user1.getId());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		model.addObject("entrieslist",entries);
		return model;
	}
	
	@RequestMapping("updateentry")
	public ModelAndView updateentry(@RequestParam("id") int id){
		ModelAndView model = new ModelAndView("displayupdateentry");
		Entry entry = entryBusinessInterface.findById(id);
		model.addObject("entry",entry);
		User user1 = (User)session.getAttribute("user");
		if(user1 == null) {
			model.setViewName("home");
		}
		return model;
	}
	
	@RequestMapping("processupdateentry")
	public ModelAndView processupdateentry(@ModelAttribute("entry") Entry entry){
		ModelAndView model = new ModelAndView("userhome");
		entryBusinessInterface.update(entry);
		User user1 = (User)session.getAttribute("user");
		
		List<Entry> entries=null;
		try {
			entries = entryBusinessInterface.findByUserid(user1.getId());
		}
		catch(Exception e){
			e.printStackTrace();
		}
		model.addObject("entrieslist",entries);
		return model;
	}
	
	@RequestMapping("deleteentry")
	public ModelAndView deleteentry(@RequestParam("id") int id){
		ModelAndView model = new ModelAndView("userhome");
		Entry entry = entryBusinessInterface.findById(id);
		entryBusinessInterface.delete(entry);
		User user1 = (User)session.getAttribute("user");
		
		List<Entry> entries=null;
		try {
			entries = entryBusinessInterface.findByUserid(user1.getId());
		}
		catch(Exception e){
			e.printStackTrace();
		}
		model.addObject("entrieslist",entries);
		
		return model;
	}
	@RequestMapping("logout")
	public ModelAndView logout() {
		
		ModelAndView model = new ModelAndView("home");

		session.invalidate();
		
		return model;
	}
	
	
		public UserBusinessInterface getUserBusinessInterface() {
		return userBusinessInterface;
	}

	public void setUserBusinessInterface(UserBusinessInterface userBusinessInterface) {
		this.userBusinessInterface = userBusinessInterface;
	}

	public EntryBusinessInterface getEntryBusinessInterface() {
		return entryBusinessInterface;
	}

	public void setEntryBusinessInterface(EntryBusinessInterface entryBusinessInterface) {
		this.entryBusinessInterface = entryBusinessInterface;
	}
}
