package com.agiledeveloper.pcj.prime;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConcurrentPrimeFinder extends AbstractPrimeFinder {

    private final int poolSize;
    private final int numberOfParts;

    public ConcurrentPrimeFinder(final int poolSize, final int numberOfParts) {
        this.poolSize = poolSize;
        this.numberOfParts = numberOfParts;
    }

    @Override
    public int countPrimes(final int number) {
        
        int count = 0;
        
        try {
            final List<Callable<Integer>> partitions = new ArrayList<>();
            final int chunksPerPartition = number / numberOfParts;
            for (int i = 0; i < numberOfParts; i++) {
                final int lower = i * chunksPerPartition + 1;
                final int upper = (i == numberOfParts - 1) ? number : lower + chunksPerPartition - 1;

                partitions.add((Callable<Integer>) () -> countPrimesInRange(lower, upper));
            }

            final ExecutorService executorPool = Executors.newFixedThreadPool(poolSize);
            final List<Future<Integer>> resultFromParts = executorPool.invokeAll(partitions, 10000, TimeUnit.SECONDS);
            
            executorPool.shutdown();
            
            for (final Future<Integer> results : resultFromParts) {
                count += results.get();
            }
        } catch (InterruptedException | ExecutionException ex) {
            Logger.getLogger(ConcurrentPrimeFinder.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException(ex);
        }
        
        return count;
    }
    
    public static void main(String[] args) {
        new ConcurrentPrimeFinder(4, 4).timeAndCompute(10000000);
    }
}
