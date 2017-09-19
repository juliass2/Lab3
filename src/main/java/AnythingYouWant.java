
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

/**
* Class.
* @param
*/
public class AnythingYouWant {
    /**
     * Main Method.
     * @param args
     */
    public static void main(final String[] args) {
        System.out.println(urlToString("http://erdani.com/tdpl/hamlet.txt"));
    }

    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        int words = 0;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();

        //New scanner to keep track of words within url.
        Scanner scan = new Scanner(contents);
        scan.useDelimiter(" ");
        while (scan.hasNext()) {
            words++;
            scan.next();
        }
        scan.close();


        //New (SPECIFIC TO HAMLET AND THE WORD "prince") counting specific words
        int countWord = 0;
        String contents0 = contents;
        contents0.toLowerCase();
        Scanner scan0 = new Scanner(contents0);
        scan0.useDelimiter("prince");
        while (scan0.hasNext()) {
            countWord++;
            scan0.next();
        }
        if (countWord > 0) {
            countWord++;
        }
        scan0.close();
/*
        while (contents0.indexOf("prince") != -1)
        {
            int index = contents0.indexOf("prince");
            contents0.substring(index);
            countWord++;
        }
*/

        contents = contents + "\nThere are " + words + " word(s) in this URL.";
        contents = contents + "The word 'prince' appears " + countWord + " times.";
        return contents;
    }
}
