package com.epam;

import java.io.*;

public class Writer {
    String filename="D:\\outputFile.txt";

    public void createFile(){
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
    public void writeFile (String tempStringForAllMethods) {
        PrintStream out = null;
        try {
            out = new PrintStream(new BufferedOutputStream(new FileOutputStream(filename, true)));
            out.println(tempStringForAllMethods);
        } catch(IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }
}
