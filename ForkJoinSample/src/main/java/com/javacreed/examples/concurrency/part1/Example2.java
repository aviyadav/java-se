package com.javacreed.examples.concurrency.part1;

import com.javacreed.examples.concurrency.utils.FilePath;
import com.javacreed.examples.concurrency.utils.Results;
import java.util.concurrent.TimeUnit;

public class Example2 {
    public static void main(String[] args) {
        final Results results = new Results();
        for (int i = 0; i < 5; i++) {
            results.startTime();
            final long size = DirSize.sizeOf(FilePath.TEST_DIR);
            final long taken = results.endTime();
            
            System.out.println("Size of " + FilePath.TEST_DIR + ": " + size + " bytes in " + taken + "nanos");
        }
        
        final long takenInNano = results.getAverageTime();
        System.out.println("Average : " + takenInNano + " nano (" + TimeUnit.NANOSECONDS.toSeconds(takenInNano) + " seconds)");
    }
}
