package Client;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    static private User obj;

    static private Scanner input = new Scanner(System.in);

    static private ObjectOutputStream out;

    public static void main(String[] args) throws IOException {

        Socket socket = null;
        try {
            socket = new Socket("localhost", 8088);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Please enter your Name then Gender then Date of Birth then Nationality: ");

        obj = new User(input.nextLine(), input.nextLine(), input.nextLine(), input.nextLine());
        try {
            out = new ObjectOutputStream(socket.getOutputStream());
            out.writeObject(obj);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

