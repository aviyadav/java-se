package org.sample.reactive.reactive_streams;

import org.sample.reactive.bean.Employee;
import org.sample.reactive.bean.Freelancer;

import java.util.concurrent.Flow.Subscription;
import java.util.concurrent.Flow.Processor;
import java.util.concurrent.SubmissionPublisher;
import java.util.function.Function;

public class MyProcessor extends SubmissionPublisher<Freelancer> implements Processor<Employee, Freelancer> {

    private Subscription subscription;
    private Function<Employee, Freelancer> function;

    public MyProcessor(Function<Employee, Freelancer> function) {
        super();
        this.function = function;
    }

    @Override
    public void onSubscribe(Subscription subscription) {
        this.subscription = subscription;
        subscription.request(1);
    }

    @Override
    public void onNext(Employee item) {
        submit((Freelancer) function.apply(item));
        subscription.request(1);
    }

    @Override
    public void onError(Throwable throwable) {
        throwable.printStackTrace();
    }

    @Override
    public void onComplete() {
        System.out.println("Done");
    }
}
