// RecursiveDirectoryDuplication.java
// program for recursively creating, listing, and copying a directory from source to destination for CSCI 112
// last edited Feb. 20, 2022 by S. Gutierrez

package RecursiveDirectoryDuplication;

// imports libraries for reading/writing data and i/o console interaction
import java.io.*;
import java.util.Scanner;

// interacts with user to designate source and destination paths to duplicate directory
// runs the initial level of reading, creating, and duplication of the directory
public class Main {

    public static void main(String[] args) throws Exception {

        // declare variables for source and destination
        String pathSource;
        String pathDestination;

        // creates instance objects for the initial directory level to call methods
        ListDirectory directoryShow = new ListDirectory();
        CreateDirectory directoryMake = new CreateDirectory();
        CopyDirectory directoryCopy = new CopyDirectory();

        // welcome message
        System.out.println("Welcome! Please specify the source and destination of the file or directory you would like to copy.");
        System.out.print("\n");

        // creates a new Scanner class object, associated with console input
        Scanner kb = new Scanner(System.in);

        // prompts user for input of email address and stores result
        System.out.print("Source Path: ");
        pathSource = kb.next();

        // prompts user for input of email address and stores result
        System.out.print("Destination Path: ");
        pathDestination = kb.next();

        // makes the new directory that the data should be contained in
        directoryMake.createDir(pathDestination);

        // lists the directory contents at the specified source path, stores the contents as File types in an array
        File[] entries = directoryShow.listDir(pathSource);

        // copies the entries at the first level from its source to destination
        directoryCopy.copyDir(entries, pathSource, pathDestination);

    } // ends main() method

} // ends Main class
