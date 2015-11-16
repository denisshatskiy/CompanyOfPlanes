package com.epam.mentoringProgram.lesson4.companyOfPlanes;

import java.io.*;

public class ConsoleAndFileOutput {
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

    public void consoleAndFileWrite(String stringForPrint) {
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
}
