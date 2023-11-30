
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

import org.json.*;
import org.json.*;


public class Lab8 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.print("Please enter the text that you want to translate to Arabic: ");

        String text = in.nextLine();

        String[] x = text.split(" ");

        StringBuilder textToSend = new StringBuilder();

        for (int i = 0; i < x.length; i++) {
            textToSend.append(x[i] + "%20");
        }

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://google-translate1.p.rapidapi.com/language/translate/v2"))
                .header("content-type", "application/x-www-form-urlencoded")
                .header("Accept-Encoding", "application/gzip")
                .header("X-RapidAPI-Key", "95cc67f6e6msh2f819521a257488p11442djsn597fd767ea16")
                .header("X-RapidAPI-Host", "google-translate1.p.rapidapi.com")
                .method("POST", HttpRequest.BodyPublishers.ofString("q=" + textToSend + "&target=ar&source=en"))
                .build();

        HttpResponse<String> response = null;
        try {
            response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        String tanslatedText = new JSONObject(response.body())
                .getJSONObject("data")
                .getJSONArray("translations").getJSONObject(0)
                .getString("translatedText");


        System.out.print("\nThe translation of \" " + text + " \" in Arabic is: ");
        System.out.println(tanslatedText);
    }
}
