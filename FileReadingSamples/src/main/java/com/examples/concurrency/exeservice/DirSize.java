package com.examples.concurrency.exeservice;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DirSize {

    private static final Logger LOG = Logger.getLogger(DirSize.class.getName());

    private static class SizeOfFileCallable implements Callable<Long> {
        
        private final File file;
        private final ExecutorService executor;

        public SizeOfFileCallable(final File file, final ExecutorService executor) {
            this.file = Objects.requireNonNull(file);
            this.executor = Objects.requireNonNull(executor);
        }

        @Override
        public Long call() throws Exception {
            LOG.log(Level.INFO, "Computing size of : {0}", file);
            long size = 0;
            
            if(file.isFile()) {
                size = file.length();
            } else {
                final List<Future<Long>> futures = new ArrayList<>();
                for (File child : file.listFiles()) {
                    futures.add(executor.submit(new SizeOfFileCallable(child, executor)));
                }
                
                for (Future<Long> future : futures) {
                    size += future.get();
                }
            }
            
            return size;
        }
    }
    
    public static <T> long sizeOf(final File file) {
        final int threads = Runtime.getRuntime().availableProcessors();
        LOG.log(Level.FINE, "Creating executor with {0} threads", threads);
        ExecutorService executor = Executors.newFixedThreadPool(threads);
        
        try {
            return executor.submit(new SizeOfFileCallable(file, executor)).get();
        } catch (InterruptedException | ExecutionException ex) {
            Logger.getLogger(DirSize.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            executor.shutdown();
        }
        
        return 0;
    }

    private DirSize() {
    }
}
