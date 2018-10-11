package org.sample.reactive.reactive_streams;

import org.sample.reactive.bean.Employee;

import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;

public class MySubscriber implements Subscriber<Employee> {

    private Subscription subscription;
    private int counter = 0;

    @Override
    public void onSubscribe(Subscription subscription) {

        System.out.println("Subscribed");
        this.subscription = subscription;
        this.subscription.request(1);
        System.out.println("OnSubscribe requested 1 item");
    }

    @Override
    public void onNext(Employee item) {
        System.out.println("Processing Employee " + item);
        counter++;
        this.subscription.request(1);
    }

    @Override
    public void onError(Throwable throwable) {
        System.out.println("Some error happened");
        throwable.printStackTrace();
    }

    @Override
    public void onComplete() {
        System.out.println("All processing Done!");
    }

    public int getCounter() {
        return counter;
    }
}
