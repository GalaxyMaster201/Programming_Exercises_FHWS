package de.fhws.programming_exercises.lesson_18.src.exercise_1;

import java.io.*;

public class MatrNrFilter{
    private final File completeList;
    private final File infNr;
    private final File wInfNr;
    private final File ecNr;

    public MatrNrFilter(File completeList){
        this.completeList = completeList;
        String cl = getPath(completeList);

        this.infNr = new File(cl + "\\InfNr.txt");
        this.wInfNr = new File(cl + "\\WInfNr.txt");
        this.ecNr = new File(cl + "\\ECNr.txt");
    }

    /**
     * Get the path to {@code file} excluding the filename
     *
     * @param file file location
     * @return path
     */
    private String getPath(File file){
        String path = file.getPath();
        path = path.substring(0, path.lastIndexOf('\\'));
        System.out.println(path);
        return path;
    }

    /**
     * Split the courses' MatrNrs into 3 separate files
     *
     * @throws FileNotFoundException file can't be created
     */
    public void splitCourses() throws FileNotFoundException{
        extractCourse(infNr);
        extractCourse(wInfNr);
        extractCourse(ecNr);
    }

    /**
     * Get all the correct MatrNrs and write them to a file
     *
     * @param file file to write to
     * @throws FileNotFoundException file can't be created
     */
    private void extractCourse(File file) throws FileNotFoundException{
        int prefix;

        // pick correct prefix using the filename
        if (file == infNr){
            prefix = MatrNr.INF.prefix;
        }else if (file == wInfNr){
            prefix = MatrNr.WINF.prefix;
        }else if (file == ecNr){
            prefix = MatrNr.EC.prefix;
        }else{
            throw new FileNotFoundException("Invalid filename");
        }

        try (FileReader fr = new FileReader(completeList);
             FileWriter fw = new FileWriter(file)
        ){
            char[] cb = new char[8];    // char buffer
            int n;                      // number of read bytes
            while (true){
                n = fr.read(cb);
                if (n == -1) break;
                int start = Integer.parseInt(cb[0] + "" + cb[1]);   // get the first 2 digits from the MatrNr
                if (start == prefix){
                    fw.write(cb);
                }
            }
        }catch (IOException ioe){
            System.out.println("IO Exception!");
        }
    }

}
