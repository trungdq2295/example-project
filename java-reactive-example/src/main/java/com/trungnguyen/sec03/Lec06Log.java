package com.trungnguyen.sec03;

import com.trungnguyen.common.Util;
import reactor.core.publisher.Flux;

public class Lec06Log {

    public static void main(String[] args) {
        Flux.range(1,5)
                .log("range-integer")
                .map( i -> Util.faker().name().fullName())
                .log("range-string")
                .subscribe(Util.subscriber());
    }
}
