package com.techjava.registration.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techjava.registration.model.Registration;


@Repository
public interface RegistrationDao extends JpaRepository<Registration,String>{
    
	
}
