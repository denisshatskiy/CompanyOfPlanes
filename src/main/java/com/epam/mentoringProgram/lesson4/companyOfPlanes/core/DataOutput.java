package com.epam.mentoringProgram.lesson4.companyOfPlanes.core;

import com.epam.mentoringProgram.lesson4.companyOfPlanes.subject.Plane;

import java.io.*;
import java.util.List;

public class DataOutput {
    String filename = "outputFile.txt";

    public void createFile() {
        PrintStream out = null;
        try {
            out = new PrintStream(new BufferedOutputStream(new FileOutputStream(filename)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

    public void consoleAndFileOutput(String stringForPrint) {
        System.out.println(stringForPrint);
        PrintStream out = null;
        try {
            out = new PrintStream(new BufferedOutputStream(new FileOutputStream(filename, true)));
            out.println(stringForPrint);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

    public void listPrint(List<Plane> resultSearch){
        for (Plane plane : resultSearch){
            System.out.println(plane.toString());
        }
    }
}
