package com.td.interview.excercise.quadraticequation.service;

import com.td.interview.excercise.quadraticequation.entity.QuadraticEquationRequest;
import com.td.interview.excercise.quadraticequation.entity.QuadraticEquationResponse;
import com.td.interview.excercise.quadraticequation.entity.ResultType;
import com.td.interview.excercise.quadraticequation.exception.InvalidRequestException;
import org.springframework.stereotype.Service;

@Service
public class QuadraticEquationProcessor {

    private CacheResults cacheResults = new CacheResults();

    public QuadraticEquationResponse solveEquation(QuadraticEquationRequest request) {
        try {

            //Fetch from cache if already computed
            String key = request.getA() + ":" + request.getB() + ":" + request.getC();
            if (cacheResults.get(key) != null) {
                return cacheResults.get(key);
            }

            QuadraticEquationResponse response = new QuadraticEquationResponse();
            double discriminant = request.getB() * request.getB() - 4.0 * request.getA() * request.getC();
            if (discriminant > 0.0) { // real and distinct roots
                double root1 = (-request.getB() + Math.pow(discriminant, 0.5)) / (2.0 * request.getA());
                double root2 = (-request.getB() - Math.pow(discriminant, 0.5)) / (2.0 * request.getA());
                response.setRoot1(root1);
                response.setRoot2(root2);
                response.setType(ResultType.REAL_AND_DISTINCT);
            } else if (discriminant < 0.0) {  // roots are complex number and distinct
                double root1 = (-request.getB()) / (2.0 * request.getA());
                double root2 = (Math.pow(-discriminant, 0.5)) / (2.0 * request.getA());
                response.setRoot1(root1);
                response.setRoot2(root2);
                response.setType(ResultType.COMPLEX_AND_DISTINCT);
            } else if (discriminant == 0.0) {  //real and equal roots
                double root1 = -request.getB() / (2.0 * request.getA());
                response.setRoot1(root1);
                response.setRoot2(root1);
                response.setType(ResultType.REAL_AND_EQUAL);
            }
            //Add response to Cache
            cacheResults.put(key, response);
            return response;
        } catch (Exception exception) {
            throw new InvalidRequestException("Invalid request " + request);
        }
    }

    public void validateRequest(QuadraticEquationRequest request) {
        if (request.getA() == 0) {
            throw new InvalidRequestException("Invalid request. Input value of a should not be Zero! " + request);
        }
//        if (request.getA() == Integer.MAX_VALUE || request.getB() == Integer.MAX_VALUE || request.getC() == Integer.MAX_VALUE) {
//            throw new InvalidRequestException("Invalid Request.Limit breach!" + request);
//        }
//
//        if (request.getA() == Integer.MIN_VALUE || request.getB() == Integer.MIN_VALUE || request.getC() == Integer.MIN_VALUE) {
//            throw new InvalidRequestException("Invalid Request. Limit breach! " + request);
//        }
    }

}
