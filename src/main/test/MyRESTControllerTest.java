package com.example.rest;

import com.example.rest.controller.MyRESTController;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = MyRESTController.class)
public class MyRESTControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void showAllEmployeesTest() throws Exception {
        ResultActions resultActions= mockMvc.perform(get("/api/employees"))
                .andExpect(status().isOk());
    }

    @Test
    public void getEmployeeTest() throws Exception{
        //       new Employee("Oleg","Ivanov","Sales",700);
        ResultActions resultActions= mockMvc.perform(get("/api/employees/{id}",1))
                //  .andExpect( content().json("{'data':[{'id':'1','name':'Oleg','surname':'Ivanov','department':'Sales','Salary':'700'}]}"))
                .andExpect(status().isOk());
    }
    @Test
    public void addNewEmployeeTest() throws Exception{

    }

    @Test
    public void deleteEmployee() throws Exception{

    }
}
