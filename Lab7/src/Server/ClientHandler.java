package Server;

import Client.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class ClientHandler extends Thread {

    private Socket in;

    private User obj;

    private ObjectInputStream input;

    public ClientHandler(Socket in) {
        this.in = in;
    }

    @Override
    public void run() {
        try {
            input = new ObjectInputStream(in.getInputStream());
            User user = (User) input.readObject();

            Server.WriteToFile(user);

            input.close();

        }
        catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
