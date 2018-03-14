package com.large.file;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Java7FileRead {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        
        Path file = Paths.get("E:\\Data\\fake-naaccr14inc-10000-rec\\fake-naaccr14inc-10000-rec.txt");
        
        try {
            List<String> readAllLines = Files.readAllLines(file, StandardCharsets.UTF_8);
            readAllLines.forEach((line) -> {
//                System.out.println(line);
            });
        } catch (IOException ex) {
            Logger.getLogger(Java7FileRead.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        long endTime = System.nanoTime();
        System.out.println("Total elapsed time : " + TimeUnit.MILLISECONDS.convert((endTime - startTime), TimeUnit.NANOSECONDS) + " ms");
    }
}
