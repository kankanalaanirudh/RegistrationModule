package com.techjava.ticketbooking.test;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.techjava.registration.dao.RegistrationDao;
import com.techjava.registration.model.Registration;

@RunWith(SpringRunner.class)
@DataJpaTest
public class RegistraionDaoTest {

    @Autowired
    private RegistrationDao registrationDao;

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    public void testNewTicket() throws Exception{
    	Registration data = getdata();
        Registration saveInDb = testEntityManager.persist(data);
       assertNotNull(saveInDb);
    } 
    private Registration getdata() {
    	Registration ticket = new Registration();
        ticket.setUserId("1");
        ticket.setPassword("ani");
        ticket.setEmailId("asdf@gmaill.com");
        ticket.setAge(20);
        ticket.setContactNo("89900");
        return ticket;
    }
}
