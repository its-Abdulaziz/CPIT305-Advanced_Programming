import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class metadata {
    static File output = new File("/Users/Azzoz/Documents/FCIT/7th Semester/CPIT305/Lab3-Output.txt");
    static FileWriter out;

    static {
        try {
            out = new FileWriter(output);
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
        }
        else {
            ForFiles(f);
        }
        out.close();
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
        out.write("\n");

    }

    public static void ForFiles(File f) throws IOException {

        out.write("File name: " + f.getName() + "\n");
        out.write("File readable? : " + f.canRead() + "\n");
        out.write("File writable? : " + f.canWrite() + "\n");
        out.write("File executable? : " + f.canExecute() + "\n");

        long fileLastModified = f.lastModified();
        Date date = new Date(fileLastModified);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String myDate = simpleDateFormat.format(date);

        out.write("last modified : " + myDate + "\n");

 
        out.write("\n");
    }

}
