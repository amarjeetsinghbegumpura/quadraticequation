package com.td.interview.excercise.quadraticequation.entity;

public class QuadraticEquationRequest {

    private double a, b, c;

    public QuadraticEquationRequest(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    @Override
    public String toString() {
        return "QuadraticEquationRequest{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                '}';
    }
}
