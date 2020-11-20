package com.techjava.ticketbooking.test;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.techjava.registration.dao.RegistrationDao;
import com.techjava.registration.model.Registration;
import com.techjava.registration.services.RegistrationService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RegistrationServiceTest {

    @MockBean
    private RegistrationDao ticketBookingJpaDao;

    @Autowired
    private RegistrationService ticketBookingService;

    @Test
    public void testCreateUserData(){
    	 Registration data = new  Registration();
         data.setUserId("1");
         data.setPassword("ani");
         data.setEmailId("asdf@gmaill.com");
         data.setAge(20);
         data.setContactNo("89900");
        Mockito.when(ticketBookingJpaDao.save(data)).thenReturn(data);
        assertThat(ticketBookingService.createdata(data)).isEqualTo(data);
    }

   
   
  
}
