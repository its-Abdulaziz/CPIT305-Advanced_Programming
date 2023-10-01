import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class Lab4 {
    static FileOutputStream output;
    static ObjectOutputStream out;

    static ArrayList<metadataLab4> arr = new ArrayList<>();

    static {
        try {
            output = new FileOutputStream("Lab4-Output.dat");
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
            ForDirictory(f);
        } else {
            ForFiles(f);
        }

        try {
        for (metadataLab4 x : arr) {
            out.writeObject(x);
        }
        out.close();
        output.close();
        }
        catch (Exception Ex)  {
            System.out.println(Ex);
        }
    }

    public static void ForDirictory(File f) throws IOException {

        File[] inside = f.listFiles();

        for (int i = 0; i < inside.length; i++) {
            if (inside[i].isDirectory()) {
                ForDirictory(inside[i]);
            } else {
                ForFiles(inside[i]);
            }
        }

    }

    public static void ForFiles(File f) throws IOException {
        long fileLastModified = f.lastModified();
        Date date = new Date(fileLastModified);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String myDate = simpleDateFormat.format(date);
        metadataLab4 obj = new metadataLab4(f.getName(), f.canRead(), f.canWrite(), f.canExecute(), myDate);

        arr.add(obj);

    }

}
