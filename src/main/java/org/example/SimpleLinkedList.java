package org.example;

import java.util.LinkedList;

public class SimpleLinkedList<T>  {
    class LinkedNode {
        public LinkedNode nextNode = null;
        public LinkedNode prevNode = null;
        public T data;

        public LinkedNode(LinkedNode nextNode, LinkedNode prevNode, T data) {
            this.nextNode = nextNode;
            this.prevNode = prevNode;
            this.data = data;
        }
    }


    public LinkedNode rootNode = new LinkedNode(null, null, null);
    public int size;

    public SimpleLinkedList() {
        this.size = 0;
    }

    public SimpleLinkedList(T data) {
        this.rootNode.nextNode = new LinkedNode(null, this.rootNode, data);
        this.size = 1;
    }

    public SimpleLinkedList(T[] t) {
        for (int i = 0; i < t.length; i++) {
            this.add(t[i]);
        }
    }

    public T get(int index) {
        if (index > size || index < 0) {
            return null;
        }

        int currIndex = 0;

        LinkedNode temp = rootNode.nextNode;
        while (currIndex < index) {
            temp = temp.nextNode;
            currIndex += 1;
        }

        return temp.data;

    }

    public void add(T data) {
        LinkedNode temp = rootNode;
        while (temp.nextNode != null)
            temp = temp.nextNode;

        temp.nextNode = new LinkedNode(null, temp, data);
        size += 1;
    }

    public void add(T data, int index) {
        if (index >= size) {
            this.add(data);
            return;
        }
        int currIndex = 0;

        LinkedNode temp = rootNode;
        while (currIndex < index) {
            temp = temp.nextNode;
            currIndex += 1;
        }
        LinkedNode nextTemp = temp.nextNode;
        LinkedNode newNode = new LinkedNode(nextTemp, temp, data);
        nextTemp.prevNode = newNode;
        temp.nextNode = newNode;
    }

    public void remove(int index) {
        if (index > size || index < 0) {
            return;
        }

        int currIndex = 0;

        LinkedNode temp = rootNode;
        while (currIndex < index) {
            temp = temp.nextNode;
            currIndex += 1;
        }

        LinkedNode prevNode;
        try {
            prevNode = temp.prevNode;
        } catch (NullPointerException ingored) {
            prevNode = null;
        }

        LinkedNode nextTemp;
        try {
            nextTemp= temp.prevNode;
        } catch (NullPointerException ignored) {
            nextTemp = null;
        }

        prevNode.nextNode= nextTemp;
        nextTemp.prevNode = prevNode;

    }

    // Add all elements from other array
    public void addAll(T[] arrayToAdd) {
        for (int i = 0; i < arrayToAdd.length; i++) {
            this.add(arrayToAdd[i]);
        }
    }

    public void addAll(SimpleLinkedList<T> simpleLinkedList) {
        LinkedNode temp = simpleLinkedList.rootNode;

        while (temp.nextNode != null) {
            add(temp.data);
        }
    }


    public void printList() {
        LinkedNode temp = rootNode.nextNode;
        while (temp.nextNode != null) {
            System.out.println(temp.data);
            temp = temp.nextNode;
        }
        System.out.println(temp.data);
    }

}
