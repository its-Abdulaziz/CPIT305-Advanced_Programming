package Client;

import java.io.Serializable;

public class User implements Serializable {
    private String Name;
    private String DoB;
    private String Gender;
    private String Nationality;

    public User(String name, String doB, String gender, String nationality) {
        Name = name;
        DoB = doB;
        Gender = gender;
        Nationality = nationality;
    }

    @Override
    public String toString() {
        return "User{" +
                "Name='" + Name + '\'' +
                ", DoB='" + DoB + '\'' +
                ", Gender='" + Gender + '\'' +
                ", Nationality='" + Nationality + '\'' +
                '}';
    }
}
