package de.fhws.programming_exercises.lesson_08.src;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Exercise4{
    public static void main(String[] args) throws IOException{
        String seite = "<body id=\"www-wikipedia-org  \">"
                +"<div class=\"central-textlogo\">"
                +"<img src=\"https://upload.wikimedia.org/wikipedia/commons/thumb"
                +"/b/bb/Wikipedia_wordmark.svg/174px-Wikipedia_wordmark.svg.png\">"
                +"</div>"+"</body>";


        String downloadUrl = cutURL(seite);


        URL url = new URL(downloadUrl);
        BufferedImage image = ImageIO.read(url);
        ImageIO.write(image, "png", new File("bild.png"));
    }

    /**
     * Cuts the Image URL from a string
     *
     * @param input a String which contains the URL
     * @return the URL portion of the String
     */
    public static String cutURL(String input){
        String output;
        int startIndex = input.indexOf("https://");
        int endIndex = input.indexOf(".png")+4;
        output = input.substring(startIndex, endIndex);
        System.out.println(output);
        return output;
    }
}