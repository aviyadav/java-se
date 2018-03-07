package com.javacreed.examples.concurrency.part1;

import java.io.File;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DirSize {
    private static final Logger LOGGER = LoggerFactory.getLogger(DirSize.class);
    
    public static long sizeOf(final File file) {
        System.out.println("Computing size of " + file);
        long size = 0;
        
        if(file.isFile()) {
            size = file.length();
        } else {
            final File[] children = file.listFiles();
            if(children != null) {
                for (final File child : children) {
                    size += DirSize.sizeOf(child);
                }
            }
        }
        
        return size;
    }
}
