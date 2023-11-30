package Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.locks.ReentrantLock;

public class Server {
    static FileOutputStream output;
    static ObjectOutputStream out;
    static ReentrantLock lock = new ReentrantLock();

    static {

        try {
            output = new FileOutputStream("Lab7-Output.dat", true);
            out = new ObjectOutputStream(output);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws ClassNotFoundException {
        try (ServerSocket s = new ServerSocket(8088)) {

            while (true) {
                System.out.println("Waiting For Clients");
                Socket socket = s.accept();
                System.out.println("New Client Has Connected \n");

                ClientHandler th = new ClientHandler(socket);
                th.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static synchronized void WriteToFile(Client.User obj) throws IOException {

        out.writeObject(obj);
    }

}
