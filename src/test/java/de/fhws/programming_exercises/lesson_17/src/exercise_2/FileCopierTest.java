package de.fhws.programming_exercises.lesson_17.src.exercise_2;

import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.fail;

class FileCopierTest{
    String packageLocation = this.getClass().getPackageName().replace(".", "/");
    File file = new File("./src/test/java/" + packageLocation + "/output.txt");
    FileOutputStream fos = new FileOutputStream(file);

    FileCopierTest() throws FileNotFoundException{
    }

    @Test
    void testZeroSizeArray(){
        byte[] b = new byte[0];
        int off = 0;
        int len = 5;
        try{
            fos.write(b, off, len);
            fail("Expected IndexOutOfBoundsException");
        }catch (IOException ioe){
            System.out.println("IO Exception!");
            fail();
        }catch (IndexOutOfBoundsException ioobe){
            System.out.println("The Byte-Array cannot have the length of 0");
        }
    }

    @Test
    void testOffsetPlusLength(){
        byte[] b = new byte[5];
        int off = 1;
        int len = 5;
        try{
            fos.write(b, off, len);
            fail("Expected IndexOutOfBoundsException");
        }catch (IOException ioe){
            fail("IO Exception!");
        }catch (IndexOutOfBoundsException ioobe){
            System.out.println("The Byte-Array has to have a length of at least off+len");
        }
    }

    @Test
    void testNegativeLength(){
        byte[] b = new byte[5];
        int off = 0;
        int len = -1;
        try{
            fos.write(b, off, len);
            fail("Expected IndexOutOfBoundsException");
        }catch (IOException ioe){
            fail("IO Exception!");
        }catch (IndexOutOfBoundsException ioobe){
            System.out.println("The len cannot be negative");
        }
    }

    @Test
    void testZeroLength(){
        byte[] b = new byte[5];
        int off = 0;
        int len = 0;
        try{
            fos.write(b, off, len);
        }catch (IOException ioe){
            fail("IO Exception!");
        }
        try{
            FileReader fr = new FileReader(file);
            if (fr.read() != -1){
                fail("Expected empty file");
            }else{
                System.out.println("File empty");
            }
        }catch (IOException e){
            e.printStackTrace();
        }


    }
}