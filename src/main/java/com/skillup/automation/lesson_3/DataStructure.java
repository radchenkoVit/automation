package com.skillup.automation.lesson_3;

import com.skillup.automation.Calculator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class DataStructure {

    public static void main(String[] args) {
        int[] array = {1, 2, 3};
        int[] array2 = new int[3];//0, 1, 2 => 3 elements


        System.out.println(array[1]);

//        //it's okay
//        for (int i = 0; i < array.length; i++) {
//            System.out.println(array[i]);
//        }
//
//        //advanced way
//        for (int asInt : array) {
//            System.out.println(asInt);
//        }


        System.out.println("______________________________________");

        List<String> stringList = new ArrayList<String>();
        List<String> linkedList = new LinkedList<String>();

        Set<String> set = new HashSet<String>();
        set.add("1");
        set.add("2");
        set.add("1");

        Set<String> set2 = new LinkedHashSet<String>();

        stringList.add("1");
        stringList.add("2");
        stringList.add("3");
        stringList.add("1");

//        for (int i = 0; i < stringList.size(); i++) {
//            System.out.println(stringList.get(i));
//        }

        for (String s : stringList) {
            System.out.println(s);
        }
    }

    public static void doSmth(List<String> list) {

    }
}
