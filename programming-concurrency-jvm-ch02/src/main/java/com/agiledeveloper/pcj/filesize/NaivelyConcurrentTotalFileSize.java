package com.agiledeveloper.pcj.filesize;

import java.io.File;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.TimeUnit;

public class NaivelyConcurrentTotalFileSize {

    private long getTotalSizeOfFilesInDir(final ExecutorService service, final File file) throws InterruptedException, ExecutionException, TimeoutException {
        if (file.isFile()) {
            return file.length();
        }

        long total = 0;
        final File[] children = file.listFiles();

        if (children != null) {
            final List<Future<Long>> partialTotalFutures = new ArrayList<>();
            for (final File child : children) {
                partialTotalFutures.add(service.submit(() -> getTotalSizeOfFilesInDir(service, child)));
            }

            for (final Future<Long> partialTotalFuture : partialTotalFutures) {
                total += partialTotalFuture.get(100, TimeUnit.SECONDS);
//                total += partialTotalFuture.get();
            }
        }

        return total;
    }

    private long getTotalSizeOfFile(final String fileName) throws InterruptedException, ExecutionException, TimeoutException {
////        final int numberOfCores = Runtime.getRuntime().availableProcessors();
////        final double blockingCoefficient = 0.9;
////        final int poolSize = (int) (numberOfCores / (1 - blockingCoefficient));
        
        final ExecutorService service = Executors.newFixedThreadPool(100);
        try {
            return getTotalSizeOfFilesInDir(service, new File(fileName));
        } finally {
            service.shutdown();
        }
    }

    public static void main(final String[] args) throws InterruptedException, ExecutionException, TimeoutException {
//        System.setProperty("java.net.useSystemProxies", "true");
        final long start = System.nanoTime();
        final long total = new NaivelyConcurrentTotalFileSize().getTotalSizeOfFile("D:\\Users\\703175276\\Documents");
        final long end = System.nanoTime();
        System.out.println("Total Size: " + total);
        System.out.println("Time taken: " + (end - start) / 1.0e9);
    }
}
