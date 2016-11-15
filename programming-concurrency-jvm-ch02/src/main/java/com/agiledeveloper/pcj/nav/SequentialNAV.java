package com.agiledeveloper.pcj.nav;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class SequentialNAV extends AbstractNAV {

    @Override
    public double computeNetAssetValue(Map<String, Integer> stocks) throws ExecutionException, InterruptedException, IOException {
        double netAssetValue = 0.0;
        for (String ticker : stocks.keySet()) {
            netAssetValue += stocks.get(ticker) * YahooFinance.getPrice(ticker);
        }
        return netAssetValue;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException, IOException {
        System.setProperty("java.net.useSystemProxies", "true");
        new SequentialNAV().timeAndComputeValue();
    }
}
