package com.techjava.ticketbooking.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.techjava.registration.controller.RegistrationController;
import com.techjava.registration.model.Registration;
import com.techjava.registration.services.RegistrationService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = RegistrationController.class,secure = false)
public class RegistrationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RegistrationService Service;


    @Test
    public void testNewTicket() throws Exception{
        String URI = "/booking/createTicket";
        Registration ticket = new  Registration();
        ticket.setUserId("Vishnu");
        ticket.setPassword("Vishnu@22");
        ticket.setEmailId("asdf@gmaill.com");
        ticket.setAge(20);
        ticket.setContactNo("89900");
        String jsonInput = this.converttoJson(ticket);

        Mockito.when(Service.createdata(Mockito.any(Registration.class))).thenReturn(ticket);
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post(URI).accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
        String jsonOutput = mockHttpServletResponse.getContentAsString();
        assertThat(jsonInput).isEqualTo(jsonOutput);
       // Assert.assertEquals(HttpStatus.OK.value(), mockHttpServletResponse.getStatus());
    }

   



   
    /**
     * Convert Object into Json String by using Jackson ObjectMapper
     * @param ticket
     * @return
     * @throws JsonProcessingException
     */
    private String converttoJson(Object ticket) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(ticket);
    }

}
