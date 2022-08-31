package com.td.interview.excercise.quadraticequation.controller;

import com.google.gson.Gson;
import com.td.interview.excercise.quadraticequation.entity.QuadraticEquationRequest;
import com.td.interview.excercise.quadraticequation.entity.QuadraticEquationResponse;
import com.td.interview.excercise.quadraticequation.service.QuadraticEquationProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/td/quadratic/v1")
public class QuadraticEquationController {

    @Autowired
    private QuadraticEquationProcessor processor;
    private Gson gson = new Gson();

    @PostMapping("/solveqe")
    public ResponseEntity<String> solveQuadraticEquation(@RequestBody QuadraticEquationRequest quadraticEquationRequest){
        processor.validateRequest(quadraticEquationRequest);
        QuadraticEquationResponse result = processor.solveEquation(quadraticEquationRequest);
        return ResponseEntity.ok().body(gson.toJson(result));
    }

}
