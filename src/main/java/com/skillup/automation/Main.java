package com.skillup.automation;

public class Main {

    public static void main(String[] args) {
        Object o = "asd";// all classes comes from Object. Type is Object, value is String
        String str = ""; // array of chars

        //PRIMITIVE
        char ch = 'a';// symbol
        int asInt = 1;
        long asLong = 123;
        float asFloat = 123.23F;
        short asShort = 2;
        boolean asBoolean = true;
        boolean secondBoolean = Boolean.FALSE;
        byte asByte = 1;
        double asDouble = 123.123D;

        //LINK DATA TYPE
        String str2 = ""; //correct way of String creation!
        String str3 = new String("aasd"); // wrong way
        Cat catNika = new Cat("Nika", true);
        Car car = new Car("bmw", "orange");

        System.out.println(asLong);
        System.out.println(asShort);
        System.out.println(car);
    }
}