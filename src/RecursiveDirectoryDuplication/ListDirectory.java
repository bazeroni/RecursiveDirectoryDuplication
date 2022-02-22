// RecursiveDirectoryDuplication.java
// program for recursively creating, listing, and copying a directory from source to destination for CSCI 112
// last edited Feb. 20, 2022 by S. Gutierrez

package RecursiveDirectoryDuplication;

// imports libraries for reading/writing data and i/o console interaction
import java.io.*;
import java.util.Scanner;

// holds method to list the content of directory
public class ListDirectory {

    // tests, reads, and prints contents of directory with specified path argument
    // returns the contents of the directory in the form of an array of File type
    public File[] listDir(String path) {

        // creates file object with specified path as argument
        File target = new File(path);

        // creates array to store files and directory entries
        File[] entries;

        // tests validity of file object as a valid path at target
        if (target.exists()) {

            // tests validity of file object target as a valid directory
            if (target.isDirectory()) {

                // loads data from target directory into an array
                entries = target.listFiles();

                // echos target and shows absolute path
                System.out.print("\n");
                System.out.println(path + " exists and is a valid directory.");
                System.out.print("\n");

                // loops through file object array and prints entries within
                for (File entry : entries) {

                    // prints the file or directory name
                    System.out.printf("%-64S", entry.getName());

                    // prints formatted file size or directory label
                    if (entry.isFile()) {

                        // prints size of the file in bytes
                        System.out.printf("%,d \n", entry.length());

                    } else {

                        // prints directory label
                        System.out.println("<DIR>");

                    } // ends if and else statements

                } // ends for loop

                // returns entries array with content of directory
                return entries;

            } // ends if statement

            // tests validity of file object target as a valid file
            else if (target.isFile()) {

                // creates a new array with a size of one for the file
                entries = new File[1];
                entries[0] = target;

                // designates the target as a file with its path
                System.out.print("File at: ");
                System.out.print(target.getAbsolutePath());

                // returns entries array with file contained in array
                return entries;

            } // ends else if statement

            // assumes target does not exist if it does not pass previous two tests
            else {

                // notifies user that the target File does not exist
                System.out.println(target + " - does not exist.");

            } // ends else

        } // ends if statement

        // returns an empty array
        entries = new File[1];
        return entries;

    } // end listDir() method

} // end ListDirectory class
