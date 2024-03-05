package Tutor_Session_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Exercise5 {
    public static void main(String[] args) {
        // Read guest list
        ArrayList<String> guestList = readLines("src/guestlist.txt");

        // Check size of the guest list to ensure correct loading
        System.out.println("Guest List Size: " + guestList.size());

        // Read visitors list
        ArrayList<String> visitors = readLines("src/visitors.txt");

        // Brute force search method (SLOW)
        long startTime = System.nanoTime(); //timer start
        int gateCrashersCount = 0; //# of crashers found
        for (String visitor : visitors) { // cycle through visitors
            if (!guestList.contains(visitor)) { // if guest list does not contain visitor THEN:
                gateCrashersCount++; // YOU HAVE FOUND GATE CRASHER ... so add 1 to counter
            }
        }
        long endTime = System.nanoTime(); //ends timer for the simulation
        long durationInMicroseconds = (endTime - startTime) / 1000; //time is in microseconds to show differences easier

        //print to show in console the differences
        System.out.println("Gate Crashers: " + gateCrashersCount);
        System.out.println("Search Time (ArrayList): " + durationInMicroseconds + " us");
        System.out.println("-----------------------------------------------------------");

        // Tutor_Session_1.MyHash search
        MyHash<String> guestListHash = new MyHash<>(); // Make hashmap object
        for (String guest : guestList) { // cycle through guestlist
            guestListHash.add(guest); // add each guest to the hashmap (Check ADD() METHOD in Hash class)
        }
        guestListHash.print();



        startTime = System.nanoTime();// start timer
        gateCrashersCount = 0; // counter for gate crashers
        for (String visitor : visitors) { // cycle through visitors
            if (!guestListHash.contains(visitor)) { // if visitor is NOT in guestlist THEN
                //System.out.println("Visitor - " + visitor + " " + visitor.hashCode());
                gateCrashersCount++; // add 1 to the counter
            }
        }
        endTime = System.nanoTime(); // end timer for simulation
        durationInMicroseconds = (endTime - startTime) / 1000;

        System.out.println("Gate Crashers (Tutor_Session_1.MyHash): " + gateCrashersCount);
        System.out.println("Search Time (Tutor_Session_1.MyHash): " + durationInMicroseconds + " us");
    }

    public static ArrayList<String> readLines(String filename) {
        ArrayList<String> words = new ArrayList<>(); // words list
        try {
            Scanner fin = new Scanner(new File(filename)); // initialize scanner
            while (fin.hasNext()) { // while scanner can still scan a new line in the file
                String w = fin.nextLine().toLowerCase(); // w is the current line in lower case
                words.add(w); // add the line (1 name) to the array of names
            }
            fin.close(); // close the scanner because finished scanning
        } catch (FileNotFoundException e) {
            System.out.println("Exception caught: " + e.getMessage()); // error issue
        }
        return words; // return list of names
    }

}

