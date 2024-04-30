package  com.BMICalculator;

import java.util.Scanner;


public class IndividualHealthAssessment {

    public static void main (String[] args){
        BMICalculator bmiCalculator = new BMICalculator();

        //weight in kg and height in meters
        System.out.print("Please enter your weight in kg:  ");
        Scanner s = new Scanner(System.in);
        float weight = s.nextFloat();
        bmiCalculator.setWeight(weight);

        System.out.print("Please enter your height in meters: ");
        float height = s.nextFloat();
        bmiCalculator.setHeight(height);

        float bmi = bmiCalculator.getBMIIndex();

        System.out.println("BMI index is " + bmi);
        System.out.println(bmiCalculator.getMessage(bmi));
        System.out.println();
    }
}

// cd /Users/ankurpandey/IdeaProjects/hellofx/src
// javac hellofx/BMICalculator/IndividualHealthAssessment.java hellofx/BMICalculator/BMICalculator.java
// java  hellofx/BMICalculator/IndividualHealthAssessment
