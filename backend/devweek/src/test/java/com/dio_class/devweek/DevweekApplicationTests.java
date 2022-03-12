package com.dio_class.devweek;

import com.dio_class.devweek.Controller.ControllerRegiao;
import com.dio_class.devweek.Entity.Regiao;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// Integration testing for Regiao
@SpringBootTest
@AutoConfigureMockMvc
class DevweekApplicationTests {
//    Defining URL
    private final String URL="/api/regiao";

    @Autowired
    MockMvc mockMvc;

//    Object mapping for JSON
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ControllerRegiao controller;

//    Testing methods
//    (1) Listing object

//    Part A - All objects
    @Test
    public void getControllerTest() throws Exception{
//        Simulating a request from server
        mockMvc.perform(get(URL))
                .andExpect(status().isOk()
                );
    }

//    Part B - Specific object
    @Test
    public void getByIdControllerTest() throws Exception{
//        Simulating a request from server
        mockMvc.perform(get(URL+"/1"))
                .andExpect(status().isOk()
                );
    }

//    (2) Add new object
    @Test
    public void addNewRegiaoTest() throws Exception{
        Long id = Long.valueOf(6);
        Regiao newRegiao = new Regiao(id,"Noroeste", 57L);

        mockMvc.perform(post(URL+"/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(newRegiao)))
                .andExpect(status().isOk());
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

//    (3) Delete an object
    @Test
    public void deleteByIdRedgiaoTest() throws Exception {
        //delete("/api/foo/{id}", "11")
        mockMvc.perform(delete(URL+"/delete/{id}","6")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

}
