package com.javacreed.examples.concurrency.part1;

import com.javacreed.examples.concurrency.utils.FilePath;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Example1 {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(Example1.class);
    
    public static void main(String[] args) {
        final long start = System.nanoTime();
        final long size = DirSize.sizeOf(FilePath.TEST_DIR);
        final long taken = System.nanoTime() - start;
        
//        Example1.LOGGER.debug("Size of '{}': {} bytes (in {} nano)", FilePath.TEST_DIR, size, taken);
        System.out.println("Size of " + FilePath.TEST_DIR + ": " + size + " bytes (in " + taken + " nano");
    }
}
