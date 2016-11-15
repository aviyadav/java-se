package com.agiledeveloper.pcj.nav;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
//import java.io.FileInputStream;

public class YahooFinance {

    public static double getPrice(final String ticker) throws IOException {
        
        System.setProperty("java.net.useSystemProxies", "true");
        
        final URL url = new URL("http://ichart.finance.yahoo.com/table.csv?s=" + ticker);
        final BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));

//        final String FOLDER_NAME = "D:\\temp\\";
//        String filename = "G.csv";
//        
//        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(FOLDER_NAME+filename)));
        final String discardHeader = reader.readLine();
        final String data = reader.readLine();
        final String[] dataItems = data.split(",");
        final double priceIsTheLastValue = Double.valueOf(dataItems[dataItems.length - 1]);

        return priceIsTheLastValue;
    }

    public static void main(String[] args) throws IOException {
//        System.setProperty("java.net.useSystemProxies", "true");
        System.out.println(getPrice("ORCL"));
    }
}
