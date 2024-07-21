package com.trungnguyen.sec03;

import com.trungnguyen.common.Util;
import reactor.core.publisher.Flux;

import java.util.List;

public class Lec01FluxJust {

    public static void main(String[] args) {
        Flux.just(1,2,3,"TN")
                .subscribe(Util.subscriber());


    }
}
