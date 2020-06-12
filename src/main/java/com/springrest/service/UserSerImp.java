package com.springrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.model.User;

@Service
public class UserSerImp {

	@Autowired
	UserServiceI service;
	
		public User get(Integer id) {
	        return service.findById(id).get();
	    }
	    
		public List<User> listAll() {
	        return service.findAll();
	    }
	     
	    public void save(User user) {
	        service.save(user);
	    }
	     
	     
	    public void delete(Integer id) {
	    	service.deleteById(id);
	    }
	
	    
	
}
