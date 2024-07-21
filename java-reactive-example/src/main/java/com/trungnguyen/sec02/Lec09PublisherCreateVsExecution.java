package com.trungnguyen.sec02;

import com.trungnguyen.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

import java.util.concurrent.CompletableFuture;

public class Lec09PublisherCreateVsExecution {

    private static final Logger log = LoggerFactory.getLogger(Lec09PublisherCreateVsExecution.class);

    public static void main(String[] args) throws InterruptedException {
        getName();
//                .subscribe(Util.subscriber());
    }

    private static Mono<String> getName() {
        log.info("entered");
        return Mono.fromSupplier(() -> {
            log.info("Generating name");
            return Util.faker().name().firstName();
        });
    }


}
