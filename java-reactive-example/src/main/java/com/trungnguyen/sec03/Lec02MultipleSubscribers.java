package com.trungnguyen.sec03;

import com.trungnguyen.common.Util;
import reactor.core.publisher.Flux;

public class Lec02MultipleSubscribers {

    public static void main(String[] args) {
        var flux = Flux.just(1, 2, 3, 4, 5, 6);
        flux.subscribe(Util.subscriber("sub1"));
        flux
                .filter(i -> i > 7)
                .subscribe(Util.subscriber("sub2"));
        flux
                .filter(i -> i % 2 == 0)
                .map(i -> i + "a")
                .subscribe(Util.subscriber("sub3"));
    }
}
