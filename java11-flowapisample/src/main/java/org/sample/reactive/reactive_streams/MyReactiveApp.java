package org.sample.reactive.reactive_streams;

import org.sample.reactive.bean.Employee;

import java.util.List;
import java.util.concurrent.SubmissionPublisher;

public class MyReactiveApp {
    public static void main(String[] args) throws InterruptedException {
        SubmissionPublisher<Employee> publisher = new SubmissionPublisher<>();
        MySubscriber subscriber = new MySubscriber();
        publisher.subscribe(subscriber);

        List<Employee> employees = EmpHelper.getEmps();
        System.out.println("Publishing Items to Subscriber");
        employees.stream().forEach(i -> publisher.submit(i));

        while (employees.size() != subscriber.getCounter()) {
            Thread.sleep(10);
        }

        publisher.close();

        System.out.println("Exiting the app");
    }
}
