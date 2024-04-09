package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        SimpleLinkedList<String> array = new SimpleLinkedList<>(new String[] {"aaa", "CD"});
//        array.add("1");
//        array.add("2");
//        array.add("3BBB");
//        array.printList();

        String[] a = new String[] {"Ab", "C", "111", "a"};
        bubbleSort(a);
        System.out.println(Arrays.toString(a));


    }

    public static <T extends Comparable<T>> void bubbleSort(T[] array) {
        while (!isSorted(array)) {
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i].compareTo(array[i + 1]) > 0) {
                    T temp = array[i + 1];
                    array[i + 1] = array[i];
                    array[i] = temp;
                }
            }
        }
    }

    private static <T extends Comparable<T>> boolean isSorted(T[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i].compareTo(array[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }

}