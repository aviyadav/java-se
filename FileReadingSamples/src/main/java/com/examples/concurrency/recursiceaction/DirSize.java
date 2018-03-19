package com.examples.concurrency.recursiceaction;

import java.io.File;
import java.util.Objects;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DirSize {

    public static class SizeOfFileAcion extends RecursiveAction {

        private final File file;
        private final AtomicLong sizeAccumulator;

        public SizeOfFileAcion(File file, AtomicLong sizeAccumulator) {
            this.file = Objects.requireNonNull(file);
            this.sizeAccumulator = Objects.requireNonNull(sizeAccumulator);
        }

        @Override
        protected void compute() {
            Logger.getLogger(DirSize.class.getName()).log(Level.INFO, "Computing size of {0}", file);

            if (file.isFile()) {
                sizeAccumulator.addAndGet(file.length());
            } else {
                final File[] children = file.listFiles();
                if (children != null) {
                    for (File child : children) {
                        ForkJoinTask.invokeAll(new SizeOfFileAcion(child, sizeAccumulator));
                    }
                }
            }
        }
    }

    public static long sizeOf(final File file) {
        final ForkJoinPool pool = new ForkJoinPool();
        try {
            final AtomicLong sizeAccumulator = new AtomicLong();
            pool.invoke(new SizeOfFileAcion(file, sizeAccumulator));
            return sizeAccumulator.get();
        } finally {
            pool.shutdown();
        }
    }
}
