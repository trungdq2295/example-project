package com.trungnguyen.sec03;

import com.trungnguyen.common.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lec09FluxInterval {

    public static void main(String[] args) {
        Flux.interval(Duration.ofMillis(500))
                .map( i -> Util.faker().name().firstName())
                .subscribe(Util.subscriber());
        Util.sleepSeconds(5);
    }
}
