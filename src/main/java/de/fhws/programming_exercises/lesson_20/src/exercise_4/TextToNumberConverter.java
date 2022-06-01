package de.fhws.programming_exercises.lesson_20.src.exercise_4;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class TextToNumberConverter{
    static Map<Character, String> table = new HashMap<>();

    static{
        table.put('A', "2");
        table.put('B', "22");
        table.put('C', "222");
        table.put('D', "3");
        table.put('E', "33");
        table.put('F', "333");
        table.put('G', "4");
        table.put('H', "44");
        table.put('I', "444");
        table.put('J', "5");
        table.put('K', "55");
        table.put('L', "555");
        table.put('M', "6");
        table.put('N', "66");
        table.put('O', "666");
        table.put('P', "7");
        table.put('Q', "77");
        table.put('R', "777");
        table.put('S', "7777");
        table.put('T', "8");
        table.put('U', "88");
        table.put('V', "888");
        table.put('W', "9");
        table.put('X', "99");
        table.put('Y', "999");
        table.put('Z', "9999");
    }

    private BufferedReader reader = null;
    private BufferedWriter writer = null;

    public TextToNumberConverter(){
        super();
    }

    public TextToNumberConverter(File inputFile, File outputFile){
        setPaths(inputFile, outputFile);
    }

    public static void main(String[] args){
        System.out.println(TextToNumberConverter.table);
    }

    public void setPaths(File inputFile, File outputFile){
        try{
            reader = new BufferedReader(new FileReader(inputFile));
        }catch (IOException e){
            throw new RuntimeException(e);
        }
        try{
            writer = new BufferedWriter(new FileWriter(outputFile));
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    public void convertFile(){
        if (reader == null || writer == null){
            throw new NullPointerException("Converter not initialized in File mode!");
        }

        String readString;

        try{
            while (true){
                readString = reader.readLine();
                if (readString == null) break;
                System.out.println(readString);
                writer.write(convert(readString) + "\n");
                writer.flush();
            }
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    public String convert(String str){
        StringBuilder out = new StringBuilder();
        String temp;
        for (char c : str.toCharArray()){
            c = Character.toUpperCase(c);
            try{
                temp = convert(c);
            }catch (IllegalTelephoneNumberException e){
                continue;
            }
            out.append(temp);
        }
        return out.toString();
    }

    public String convert(char c) throws IllegalTelephoneNumberException{
        String out = table.getOrDefault(c, "?");
        if ("?".equals(out)) throw new IllegalTelephoneNumberException();
        return out;
    }
}
