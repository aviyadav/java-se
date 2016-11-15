package com.agiledeveloper.pcj.prime;

public class SequentialPrimeFinder extends AbstractPrimeFinder {

    @Override
    public int countPrimes(int number) {
        return countPrimesInRange(1, number);
    }
    
    public static void main(String[] args) {
        new SequentialPrimeFinder().timeAndCompute(10000000);
    }

}
