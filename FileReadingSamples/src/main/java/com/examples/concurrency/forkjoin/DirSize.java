package com.examples.concurrency.forkjoin;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DirSize {
    private static final Logger LOG = Logger.getLogger(DirSize.class.getName());
    
    private static class SizeOfFileTask extends RecursiveTask<Long> {
        
        private final File file;

        public SizeOfFileTask(final File file) {
            this.file = Objects.requireNonNull(file);
        }

        @Override
        protected Long compute() {
            LOG.log(Level.FINE, "Computing size of {0}", file);
            
            if(file.isFile()) {
                return file.length();
            }
            
            final List<SizeOfFileTask> tasks = new ArrayList<>();
            final File[] children = file.listFiles();
            if(children != null) {
                for (final File child : children) {
                    final SizeOfFileTask task = new SizeOfFileTask(child);
                    task.fork();
                    tasks.add(task);
                }
            }
            
            long size = 0;
            
            for (final SizeOfFileTask task : tasks) {
                size += task.join();
            }
            
            return size;
        }
    }
    
    public static long sizeOf(final File file) {
        final ForkJoinPool pool = new ForkJoinPool();
        
        try {
            return pool.invoke(new SizeOfFileTask(file));
        } finally {
            pool.shutdown();
        }
    }

    private DirSize() {
    }
}
