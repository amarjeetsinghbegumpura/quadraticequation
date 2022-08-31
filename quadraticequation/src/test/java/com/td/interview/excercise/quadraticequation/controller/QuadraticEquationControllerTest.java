package com.td.interview.excercise.quadraticequation.controller;

import com.google.gson.Gson;
import com.td.interview.excercise.quadraticequation.entity.QuadraticEquationRequest;
import com.td.interview.excercise.quadraticequation.entity.QuadraticEquationResponse;
import com.td.interview.excercise.quadraticequation.entity.ResultType;
import com.td.interview.excercise.quadraticequation.exception.QuadraticEquationException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
@AutoConfigureMockMvc
public class QuadraticEquationControllerTest {

    @Autowired
    private MockMvc mockMvc;
    private Gson gson = new Gson();

    @Test
    public void testSolveQuadraticEquation() throws Exception {

        QuadraticEquationRequest request = new QuadraticEquationRequest(1, 2, 3);
        String jsonRequest = gson.toJson(request);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/td/quadratic/v1/solveqe")
                .accept(MediaType.APPLICATION_JSON)
                .content(jsonRequest)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        QuadraticEquationResponse responseObj = gson.fromJson(response.getContentAsString(), QuadraticEquationResponse.class);
        assertEquals(-1.0, responseObj.getRoot1());
        assertEquals(1.4142135623730951, responseObj.getRoot2());
        assertEquals(ResultType.COMPLEX_AND_DISTINCT, responseObj.getType());
    }

    @Test
    public void testSolveQuadraticEquationWithInvalidInput() throws Exception {

        QuadraticEquationRequest request = new QuadraticEquationRequest(0, 2, 3);
        String jsonRequest = gson.toJson(request);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/td/quadratic/v1/solveqe")
                .accept(MediaType.APPLICATION_JSON)
                .content(jsonRequest)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();


        MockHttpServletResponse response = result.getResponse();
        assertEquals(HttpStatus.BAD_REQUEST.value(), response.getStatus());
        assertTrue(response.getContentAsString().contains("Invalid request. Input value of a should not be Zero!"));

    }
}
