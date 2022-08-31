package com.td.interview.excercise.quadraticequation.service;

import com.td.interview.excercise.quadraticequation.entity.QuadraticEquationResponse;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CacheResults {

    private Map<String, QuadraticEquationResponse> responseMap = new ConcurrentHashMap<>();

    public void put(String key, QuadraticEquationResponse response){
        responseMap.putIfAbsent(key,response);
    }
    public QuadraticEquationResponse get(String key){
        return responseMap.get(key);
    }

}
