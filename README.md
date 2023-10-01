# CPIT305-Advanced_Programming

## Lab-3 Files and streams

Create a program that accepts a filename as an input, and if the file is a directory, recursively gather metadata about all files and directories in that directory (permissions such as readable, writable, and executable as well as the last modified time). Format the output in a readable way and write it out to a text file.

Solution in metadata file.

## Lab-4 Serialization/Deserialization

Create a program that accepts a filename as an input, and if the file is a directory, recursively gather metadata about all files and directories in that directory (permissions such as readable, writable, and executable as well as the last modified time). You should create a Metadata class that represent the metadata collected from each file, where you will have one metadata object for each File object that exists under the input directory. Store the metadata objects in a list, and once you have enumerated the directory, write the objects to a file on disk

Solution in Lab4 and metadataLab4 files.

As we are using recursive method to get into each directory, I used ArrayList to store the objects then I printed the objects one by one. 
