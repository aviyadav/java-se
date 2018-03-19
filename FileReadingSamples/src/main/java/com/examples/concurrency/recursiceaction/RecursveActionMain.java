package com.examples.concurrency.recursiceaction;

import java.io.File;

public class RecursveActionMain {

    public static void main(String[] args) {
//        String sampleFile = "C:\\Users\\Q845332\\codebase\\data\\naaccr-files\\NAACCR-RANDOM-10000.dat";
//        System.out.println("Dir size of " + sampleFile + " is - " + new Double(DirSize.sizeOf(new File(sampleFile))) / 1024 / 1024 + " MB");

        String sampleDir = "C:\\Users\\Q845332\\codebase\\data\\naaccr-files";
//        String sampleDir = "C:\\Users\\Q845332\\codebase\\data\\naaccr-files\\input";
        System.out.println("Dir size of " + sampleDir + " is - " + new Double(DirSize.sizeOf(new File(sampleDir))) / 1024 /1024 + " MB");
    }

}
