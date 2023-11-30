import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Lab5 implements Runnable {

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
                printThreadInfo();
            }
            else if(!file.isHidden()) {
                processFiles(file);
            }
        }
    }

    public static void processFiles(File f) throws IOException {
        System.out.print("File name: " + f.getName() + "\n");
        System.out.print("File readable? : " + f.canRead() + "\n");
        System.out.print("File writable? : " + f.canWrite() + "\n");
        System.out.print("File executable? : " + f.canExecute() + "\n");

        long fileLastModified = f.lastModified();
        Date date = new Date(fileLastModified);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String myDate = simpleDateFormat.format(date);

        System.out.println("Last modified : " + myDate + "\n");

    }

    public static void printThreadInfo() throws IOException {
        Thread currentThread = Thread.currentThread();
        System.out.print("Thread ID: " + currentThread.getId() + "\n");
        System.out.println("Thread Name: " + currentThread.getName() + "\n");
    }

    @Override
    public void run() {

    }
}