package  com.GradeIO;


import java.util.*;

public class FileHandlerTest {

    public static void main (String[] args){

        String readFilename = "/Users/ankurpandey/IdeaProjects/hellofx/src/hellofx/GradeIO/grades.txt";
        String writeFilename = "/Users/ankurpandey/IdeaProjects/hellofx/src/hellofx/GradeIO/grades.txt";

        FileHandler fileHandler = new FileHandler(readFilename, writeFilename);

        ArrayList<String> writeGrades = new ArrayList<String>();
        writeGrades.add("A+");
        writeGrades.add("B-");
        writeGrades.add("F");
        writeGrades.add("C");
        writeGrades.add("D+");


        System.out.println("Writing grades to file:");
        for (String grade: writeGrades) {
            System.out.print(grade + " ");
        }

        if (fileHandler.isFileToWrite()) {
            fileHandler.writeToFile(writeGrades);
        }

        System.out.println("Reading from file:");
        ArrayList<String> readGrades = new ArrayList<String>();

        if (fileHandler.isFileToRead()) {
            System.out.println("Read file is present");
            fileHandler.readFromeFile(readGrades);
        }

        for (String grade: readGrades) {
            System.out.println(grade + " ");
        }
        System.out.println();
        System.out.println();
    }
}
