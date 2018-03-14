package com.large.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ScannerRead {

    private static final Logger LOG = Logger.getLogger(ScannerRead.class.getName());
    
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        try {
            Scanner sc = new Scanner(new File("E:\\Data\\fake-naaccr14inc-10000-rec\\fake-naaccr14inc-10000-rec.txt"), "UTF-8");
            long freeMemoryBefore = Runtime.getRuntime().freeMemory();
            while(sc.hasNextLine()) {
                String line = sc.nextLine();
//                LOG.log(Level.INFO, "line - {0}", line);
            }
            
            if(sc.ioException() != null) {
                sc.ioException().printStackTrace(System.out);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ScannerRead.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        long endTime = System.nanoTime();
        LOG.log(Level.INFO, "Total elapsed time : {0} ms", TimeUnit.MILLISECONDS.convert((endTime - startTime), TimeUnit.NANOSECONDS));
    }
}
