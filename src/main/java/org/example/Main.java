package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        SimpleArrayList array = new SimpleArrayList(3);
        System.out.println("Hello");
        array.add(1);
        array.add(2);

        array.printElements();
//        System.out.println(Arrays.toString(array.getElements()));

    }
}