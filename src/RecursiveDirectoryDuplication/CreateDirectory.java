// RecursiveDirectoryDuplication.java
// program for recursively creating, listing, and copying a directory from source to destination for CSCI 112
// last edited Feb. 20, 2022 by S. Gutierrez

package RecursiveDirectoryDuplication;

// imports libraries for reading/writing data and i/o console interaction
import java.io.*;
import java.util.Scanner;

// creates directory
public class CreateDirectory {

    // creates directory at the designated destination path
    // takes in a destination path
    public void createDir(String pathDestination) {

        // creates a new File type at the destination type to hold the new directory
        File newDir = new File(pathDestination);

        // evokes mkdir() method on the File object instance to create a directory
        newDir.mkdir();

    } // ends createDir() method

} // ends CreateDirectory class
