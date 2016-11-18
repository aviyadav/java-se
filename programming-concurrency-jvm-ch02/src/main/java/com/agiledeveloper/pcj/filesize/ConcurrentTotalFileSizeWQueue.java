package com.agiledeveloper.pcj.filesize;

import java.io.File;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConcurrentTotalFileSizeWQueue {

    private ExecutorService service;
    final private BlockingQueue<Long> fileSizes = new ArrayBlockingQueue<>(500);
    final AtomicLong pendingFileVisits = new AtomicLong();
    
    private void startExploreDir(final File file) {
        pendingFileVisits.incrementAndGet();
        service.execute(() -> {
            exploreDir(file);
        });
    }
    
    private void exploreDir(final File file) {
        long fileSize = 0;
        if(file.isFile()) {
            fileSize = file.length();
        } else {
            final File[] children = file.listFiles();
            if(children != null) {
                for(final File child : children) {
                    if(child.isFile()) {
                        fileSize += child.length();
                    } else {
                        startExploreDir(child);
                    }
                }
            }
        }
        
        try {
            fileSizes.put(fileSize);
        } catch (InterruptedException ex) {
            Logger.getLogger(ConcurrentTotalFileSizeWQueue.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException(ex);
        }
        
        pendingFileVisits.decrementAndGet();
    }
    
    private long getTotalSizeOfFile(final String fileName) throws InterruptedException {
        
        service = Executors.newFixedThreadPool(100);
        
        try {
            startExploreDir(new File(fileName));
            long totalSize = 0;
            while(pendingFileVisits.get() > 0 || fileSizes.size() > 0) {
                final long size = fileSizes.poll(10, TimeUnit.SECONDS);
                totalSize += size;
            }
            
            return totalSize;
        } finally {
            service.shutdown();
        }
    }
    
    public static void main(String[] args) throws InterruptedException {
        final long start = System.nanoTime();
        final long total = new ConcurrentTotalFileSizeWQueue().getTotalSizeOfFile("D:\\softwares");
        final long end = System.nanoTime();
        System.out.println("Total Size: " + total);
        System.out.println("Time taken: " + (end - start) / 1.0e9);
    }
}
