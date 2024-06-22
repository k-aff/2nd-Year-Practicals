/*  
    Outcomes for practical 1 
    • Implementing a dynamically sized array using recursion.
    • Writing basic array operations using recursion.
    • Writing a sorting algorithm using recursion.
*/

/*
   RecursiveArray class that implements a dynamically sized array using recursion.
   Provides basic array operations and sorting algorithms using recursion.
*/

public class RecursiveArray {

    // Array of integers to serve as the data for this object
    public Integer[] array;

    // Default constructor to create an empty array
    public RecursiveArray() {
        array = new Integer[] {};
    }

    // Constructor that turns an input string into an array
    public RecursiveArray(String input) {

        if (input.equals(""))
            array = new Integer[] {};

        else {
            String[] nums = input.split(",");
            array = new Integer[nums.length];
            helperConstructor(nums, 0);
        }
    }

    // Returns a string representation of the array
    @Override
    public String toString() {
        if (array.length == 0) {
            return "Empty Array";
        } else {

            String toRet = "[";
            return helperToString(0, toRet);
        }
    }

    // Appends value to array
    public void append(Integer value) {

        Integer newArray[] = new Integer[array.length + 1];

        array = helperAppend(newArray, 0, value);

    }

    // Prepends value to array
    public void prepend(Integer value) {

        Integer newArray[] = new Integer[array.length + 1];

        array = helperPrepend(newArray, 0, value);
    }

    // Checks if the value is contained in the array
    public boolean contains(Integer value) {
        return (helperContains(0, value));
    }

    // Checks if array is in ascending order
    public boolean isAscending() {
        return helperIsAscending(0);
    }

    // Checks if array is in descending order
    public boolean isDescending() {
        return helperIsDescending(0);
    }

    // Sorts array in ascending order
    public void sortAscending() {
        helperSortAscending(array.length - 1, array.length - 1);
    }

    // Sorts array in descending order
    public void sortDescending() {
        helperSortDescending(array.length - 1, array.length - 1);
    }

    // Helper functions

    public void helperConstructor(String[] arr1, int ind) {
        if (ind >= arr1.length) {
            return;
        } else {
            array[ind] = Integer.parseInt(arr1[ind]);
            helperConstructor(arr1, ind + 1);
        }
    }

    public String helperToString(int ind, String str) {

        if (ind < array.length - 1) {
            str += (Integer.toString(array[ind]) + ",");
            return helperToString(ind + 1, str);

        } else {
            str += (Integer.toString(array[array.length - 1]) + "]");
            return str;
        }
    }

    public Integer[] helperPrepend(Integer[] arr, int ind, Integer val) {

        if (ind == 0) {
            arr[0] = val;
            helperPrepend(arr, ind + 1, val);
        } else if (ind < arr.length) {
            arr[ind] = array[ind - 1];
            helperPrepend(arr, ind + 1, val);
        }

        return arr;
    }

    public Integer[] helperAppend(Integer[] arr, int ind, Integer val) {

        if (ind < array.length) {
            arr[ind] = array[ind];
            helperAppend(arr, ind + 1, val);
        } else {
            arr[ind] = val;
        }

        return arr;
    }

    public boolean helperContains(int ind, Integer val) {

        if (ind >= array.length) {
            return false;

        } else if (array[ind] == val) {

            return true;

        } else {

            return helperContains(ind + 1, val);
        }

    }

    public boolean helperIsAscending(int ind) {

        if (array.length == 0) {
            return true;

        } else if (ind >= array.length - 1) {

            return true;

        } else if (array[ind] > array[ind + 1]) {

            return false;
        } else {

            return helperIsAscending(ind + 1);
        }

    }

    public boolean helperIsDescending(int ind) {
        if (array.length == 0) {
            return true;

        } else if (ind >= array.length - 1) {

            return true;
        } else if (array[ind] < array[ind + 1]) {

            return false;
        }

        else {

            return helperIsDescending(ind + 1);

        }

    }

    public void helperSortDescending(int i, int j) {

        if (i > 0) {
            if (array[i - 1] < array[j]) {
                swap(j, i - 1);
                helperSortDescending(i - 1, j);
            } else {
                helperSortDescending(i - 1, j);
            }
            helperSortDescending(i - 1, j - 1);
        }
    }

    public void helperSortAscending(int i, int j) {

        if (i > 0) {
            if (array[i - 1] > array[j]) {
                swap(j, i - 1);
                helperSortAscending(i - 1, j);
            } else {
                helperSortAscending(i - 1, j);
            }
            helperSortAscending(i - 1, j - 1);
        }
    }

    public void swap(int pos1, int pos2) {
        Integer temp = array[pos1];
        array[pos1] = array[pos2];
        array[pos2] = temp;
    }

}
