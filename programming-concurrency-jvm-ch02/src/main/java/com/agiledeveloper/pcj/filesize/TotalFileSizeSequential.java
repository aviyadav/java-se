package com.agiledeveloper.pcj.filesize;

import java.io.File;

public class TotalFileSizeSequential {

    private long getTotalSizeOfFileInDir(final File file) {
        if(file.isFile()) {
            return file.length();
        }
        
        final File[] children = file.listFiles();
        long total = 0;
        if(children != null) {
            for(final File child : children) {
                total += getTotalSizeOfFileInDir(child);
            }
        }
        
        return total;
    }
    
    public static void main(String[] args) {
        final long start = System.nanoTime();
        final long total = new TotalFileSizeSequential().getTotalSizeOfFileInDir(new File("D:\\softwares"));
        final long end = System.nanoTime();
        
        System.out.println("Total size: " + total + " bytes");
        System.out.println("Time taken: " + (end - start) / 1.0e9 );
    }
}
