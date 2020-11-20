package com.techjava.registration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techjava.registration.exceptions.ResourceNotFoundException;
import com.techjava.registration.exceptions.UserValidate;
import com.techjava.registration.model.Registration;
import com.techjava.registration.services.RegistrationService;


@RestController
@RequestMapping("/booking")
public class RegistrationController {

    @Autowired
    private  RegistrationService registrationService;

  
//@GetMapping("/tickets")
//public List<Registration> getdta()
//{
//return re.findAll();
//}
   
    @PostMapping("/createTicket")
    public Registration createdata(@RequestBody Registration data) throws ResourceNotFoundException{
    	UserValidate vali=new UserValidate();
    	Registration data1=new Registration();
    	boolean v=vali.validateUser(data.getUserId());
    boolean v1=	vali.validatePassword(data.getPassword());
    if(data.getUserId().equals("") || data.getPassword().equals("") || data.getEmailId().equals(""))
	{
		throw new ResourceNotFoundException("Enter valid data");
	}
    if(v)
    { 
    	if(v1)
    	{
    		 data1= registrationService.createdata(data);;
    	}
    	else
    	{
    		throw new ResourceNotFoundException("Enter valid Password ");
    	}
    }else
    {
    	throw new ResourceNotFoundException("Enter valid UserId ");
    }
        return data1;
    }

}
