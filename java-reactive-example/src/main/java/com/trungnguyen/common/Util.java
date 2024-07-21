package com.trungnguyen.common;

import com.github.javafaker.Faker;
import com.trungnguyen.common.subscriber.DefaultSubscriberImpl;
import org.reactivestreams.Subscriber;

import java.time.Duration;

public class Util {

    private static final Faker faker = Faker.instance();


    public static <T> Subscriber<T> subscriber() {
        return new DefaultSubscriberImpl<T>("");
    }

    public static <T> Subscriber<T> subscriber(String name) {
        return new DefaultSubscriberImpl<T>(name);
    }

    public static Faker faker() {
        return faker;
    }

    public static void sleepSeconds(int seconds) {
        try {
            Thread.sleep(Duration.ofSeconds(seconds));
        } catch (Exception e) {

        }
    }
}
