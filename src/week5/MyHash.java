package week5;

import java.util.ArrayList;

/*
Class to act as the Tutor_Session_1.MyHash object with add, contains and print methods
 */
public class MyHash<T> {
    // number of buckets for the placement of items in the buckets
    final int NBUCKETS = 1000;
    // buckets arraylist with NBUCKETS elements allotted
    ArrayList<T>[] buckets = new ArrayList[NBUCKETS];

    /*
    Initialization method:
    Job - make an arraylist ("bucket") in each element of buckets
     */
    public MyHash() {
        for (int i = 0; i < NBUCKETS; i++) {
            buckets[i] = new ArrayList<>();
        }
    }

    /*
    GOAL: adds T item (T means generic item, the type does not matter) to a bucket
    How:
    1. figure out the bucket number by getting the UNIQUE hashcode and modding by NBuckets
    2. add item into the bucket with element number bucketID in buckets
     */
    public void add(T item) {
        //Bucket ID  - figures out bucket ID based on hashcode
        int bucketID = Math.abs(item.hashCode()) % NBUCKETS;
        //adds bucket to the correct bucket with ID bucketID
        buckets[bucketID].add(item);
    }

    /*
    Goal: return if the bucket has item T
    How:
    1. get the bucketID using UNIQUE hashcode of the item and modding by NBUCKETS
    2. checking if the item is in the arraylist with the element of bucketID in buckets
     */
    public boolean contains(T item) {
        //Bucket ID  - figures out bucket ID based on hashcode
        int bucketID = Math.abs(item.hashCode()) % NBUCKETS;
        //checks if item is in the bucket at element bucketID in buckets
        return buckets[bucketID].contains(item);
    }

    /*
    GOAL: print length of the buckets for 10 first buckets to see briefly how many elements are in buckets
    How:
    1.  cycle through and print length of the bucket sizes
     */
    public void print(){
        for (int x = 0; x<10; x++) {
            System.out.println("Len of Bucket " + x + " " + buckets[x].size());
        }
    }
}