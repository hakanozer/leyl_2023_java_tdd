package com.example;

import com.example.models.User;
import com.example.restcontrollers.UserRestControllers;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = {UserRestControllers.class})
public class UserServiceTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void userRegisterTest() throws Exception {
        User u = new User();
        u.setEmail("ahmet@mail.com");
        u.setPassword("12345");
        String stObj = objectMapper.writeValueAsString(u);

        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.post("/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(stObj)
        ).andReturn();
        String content = mvcResult.getRequest().getContentAsString();
        User objUser = objectMapper.readValue(content, User.class);
        System.out.println(objUser);
        Assertions.assertTrue( objUser.getEmail().equals("ahmet@mail.com"), "Service Email Fail" );
    }

    @Test
    void userGetTest() throws Exception {
        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.get("/users/1")
                        .contentType(MediaType.APPLICATION_JSON)
        ).andReturn();
        String content = mvcResult.getRequest().getContentAsString();
        Assertions.assertTrue( mvcResult.getResponse().getStatus() == 200 );
        System.out.println( content );
    }

}
