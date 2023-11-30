import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.locks.ReentrantLock;

public class Lab6 {
    static FileOutputStream output;
    static ObjectOutputStream out;

    static ReentrantLock lock = new ReentrantLock();

    static {

        try {
            output = new FileOutputStream("Lab6-Output.dat");
            out = new ObjectOutputStream(output);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.print("Please enter the name or path of the file: ");
        File f = new File(in.nextLine());

        if (f.isDirectory()) {
            searchingDirecories(f);
        } else {
            processFiles(f);
        }

    }
    public static void searchingDirecories(File f) throws IOException {

        File[] inside = f.listFiles();

        for (File file : inside) {
            if (file.isDirectory()) {
                Runnable r = () -> {
                    try {
                        searchingDirecories(file);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                };
                Thread th = new Thread(r);
                th.start();
                try {
                    th.join();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            else if(!file.isHidden()) {
                processFiles(file);
            }
        }
    }

    public static void processFiles(File f) throws IOException {

        long fileLastModified = f.lastModified();
        Date date = new Date(fileLastModified);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String myDate = simpleDateFormat.format(date);

        Lab6Thread obj = new Lab6Thread(Thread.currentThread().getId(),f.getName(), f.canRead(), f.canWrite(), f.canExecute(), myDate);

        lock.lock();
        try {
            out.writeObject(obj);
        }
        finally {
            lock.unlock();
        }
    }
}
