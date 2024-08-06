package com.trungnguyen.sec02;

import org.reactivestreams.Publisher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

public class Lec03MonoSubscriber {
    private static final Logger log = LoggerFactory.getLogger(Lec03MonoSubscriber.class);

    public static void main(String[] args) {
        var mono = Mono.just(1)
                .map(i -> i + "a");

        // Using lambda expression
        mono.subscribe(
                i -> log.info("received: {}", i),
                err -> log.error("error", err),
                () -> log.info("completed"),
                subscription -> subscription.cancel()
        );
    }


}
