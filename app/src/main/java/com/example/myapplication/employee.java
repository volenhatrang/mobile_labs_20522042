package com.example.myapplication;

public class employee {
    private String fullName;
    private double gross;
    employee(){}
    employee(String name, double gross){
        this.fullName = name;
        this.gross = gross;
    }

    public String getFullName(){
        return this.fullName;
    }

    public void setFullName(String name){
        this.fullName = name;
    }

    public double getGross(){
        return this.gross;
    }

    public void setGross(double gr){
        this.gross = gr;

    }
    public double calculateNet(){
        double a = gross - gross*0.105;
        if(a <= 11000000){
            return a;
        }
        else{
            double tax = (a - 11000000)*0.05;
            return (a-tax);
        }
    }
}
