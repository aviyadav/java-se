package org.sample.streams.reactive;

import com.jayway.awaitility.Awaitility;
import org.assertj.core.api.Java6Assertions;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.SubmissionPublisher;
import java.util.concurrent.TimeUnit;

public class ReactiveStreamsTest {

    @Test
    public void givenPublisher_whenSubscribeToIt_thenShouldConsumeAllElements() throws InterruptedException {
        //given
        SubmissionPublisher<String> publisher = new SubmissionPublisher<>();
        EndSubscriber<String> subscriber = new EndSubscriber<>(6);
        publisher.subscribe(subscriber);
        List<String> items = List.of("1", "x", "2", "x", "3", "x");

        //when
        Java6Assertions.assertThat(publisher.getNumberOfSubscribers()).isEqualTo(1);
        items.forEach(publisher::submit);
        publisher.close();

        //then

        Awaitility.await().atMost(1000, TimeUnit.MILLISECONDS).until(
                () -> Java6Assertions.assertThat(subscriber.consumedElements).containsExactlyElementsOf(items)
        );
    }

    @Test
    public void givenPublisher_whenSubscribeAndTransformElements_thenShouldConsumeAllElements() throws InterruptedException {
        //given
        SubmissionPublisher<String> publisher = new SubmissionPublisher<>();
        TransformProcessor<String, Integer> transformProcessor = new TransformProcessor<>(Integer::parseInt);
        EndSubscriber<Integer> subscriber = new EndSubscriber<>(3);
        List<String> items = List.of("1", "2", "3");
        List<Integer> expectedResult = List.of(1, 2, 3);

        //when
        publisher.subscribe(transformProcessor);
        transformProcessor.subscribe(subscriber);
        items.forEach(publisher::submit);
        publisher.close();

        //then
        Awaitility.await().atMost(1000, TimeUnit.MILLISECONDS).until(
                () -> Java6Assertions.assertThat(subscriber.consumedElements).containsExactlyElementsOf(expectedResult)
        );
    }

    @Test
    public void givenPublisher_whenRequestForOnlyOneElement_thenShouldConsumeOnlyThatOne() throws InterruptedException {
        //given
        SubmissionPublisher<String> publisher = new SubmissionPublisher<>();
        EndSubscriber<String> subscriber = new EndSubscriber<>(1);
        publisher.subscribe(subscriber);
        List<String> items = List.of("1", "x", "2", "x", "3", "x");
        List<String> expected = List.of("1");

        //when
        Java6Assertions.assertThat(publisher.getNumberOfSubscribers()).isEqualTo(1);
        items.forEach(publisher::submit);
        publisher.close();

        //then
        Awaitility.await().atMost(1000, TimeUnit.MILLISECONDS).until(
                () -> Java6Assertions.assertThat(subscriber.consumedElements).containsExactlyElementsOf(expected)
        );
    }
}
