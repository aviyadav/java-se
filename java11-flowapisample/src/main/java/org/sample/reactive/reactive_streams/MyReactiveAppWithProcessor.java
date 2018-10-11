package org.sample.reactive.reactive_streams;

import org.sample.reactive.bean.Employee;
import org.sample.reactive.bean.Freelancer;

import java.util.List;
import java.util.concurrent.SubmissionPublisher;

public class MyReactiveAppWithProcessor {

    public static void main(String[] args) throws InterruptedException {
        SubmissionPublisher<Employee> publisher = new SubmissionPublisher<>();
        MyProcessor transformProcessor = new MyProcessor(s -> {
            return new Freelancer(s.getId(), s.getName(), s.getId() + 100);
        });

        MyFreelancerSubscriber subs = new MyFreelancerSubscriber();
        publisher.subscribe(transformProcessor);
        transformProcessor.subscribe(subs);

        List<Employee> employees = EmpHelper.getEmps();
        System.out.println("Publishing Items to Subscriber");
        employees.stream().forEach(i -> publisher.submit(i));

        while(employees.size() != subs.getCounter()) {
            Thread.sleep(10);
        }

        publisher.close();
        transformProcessor.close();

        System.out.println("Exiting the app");
    }
}
