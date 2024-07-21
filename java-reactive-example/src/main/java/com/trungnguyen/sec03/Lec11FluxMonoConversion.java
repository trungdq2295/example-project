package com.trungnguyen.sec03;

import com.trungnguyen.common.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Lec11FluxMonoConversion {

    public static void main(String[] args) {
        var flux = Flux.range(1, 10);
        flux.subscribe(
                value -> Mono.just(value).subscribe(Util.subscriber())
        );

    }

    private static void monoToFlux() {
        var mono = getUsername(3);
        save(Flux.from(mono));
    }


    private static Mono<String> getUsername(int userId) {
        return switch (userId) {
            case 1 -> Mono.just("Tn");
            case 2 -> Mono.empty();
            default -> Mono.error(new RuntimeException("Invalid Input"));
        };
    }

    private static void save(Flux<String> flux) {
        flux.subscribe(Util.subscriber());
    }
}
