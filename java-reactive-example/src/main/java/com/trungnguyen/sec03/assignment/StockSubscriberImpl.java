package com.trungnguyen.sec03.assignment;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StockSubscriberImpl implements Subscriber<Integer> {

    private static final Logger logger = LoggerFactory.getLogger(StockSubscriberImpl.class);

    private static int QUANTITY = 0;

    private static int BALANCE = 1000;

    private Subscription subscription;

    public Subscription getSubscription() {
        return subscription;
    }

    @Override
    public void onSubscribe(Subscription subscription) {
        this.subscription = subscription;
    }

    @Override
    public void onNext(Integer price) {
        logger.info("Received price : {}", price);
        if (price <= 90 && BALANCE >= price) {
            QUANTITY++;
            BALANCE = BALANCE - price;
        } else if (price >= 110) {
            int profit = BALANCE + QUANTITY * price;
            logger.info("Total profit : {}", profit);
            subscription.cancel();
        }
    }

    @Override
    public void onError(Throwable throwable) {
        logger.error("Error", throwable);
    }

    @Override
    public void onComplete() {
        logger.info("Completed");
    }
}
