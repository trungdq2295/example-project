package com.trungnguyen.sec02;

import com.trungnguyen.sec01.subscriber.SubscriberImpl;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Mono;

public class Lec02MonoJust {

    public static void main(String[] args) {
        Publisher<String> mono = Mono.just("TN");
        var subscriber = new SubscriberImpl();
        mono.subscribe(subscriber);
        subscriber.getSubscription().request(10);
        subscriber.getSubscription().request(10);
        subscriber.getSubscription().cancel();

        save(Mono.just("TN"));
    }

    private static void save(Publisher<String> publisher) {

    }
}
