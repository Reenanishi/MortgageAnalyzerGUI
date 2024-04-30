package  com.GradeIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class FileHandler {

    private Scanner readScanner;
    private Formatter formatter;
    private String readFilename;
    private String writeFilename;


    public FileHandler(String readFilename, String writeFilename){
        this.readFilename = readFilename;
        this.writeFilename = writeFilename;
    }

    public Boolean isFileToRead() {
        File readFile = new File(readFilename);
        return readFile.canRead();
    }

    public Boolean isFileToWrite() {
        File writeFile = new File(writeFilename);
        return writeFile.canWrite();
    }

    public Boolean writeToFile(ArrayList<String> grades) {
        if (!isFileToWrite()) {
            return false;
        }

        try {
            formatter = new Formatter(writeFilename);
            for (String grade : grades) {
                formatter.format("%s%n", grade);
            }
            formatter.close();
            return true;
        } catch (FileNotFoundException e) {
            System.out.println("An error file writing occurred.");
            return false;
        }
    }

    public Boolean readFromeFile(ArrayList<String> grades) {

        if (!isFileToRead()) {
            return false;
        }

        try {
            readScanner = new Scanner(new File(readFilename));
            while (readScanner.hasNextLine()) {
                String grade = readScanner.nextLine();
                grades.add(grade);
            }
            readScanner.close();
            return true;
        } catch (FileNotFoundException e) {
            System.out.println("An error file reading occurred.");
            return false;
        }
    }


    public static void main (String[] args){

        String readFilename = "/Users/ankurpandey/IdeaProjects/hellofx/src/hellofx/GradeIO/grades.txt";
        String writeFilename = "/Users/ankurpandey/IdeaProjects/hellofx/src/hellofx/GradeIO/grades.txt";

        FileHandler fileHandler = new FileHandler(readFilename, writeFilename);

        ArrayList<String> writeGrades = new ArrayList<String>();

        Scanner scanner = new Scanner(System.in);

        if (fileHandler.isFileToWrite()) {
            System.out.println("Write file is present");

            String input;

            System.out.println("Writing grades to file:");
            while (true) {
                System.out.println("Please enter grade or # to end input");
                String grade =  scanner.next();

                if  (grade.equals("#")) {
                    break;
                }
                writeGrades.add(grade);
            }

            fileHandler.writeToFile(writeGrades);
        } else {
            System.out.println("Write file is not  present");
        }

        System.out.println("Reading file:");
        ArrayList<String> readGrades = new ArrayList<String>();

        if (fileHandler.isFileToRead()) {
            System.out.println("Read file is present");
            fileHandler.readFromeFile(readGrades);
        } else {
            System.out.println("Read file is not  present");
        }

        System.out.println("File grades:");
        for (String grade: readGrades) {
            System.out.print(grade + " ");
        }
        System.out.println();
        System.out.println();
    }
}
