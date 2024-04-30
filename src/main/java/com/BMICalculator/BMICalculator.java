package com.BMICalculator;
import java.util.*;

public class BMICalculator {
    private float weight;
    private float height;
    Vector<String> report;

    public BMICalculator() {
        report = new Vector<String>();
        report.add("Seriously underweight");
        report.add("Underweight");
        report.add("Normal weight");
        report.add("Overweight");
        report.add("Obese");
        weight = 0;
        height = 0;
    }

    public float getWeight(){
        return weight;
    }

    public float getHeight(){
        return height;
    }

    public void setWeight(float weight){
        this.weight = weight;

    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getBMIIndex() {
        float BMI =  weight/ (height * height);
        return BMI;
    }

    public String getMessage(float bmi){
        if (bmi < 18) {
            return report.get(0) + " for BMI value below 18.0";
        } else if (bmi < 18.5) {
            return report.get(1) + " for BMI value less than 18.5";
        } else if (bmi < 24.9) {
            return report.get(2) + " for BMI values between 18.5 – 24.9";
        } else if (bmi < 29.9) {
            return report.get(3) + " for BMI values between 25 – 29.9";
        } else {
            return report.get(4) + " for BMI values between 30-39.9";
        }
    }

}
