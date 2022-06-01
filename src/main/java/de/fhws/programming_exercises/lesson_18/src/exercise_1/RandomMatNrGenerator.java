package de.fhws.programming_exercises.lesson_18.src.exercise_1;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class RandomMatNrGenerator{

    private final MatrNr[] mng = MatrNr.values();

    private final int[] countArr;

    /**
     * @param count total number of MatrNrGroup which should be generated
     */
    public RandomMatNrGenerator(int count){
        this(count / 3, count / 3, count / 3);
    }

    /**
     * @param countInf  number of "Informatik" MatrNrs
     * @param countWinf number of "Wirtschaftsinformatik" MatrNrs
     * @param countEC   number of "E-Commerce" MatrNrs
     */
    public RandomMatNrGenerator(int countInf, int countWinf, int countEC){
        this.countArr = new int[3];
        this.countArr[0] = countInf;
        this.countArr[1] = countWinf;
        this.countArr[2] = countEC;
    }

    /**
     * Generates a {@code .txt} file with randomly generated MatrNrs
     *
     * @param file file to write to
     */
    public void generateToFile(File file){
        try (FileWriter fw = new FileWriter(file)){
            int[][] matrNrs = generateAll();

            for (int[] group : matrNrs){
                for (int nr : group){
                    if (nr == 0){
                        break;                      // no more MatrNrs
                    }else{
                        fw.write(nr + "\n");    // write MatrNr to file
                    }
                }
            }
        }catch (IOException e){
            System.out.println("CRITICAL ERROR - generateToFile failed");
            e.printStackTrace();
        }
    }

    /**
     * Creates a 2D array of MatrNrs, first index indicates which group the MatrNrs belong to
     *
     * @return MatrNr array
     */
    public int[][] generateAll(){
        int maxCount = Math.max(Math.max(countArr[0], countArr[1]), countArr[2]);
        int[][] res = new int[3][maxCount];

        for (int i = 0; i < 3; i++){
            res[i] = generate(i);
        }
        return res;
    }

    /**
     * Generates a random MatrNr starting with the correct prefix
     *
     * @param matrNrGroupIndex group index to get correct prefix
     * @return array of {@code n} MatrNrs
     */
    private int[] generate(int matrNrGroupIndex){
        int count = countArr[matrNrGroupIndex];
        int[] res = new int[count];

        for (int i = 1; i <= count; i++){
            int r = (i * (int) (Math.random() * 100_000)) % 100_000;    // get a number in [000_000, 100_000[
            res[i - 1] = mng[matrNrGroupIndex].prefix * 100000 + r;     // add the prefix
        }

        return res;
    }
}
