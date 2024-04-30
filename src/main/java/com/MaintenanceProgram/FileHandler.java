package com.MaintenanceProgram;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

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

    public Boolean writeToFile(ArrayList<String> names) {
        if (!isFileToWrite()) {
            return false;
        }

        try {
            formatter = new Formatter(writeFilename);
            for (String name : names) {
                formatter.format("%s%n", name);
            }
            formatter.close();
            return true;
        } catch (FileNotFoundException e) {
            System.out.println("An error file writing occurred.");
            return false;
        }
    }

    public Boolean readFromeFile(ArrayList<String> names) {

        if (!isFileToRead()) {
            return false;
        }

        try {
            readScanner = new Scanner(new File(readFilename));
            while (readScanner.hasNextLine()) {
                String name = readScanner.nextLine();
                names.add(name);
            }
            readScanner.close();
            return true;
        } catch (FileNotFoundException e) {
            System.out.println("An error file reading occurred.");
            return false;
        }
    }

}
