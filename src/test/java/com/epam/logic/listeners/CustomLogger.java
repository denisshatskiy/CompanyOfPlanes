package com.epam.logic.listeners;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;

import java.io.*;

public class CustomLogger extends TestListenerAdapter {
    private int m_count = 0;

    @Override
    public void onTestFailure(ITestResult tr) {
        consoleAndFileOutput(tr.getName() + "--Test method failed\n");
    }

    @Override
    public void onTestSkipped(ITestResult tr) {
        consoleAndFileOutput(tr.getName() + "--Test method skipped\n");
    }

    @Override
    public void onTestSuccess(ITestResult tr) {
        consoleAndFileOutput(tr.getName() + "--Test method success\n");
    }

    private void log(String string) {
        System.out.print(string);
        if (++m_count % 40 == 0) {
            System.out.println("");
        }
    }

    private String filename = "outputFile.txt";

    @BeforeSuite
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

    @AfterMethod
    public void consoleAndFileOutput(String stringForPrint) {
        log(stringForPrint);
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