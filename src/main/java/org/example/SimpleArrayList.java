package org.example;

public class SimpleArrayList <T> {
    int maxSize = 8; // Default array size
    int[] elements;
    int topElement = 0;

    // Constructor for empty array
    SimpleArrayList() {
        this.elements = new int[maxSize];
    }
    // Constructor for already made array
    SimpleArrayList(int[] array)  {
        this.elements = array;
        this.maxSize = array.length;
        this.topElement = array.length;

    }
    // Constructor for n elements
    SimpleArrayList(int newSize) {
        this.elements = new int[newSize];
        this.maxSize = newSize;
    }


    // Increase array size to avoid overflow
    private void extendArray() {
        this.maxSize *= 2;
        int[] biggerArray = new int[this.maxSize];
        for (int i = 0; i < this.elements.length; i++) {
            biggerArray[i] = this.elements[i];
        }

        this.elements = biggerArray;
    }

    // Check if index is valid, throws error if not
    private void checkIndex(int index) {
        if (index > this.topElement - 1 || index < 0) {
            throw new IllegalArgumentException("Select existing index");
        }
    }

    // Shift elements of the array to add or remove element in the middle
    private void shiftArray(int shiftFrom, boolean forward) {
        // If adding
        if (forward) {
            for (int i = topElement; i > shiftFrom - 1; i--) {
                this.elements[i + 1] = this.elements[i];
            }
        }
        // If removing
        else {
            for (int i = shiftFrom; i < topElement + 1; i++) {
                this.elements[i] = this.elements[i + 1];
            }
        }
    }

    // Append element in the end
    public void add(int element) {
        if (this.topElement + 1 >= this.maxSize) {
            extendArray();
        }
        this.elements[this.topElement] = element;

        this.topElement += 1;
    }

    // Add element in any index
    public void add (int element, int index) {
        if (index >= this.topElement) {
            this.add(element);
            return;
        }
        this.checkIndex(index);
        // TODO maybe make private?
        if (this.topElement + 1 >= this.maxSize) {
            extendArray();
        }
        shiftArray(index, true);
        this.elements[index] = element;
        this.topElement += 1;
    }

    // Add all elements from other array
    public void addAll(int[] arrayToAdd) {
        for (int i = 0; i < arrayToAdd.length; i++) {
            this.add(arrayToAdd[i]);
        }
    }

    public void addAll(SimpleArrayList simpleArrayList) {
        int[] arrayToAdd = simpleArrayList.getElements();
        addAll(arrayToAdd);
    }

    // Delete last element and return it
    public int pop() {
        int temp = this.elements[this.topElement];
        this.topElement -= 1;
        return temp;
    }

    public int remove(int index) {
        this.checkIndex(index);
        int temp = this.elements[index];

        shiftArray(index, false);
        this.topElement -= 1;
        return temp;

    }

    // Prints every element
    public void printElements() {
        for (int i = 0; i < this.maxSize; i++) {
            System.out.print(this.elements[i]);
            if (i >= this.topElement) {
                System.out.print(" < hidden");
            }
            System.out.println();
        }
    }


    // Getters
    public int[] getElements() {
        int[] realArray = new int[this.topElement];
        for (int i = 0; i < topElement; i++) {
            realArray[i] = this.elements[i];
        }

        return realArray;
    }

    // Get element by index
    public int get(int index) {
        this.checkIndex(index);
        return this.elements[index];
    }

}
