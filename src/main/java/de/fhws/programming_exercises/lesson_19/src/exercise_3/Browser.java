package de.fhws.programming_exercises.lesson_19.src.exercise_3;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Optional;

public class Browser{
    public static void main(String[] args){
        System.out.println("Normal back");
        Browser browser = new Browser();
        Optional<URL> back = browser.back();
        back.ifPresent(browser::retrieveSite);
    }

    public Optional<URL> back(){
        Optional<URL> url;

        try{
            url = Math.random() < 0.5 ? Optional.of(new URL("http://google.de")) : Optional.empty();
        }catch (MalformedURLException e){
            throw new RuntimeException(e);
        }
        return url;
    }

    public String retrieveSite(URL url){        //simulate download site:
        return url.toString();
    }
}