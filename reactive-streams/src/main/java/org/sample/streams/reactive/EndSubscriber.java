package org.sample.streams.reactive;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Flow;
import java.util.concurrent.atomic.AtomicInteger;

public class EndSubscriber<T> implements Flow.Subscriber<T> {

    private final AtomicInteger howMuchMessagesToConsume;
    private Flow.Subscription subscription;
    public List<T> consumedElements = new LinkedList<T>();

    public EndSubscriber(Integer howMuchMessagesToConsume) {
        this.howMuchMessagesToConsume = new AtomicInteger(howMuchMessagesToConsume);
    }

    public void onSubscribe(Flow.Subscription subscription) {
        this.subscription = subscription;
        subscription.request(1);
    }

    public void onNext(T item) {
        howMuchMessagesToConsume.decrementAndGet();
        System.out.println("Got : " + item);
        consumedElements.add(item);
        if(howMuchMessagesToConsume.get() > 0) {
            subscription.request(1);
        }
    }

    public void onError(Throwable throwable) {
        throwable.printStackTrace();
    }

    public void onComplete() {
        System.out.println("Done");
    }
}
