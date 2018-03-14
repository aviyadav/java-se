package com.large.file;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileHandling {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        
        Path file = Paths.get("E:\\Data\\fake-naaccr14inc-10000-rec\\fake-naaccr14inc-10000-rec.txt");
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file.toFile()));
            reader.lines().forEach(System.out::println);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileHandling.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        long endTime = System.nanoTime();
        System.out.println("Total elapsed time : " + TimeUnit.MILLISECONDS.convert((endTime - startTime), TimeUnit.NANOSECONDS) + " ms");
    }
    
}
