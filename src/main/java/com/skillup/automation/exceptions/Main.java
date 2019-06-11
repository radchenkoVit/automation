package com.skillup.automation.exceptions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));


    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to calc program v.1.0.0");

        while (true) {
            int x = readInteger();
            int y = readInteger();

            System.out.println(String.format("%s + %s = %s", x, y, x + y));

            System.out.println("Continue? Yes/no");
            String answer = bufferedReader.readLine();

            if ("no".equalsIgnoreCase(answer)) {
                break;
            }
        }

        System.out.println("Thank you. All rights reserved.");
    }


    public static int readInteger() throws IOException {
        System.out.print("Enter number: ");

        int number;
        while (true) {
            String numberAsString = bufferedReader.readLine();
            try {
                number = Integer.valueOf(numberAsString);
                if (number < 0) {
                    throw new NegativeValueException();
                }

                break;
            } catch (NumberFormatException e) {
                System.out.print("Incorrect value. Please re-enter a number: ");
            } catch (NegativeValueException e) {
                System.out.print("Negative value. Please re-enter positive number: ");
            }
        }

        return number;
    }


    public static void throwUncheckedExceptionMethod() {
        System.out.println("Begin");

        try {
            System.out.println("Try begin");
            throw new SkillUpException("my runtime exception");
        } finally {
            System.out.println("Inside finally");
        }
    }

    public static void throwCheckedExceptionMethod() throws Exception {
        System.out.println("Begin");

        try {
            System.out.println("Try begin");
            throw new Exception("my exception");
        } finally {
            System.out.println("Inside finally");
        }
    }


    public static void catchExceptionExample() {
        System.out.println("Begin");//1
        Exception exception = new Exception("my exception");

        try {
            //TODO: code will be executed
            System.out.println("Try begin");//2

            throw exception;//3
//            System.out.println("Try end");
        } catch (Exception e) {
            System.out.println("Inside catch: " + e.getMessage());//4
            //TODO: code in this block will run in case of Exception
        } finally {
            System.out.println("Inside finally");//5
            //TODO: code in this block will be run anyway
        }

        System.out.println("After try-catch-finally block");//6
    }


}
