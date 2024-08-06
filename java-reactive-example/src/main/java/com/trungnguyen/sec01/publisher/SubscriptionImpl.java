package com.trungnguyen.sec01.publisher;

import com.github.javafaker.Faker;
import com.trungnguyen.sec01.subscriber.SubscriberImpl;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SubscriptionImpl implements Subscription {

    private static final Logger log = LoggerFactory.getLogger(SubscriberImpl.class);

    private static final int MAX_ITEMS = 1;

    private Subscriber<? super String> subscriber;
    private boolean isCancelled;
    private int count = 0;

    private final Faker faker;

    public SubscriptionImpl(Subscriber<? super String> subscriber) {
        this.subscriber = subscriber;
        this.faker = Faker.instance();
    }

    @Override
    public void request(long requested) {
        if (isCancelled) {
            return;
        }
        log.info("Subscriber has requested {} items", requested);
        if (requested > MAX_ITEMS) {
            this.subscriber.onError(new RuntimeException("Exception "));
            this.isCancelled = true;
            return;
        }
        for (int i = 0; i < requested && count < MAX_ITEMS; i++) {
            count++;
            this.subscriber.onNext(this.faker.internet().emailAddress());
        }
        if (count == MAX_ITEMS) {
            log.info("No more data to produce");
            this.subscriber.onComplete();
            this.isCancelled = true;
        }
    }

    @Override
    public void cancel() {
        log.info("subscriber has canceled");
        this.isCancelled = true;
    }
}
