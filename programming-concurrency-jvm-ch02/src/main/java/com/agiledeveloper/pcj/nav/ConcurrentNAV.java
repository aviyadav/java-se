package com.agiledeveloper.pcj.nav;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ConcurrentNAV extends AbstractNAV {

    @Override
    public double computeNetAssetValue(Map<String, Integer> stocks) throws ExecutionException, InterruptedException, IOException {
        final int numberOfCores = Runtime.getRuntime().availableProcessors();
        final double blockingCoefficient = 0.9;
        final int poolSize = (int) (numberOfCores/(1 - blockingCoefficient));
        
        System.out.println("Number of Cores available is " + numberOfCores);
        System.out.println("Pool size is " + poolSize);
        
        final List<Callable<Double>> partitions = new ArrayList<>();
        
        stocks.keySet().forEach((ticker) -> {
            partitions.add((Callable<Double>) () -> stocks.get(ticker) * YahooFinance.getPrice(ticker));
        });
        
        final ExecutorService executorPool = Executors.newFixedThreadPool(poolSize);
        final List<Future<Double>> valueOfStocks = executorPool.invokeAll(partitions, 10000, TimeUnit.SECONDS);
        
        double netAssetValue = 0.0;
        for(final Future<Double> valueOfAStock : valueOfStocks) {
            netAssetValue += valueOfAStock.get();
        }
        
        executorPool.shutdown();
        return netAssetValue;
    }
    
    public static void main(String[] args) throws ExecutionException, InterruptedException, IOException {
        System.setProperty("java.net.useSystemProxies", "true");
        new ConcurrentNAV().timeAndComputeValue();
    }
}
