package TestingAssigment;

import static TestingAssigment.DistanceCalculator.compute;

public class Main {
    public static void main(String[] args) {
        String expression = "10 cm + 1 m - 10 mm";
        int result = compute(expression);
        System.out.println(expression + " = " + result + " mm");
    }
    }

