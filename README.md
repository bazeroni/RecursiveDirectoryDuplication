# RecursiveDirectoryDuplication

Program for recursively creating, listing, and copying a directory with sub-directories and files from user-inputted source and destination paths.

### Features

- **`Main:`** An executable class for the project itself. Interacts with the user to designate source and destination paths to duplicate directory. Runs the initial level of reading, creating, and duplication of the directory.

- **`CreateDirectory:`** Creates a directory at the designated destination path. Takes in a destination path.

- **`ListDirectory:`** Tests, reads, and prints the contents of a directory with a specified path argument. Returns the contents of the directory in the form of an array of 'File' type.

- **`CopyDirectory:`** Copies the directory contents from a source to a destination. Takes in an array of 'File' type to read the contents of the source. Takes in the source of the content and the destination the content should be copied to.

The directory 'dir0' is included with files and sub-directories for testing. Simply go into the directory, copy the address as text, and paste it as the source path. To specify a destination that copies to the same directory as 'dir0', simply paste the same address and rename the directory to something else, such as 'dir1'.

---

*CSCI 112 001 15A SP22 - COMPUTER SCIENCE II*
