package test;

import java.io.*;

public class test {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileInputStream input = new FileInputStream("/Users/Azzoz/Documents/FCIT/7th Semester/CPIT305/Lab7/Lab7-Output.dat");
        ObjectInputStream in = new ObjectInputStream(input);


        while (true) {
            System.out.println((Client.User) in.readObject());
        }
    }
}
