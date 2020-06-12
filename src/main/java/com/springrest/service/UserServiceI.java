package com.springrest.service;
import org.springframework.data.jpa.repository.JpaRepository;

import com.springrest.model.User;


public interface UserServiceI extends JpaRepository<User, Integer>{

}
