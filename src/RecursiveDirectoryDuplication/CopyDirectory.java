// RecursiveDirectoryDuplication.java
// program for recursively creating, listing, and copying a directory from source to destination for CSCI 112
// last edited Feb. 20, 2022 by S. Gutierrez

package RecursiveDirectoryDuplication;

// imports libraries for reading/writing data and i/o console interaction
import com.sun.org.apache.bcel.internal.classfile.SourceFile;
import java.io.*;
import java.util.Scanner;

// copies directory contents from source to destination
public class CopyDirectory {

    // copies directory contents from source to destination
    // takes in an array of File type to read the contents of the source
    // takes in the source of the content and the destination the content should be copied to
    public void copyDir(File[] entries, String pathSource, String pathDestination) throws Exception {

        // loops through the File array entries where content is held
        for (File entry : entries) {

            // checks if the File type entry is a file
            if (entry.isFile()) {

                // creates file objects for the source and destination files
                File sourceFile = entry;
                File destFile = new File(pathDestination + "/" + entry.getName());

                // creates file streams for the source and destination files
                FileInputStream sourceStream = new FileInputStream(sourceFile);
                FileOutputStream destStream = new FileOutputStream(destFile);

                // buffers the file streams
                BufferedInputStream bufferedSource = new BufferedInputStream(sourceStream, 8182);
                BufferedOutputStream bufferedDestination = new BufferedOutputStream(destStream, 6192);

                // transfers data between files with int tracker of bytes
                int transfer;

                // tells the user where the file is being copied
                System.out.print("\n");
                System.out.println("Copying Files...");
                System.out.println("\tcopying " + sourceFile.getAbsolutePath());
                System.out.println("\tto      " + destFile.getAbsolutePath());

                // reads a byte, checks for end of file (returns -1 by read at EOF)
                while ((transfer = bufferedSource.read()) != -1) {

                    // writes a byte
                    bufferedDestination.write(transfer);

                } // ends while

                // closes file stream source
                if (bufferedSource != null) {
                    bufferedSource.close();
                } // ends if

                // closes file stream destination
                if (bufferedDestination != null) {
                    bufferedDestination.close();
                } // ends if

                // notifies user that the copy is complete
                System.out.println("Copy complete.");

            } // ends if file check statement

            // checks if the File type entry is a directory
            else if (entry.isDirectory()) {

                // notifies user that a recursive process will be starting again in another directory
                System.out.print("\nPeeking into the '" + entry.getName() + "' directory...");

                // creates a new array to hold contents of the sub-directory
                File[] subEntries;

                // creates instance objects for the sub-directory to call methods
                CreateDirectory subDirectoryMake = new CreateDirectory();
                ListDirectory subDirectoryShow = new ListDirectory();
                CopyDirectory subDirectoryCopy = new CopyDirectory();

                // makes the new directory that the data should be contained in
                subDirectoryMake.createDir(pathDestination + "/" + entry.getName());

                // lists the directory contents at the specified source path, stores the contents as File types in an array
                subEntries = subDirectoryShow.listDir(entry.getAbsolutePath());

                // copies the entries in the sub-directory from its source to destination recursively
                subDirectoryCopy.copyDir(subEntries, entry.getAbsolutePath(), pathDestination + "/" + entry.getName());

            } // ends if directory check statement

        } // ends for loop through File entries array

    } // ends copyDir() method

} // ends CopyDirectory class
