package com.large.file;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

public class Java8StreamRead {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        
        Path file = Paths.get("E:\\Data\\fake-naaccr14inc-10000-rec\\fake-naaccr14inc-10000-rec.txt");
        
        try {
            Stream<String> lines = Files.lines(file, StandardCharsets.UTF_8);
            for (String line : (Iterable<String>) lines::iterator) {
                System.out.println("line -> " + line);
            }
        } catch (IOException ex) {
            Logger.getLogger(Java8StreamRead.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        long endTime = System.nanoTime();
        System.out.println("Total elapsed time : " + TimeUnit.MILLISECONDS.convert((endTime - startTime), TimeUnit.NANOSECONDS) + " ms");
    }
}
