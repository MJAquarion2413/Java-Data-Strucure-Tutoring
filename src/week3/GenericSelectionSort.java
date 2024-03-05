package week3;

import java.util.Arrays;
import java.util.Locale;

public class GenericSelectionSort {
    public static<T> void selectionSort(T[] array, MyCompare<T> c) {
        int startScan; // Starting position of the scan
        int index; // To hold a subscript value
        int minIndex; // Element with smallest value in the scan
        T minValue; // The smallest value found in the scan
        // The outer loop iterates once for each element in the
        // array. The startScan variable marks the position where
        // the scan should begin.
        for (startScan = 0; startScan < (array.length - 1); startScan++) {
            // Assume the first element in the scannable area
            // is the smallest value.
            minIndex = startScan;
            minValue = array[startScan];
            // Scan the array, starting at the 2nd element in
            // the scannable area. Find
            // smallest value in the scannable area.
            for (index = startScan + 1; index < array.length; index++) {
                if (c.compare(array[index], array[minIndex])) {
                    //if (array[index] < array[minIndex]) { // (A) *** Comparison
                    minIndex = index;
                    //}
                }
            }
            // Swap the element with the smallest value
            // with the first element in the scannable area.
            swap(array,startScan,minIndex);
        }
    }

    private static<T> void swap(T[] array, int a, int b) {
        T temp;
        temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
    /**
     * Interface that defines a Comparison method that
     * can be implemented as a Lambda expression
     */
    interface MyCompare<T> {
        public boolean compare(T s1, T s2);
    }

    public static void main(String[] args) {
        Integer[] A = new Integer[] {10,43,5,47,62,11,41,55};
        Integer[] B;
        System.out.println("SELECTION SORT");
        B = Arrays.copyOf(A, A.length);
        System.out.println("Before Sort : " + Arrays.toString(B));
        //selectionSort (B); // (B) method call
        //MyCompare c = (int s1, int s2) -> {return s1 < s2;};
        //selectionSort(B,c);
        MyCompare<Integer> c = (Integer s1, Integer s2) -> { return s1 < s2; };
        selectionSort(B,c); // More common to see this form
        System.out.println("After Sort : " + Arrays.toString(B));

        selectionSort(B,(s1,s2) -> s1 > s2); // More common to see this form
        System.out.println("After Sort : " + Arrays.toString(B));

        String[] w = new String[]{"This", "is", "a", "sample", "sentence", "to", "sort"};
        MyCompare<String> cS = (String s1, String s2) ->
        {return (s1.toLowerCase()).compareTo(
                s2.toLowerCase()
        ) < 0;};
        selectionSort( w, cS );
        System.out.println("After Sort : " + Arrays.toString(w));
        selectionSort( w, (String s1, String s2) -> s1.length()>s2.length());
        System.out.println("After Sort : " + Arrays.toString(w));
        selectionSort( w, (String s1, String s2) -> s1.length()<s2.length());
        System.out.println("After Sort : " + Arrays.toString(w));

    }

}
