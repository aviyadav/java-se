package com.agiledeveloper.pcj.filesize;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ConcurrentTotalFileSize {

    class SubDirectoriesAndSize {

        final public long size;
        final public List<File> subDirectories;

        public SubDirectoriesAndSize(final long totalSize, final List<File> theSubDirs) {
            this.size = totalSize;
            this.subDirectories = Collections.unmodifiableList(theSubDirs);
        }
    }

    private SubDirectoriesAndSize getTotalAndSubDirs(final File file) {
        long total = 0;
        final List<File> subDirectories = new ArrayList<>();
        if (file.isDirectory()) {
            final File[] children = file.listFiles();
            if (children != null) {
                for (final File child : children) {
                    if (child.isFile()) {
                        total += child.length();
                    } else {
                        subDirectories.add(child);
                    }
                }
            }
        }

        return new SubDirectoriesAndSize(total, subDirectories);
    }

    private long getTotalSizeOfFilesInDir(final File file) throws InterruptedException, ExecutionException, TimeoutException {
        final ExecutorService service = Executors.newFixedThreadPool(100);
        try {
            long total = 0;
            final List<File> directories = new ArrayList<>();
            directories.add(file);
            while (!directories.isEmpty()) {
                final List<Future<SubDirectoriesAndSize>> partialResults = new ArrayList<>();
                directories.forEach((directory) -> {
                    partialResults.add(service.submit(() -> getTotalAndSubDirs(directory)));
                });

                directories.clear();
                for (final Future<SubDirectoriesAndSize> partialResultFuture : partialResults) {
                    final SubDirectoriesAndSize subDirectoriesAndSize = partialResultFuture.get(100, TimeUnit.SECONDS);
                    directories.addAll(subDirectoriesAndSize.subDirectories);
                    total += subDirectoriesAndSize.size;
                }
            }

            return total;
        } finally {
            service.shutdown();
        }
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        final long start = System.nanoTime();
//        final long total = new ConcurrentTotalFileSize().getTotalSizeOfFilesInDir(new File("D:\\Users\\703175276\\Documents"));
        final long total = new ConcurrentTotalFileSize().getTotalSizeOfFilesInDir(new File("D:\\softwares"));
        final long end = System.nanoTime();
        System.out.println("Total Size: " + total);
        System.out.println("Time taken: " + (end - start) / 1.0e9);
    }
}
