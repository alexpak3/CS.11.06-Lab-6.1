import java.io.*;
import java.util.Scanner;

public class AdventureTime {

    /** This is the main method and it is where you will test your implementations for challengeOne, challengeTwo, etc.
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        System.out.println(challengeOne("inputOneTwo"));
        System.out.println(challengeTwo("inputOneTwo"));
        System.out.println(challengeThree("testInputThreeFour"));
        System.out.println(challengeFour("testInputThreeFour"));

    }




    /** TODO 1
     *
     * Challenge 1
     *
     * @param fileName
     * @return Answer to Challenge 1
     * @throws IOException
     */
    public static int challengeOne(String fileName) throws IOException {
        int increase = 0;
        File readingFile = new File ("inputOneTwo.txt");
        Scanner readscan = new Scanner("inputOneTwo.txt");
        int[] myArray = readFile("inputOneTwo.txt");
        for (int i = 0; i < myArray.length -1; i++) {
            if (myArray[i] < myArray[i+1]){
                increase++;
            }
        }



        return increase;
    }

    /** TODO 2
     *
     * Challenge 2
     *
     * @param fileName
     * @return Answer to Challenge 2
     * @throws FileNotFoundException
     */
    public static int challengeTwo(String fileName) throws FileNotFoundException {
        int increase = 0;
        File readingFile = new File ("inputOneTwo.txt");
        Scanner readscan = new Scanner("inputOneTwo.txt");
        int[] myArray = readFile("inputOneTwo.txt");
        for (int i = 0; i < myArray.length -3; i++) {
            int sumFirst = myArray[i] + myArray[i+1] + myArray[i+2];
            int sumSecond = myArray[i+1] + myArray[i+2] + myArray[i+3];
            if (sumFirst < sumSecond){
                increase++;
            }
        }



        return increase;
    }


    /** TODO 3
     *
     * Challenge 3
     *
     * @param fileName
     * @return Answer to Challenge 3
     * @throws FileNotFoundException
     */
    public static int challengeThree(String fileName) throws FileNotFoundException {
        int result = 0;
        File readingFile = new File ("inputThreeFour.txt");
        Scanner readscan = new Scanner("inputThreeFour.txt");
        String[] myArray = readFileString("inputThreeFour.txt");
        int forward = 0;
        int depth = 0;
        for (int i = 0; i < myArray.length; i++){
            if (myArray[i].contains("forward")){
                String see = myArray[i].substring(8, myArray[i].length());
                forward += Integer.valueOf(see);
            }
            else if (myArray[i].contains("down")){
                String see = myArray[i].substring(5, myArray[i].length());
                depth = depth + Integer.valueOf(see);
            }
            else if (myArray[i].contains("up")){
                String see = myArray[i].substring(3, myArray[i].length());
                depth = depth - Integer.valueOf(see);
            }
        }
        result = forward * depth;
        return result;

    }

    /** TODO 4
     *
     * Challenge 4
     *
     * @param filename
     * @return Answer to Challenge 4
     * @throws FileNotFoundException
     */
    public static int challengeFour(String filename) throws FileNotFoundException {
        int result = 0;
        File readingFile = new File ("inputThreeFour.txt");
        Scanner readscan = new Scanner("inputThreeFour.txt");
        String[] myArray = readFileString("inputThreeFour.txt");
        int forward = 0;
        int depth = 0;
        int aim = 0;
        for (int i = 0; i < myArray.length; i++){
            if (myArray[i].contains("forward")){
                String see = myArray[i].substring(8, myArray[i].length());
                forward = forward + Integer.valueOf(see);
                depth = depth + aim*Integer.valueOf(see);
            }
            else if (myArray[i].contains("down")){
                String see = myArray[i].substring(5, myArray[i].length());
                aim = aim + Integer.valueOf(see);
            }
            else if (myArray[i].contains("up")){
                String see = myArray[i].substring(3, myArray[i].length());

                aim = aim - Integer.valueOf(see);
            }
        }
        result = forward * depth;
        return result;

    }


    /** This method will write the values passed as challengeOne, challengeTwo, challengeThree, and challengeFour to a text file.
     * Do not edit this method.
     */
    private static void writeFileAllAnswers(String outPutFilename, int challengeOne, int challengeTwo, int challengeThree, int challengeFour) throws IOException {
        File file = new File(outPutFilename);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        bufferedWriter.write("Challenge 1: " + "\t" + challengeOne + "\n");
        bufferedWriter.write("Challenge 2: " + "\t" + challengeTwo + "\n");
        bufferedWriter.write("Challenge 3: " + "\t" + challengeThree + "\n");
        bufferedWriter.write("Challenge 4: " + "\t" + challengeFour + "\n");
        bufferedWriter.close();
    }

    /** This method will read the values in inputFilename into an array of integers, which it will return.
     * Do not edit this method.
     */
    private static int[] readFile(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int numberOfLinesInFile = countLinesInFile(inputFilename);
        int[] data = new int[numberOfLinesInFile];
        int index = 0;
        while (scanner.hasNextLine()) {
            data[index++] = scanner.nextInt();
        }
        scanner.close();
        return data;
    }
    private static String[] readFileString(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int numberOfLinesInFile = countLinesInFile(inputFilename);
        String[] data = new String[numberOfLinesInFile];
        int index = 0;
        while (scanner.hasNextLine()) {
            data[index++] = scanner.nextLine();
        }
        scanner.close();
        return data;
    }

    /** This method will count the number of lines in a text file, which it will return.
     * Do not edit this method.
     */
    private static int countLinesInFile(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int lineCount = 0;
        while (scanner.hasNextLine()) {
            lineCount++;
            scanner.nextLine();
        }
        scanner.close();
        return lineCount;
    }

}