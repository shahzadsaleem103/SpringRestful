package com.springrest.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.model.User;
import com.springrest.service.UserSerImp;

@RestController
public class UserController {

	@Autowired
	UserSerImp service;
	
	
	@GetMapping("/users")
	public List<User> list() {
	    return service.listAll();
	}

	@GetMapping("/user/{id}")
	public ResponseEntity<User> get(@PathVariable Integer id) {
	    try {
	        User user = service.get(id);
	        return new ResponseEntity<User>(user, HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
	    }      
	}

	
	@PostMapping("/user")
	public void add(@RequestBody User user) {
	    service.save(user);
	}

	@DeleteMapping("/user/{id}")
	public void delete(@PathVariable Integer id) {
	    service.delete(id);
	}

	@PutMapping("/user/{id}")
	public ResponseEntity<?> updateNote(@PathVariable(value = "id") Integer Id,
	                                         @RequestBody User user) {
		 try {
		User usernew = service.get(Id);

		usernew.setId(user.getId());
	    usernew.setName(user.getName());
	    usernew.setEmail(user.getEmail());
	    usernew.setPassword(user.getPassword());

	     service.save(usernew);
	     return new ResponseEntity<>(HttpStatus.OK);
	}
		 catch (NoSuchElementException e) {
		        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		    }      

}
}