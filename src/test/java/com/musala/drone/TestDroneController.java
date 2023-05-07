//package com.musala.drone;
//
//import com.musala.drone.controller.DroneController;
//import org.junit.Test;
//import org.junit.jupiter.api.Disabled;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//
//@RunWith(SpringRunner.class)
//@WebMvcTest(DroneController.class)
//public class TestDroneController {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Test
//    public void getAllDrones() throws Exception{
//        mockMvc.perform(MockMvcRequestBuilders
//                .get("/drone").accept(MediaType.APPLICATION_JSON))
//                .andDo(print())
//                .andExpect(status().isOk());
//    }
//}
