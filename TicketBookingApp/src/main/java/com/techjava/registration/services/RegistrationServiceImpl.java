package com.techjava.registration.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techjava.registration.dao.RegistrationDao;
import com.techjava.registration.model.Registration;
@Service
public class RegistrationServiceImpl implements RegistrationService{
@Autowired
private RegistrationDao da;
	@Override
	public Registration createdata(Registration data) {
		
		return da.save(data);
	}

}
