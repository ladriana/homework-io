package ro.scoalainformala;


import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;


public class Main {
    private static final String FILE_PATH = "C:\\Users\\acron\\Documents\\cursJAVA\\TEME\\homework-io\\alice.txt";

    public static void main(String[] args) {
        URL url = null;
        try {
            url = new URL("https://gist.githubusercontent.com/phillipj/4944029/raw/75ba2243dd5ec2875f629bf5d79f6c1e4b5a8b46/alice_in_wonderland.txt");
        } catch (MalformedURLException e) {
            System.out.println("Could not access the url ");
        }
        try (
                InputStream is = url.openStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH))
        ) {
            String inputLine;
            while ((inputLine = br.readLine()) != null) {
                int n = wordCount(inputLine);

                bw.write(n + " " + inputLine);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("The url could not be found ");
        } catch (NullPointerException e) {
            System.out.println("Something went wrong ");
        }
    }

    public static int wordCount(String m) {
        int count = 0;
        for (int i = 0; i <= (m.length() - 1); i++) {
            if (((i > 0) && (m.charAt(i) != ' ') && (m.charAt(i - 1) == ' ')) || ((m.charAt(i) != ' ') && (i == 0)))
                count++;
        }
        return count;
    }
}
