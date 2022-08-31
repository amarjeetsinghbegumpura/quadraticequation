package com.td.interview.excercise.quadraticequation.entity;

public class QuadraticEquationResponse {
    private double root1;
    private double root2;
    private ResultType type;

    public ResultType getType() {
        return type;
    }

    public void setType(ResultType type) {
        this.type = type;
    }

    public QuadraticEquationResponse() {
    }

    public double getRoot1() {
        return root1;
    }

    public double getRoot2() {
        return root2;
    }


    public void setRoot1(double root1) {
        this.root1 = root1;
    }

    public void setRoot2(double root2) {
        this.root2 = root2;
    }

    public QuadraticEquationResponse(double root1, double root2, ResultType type) {
        this.root1 = root1;
        this.root2 = root2;
        this.type = type;
    }
}
