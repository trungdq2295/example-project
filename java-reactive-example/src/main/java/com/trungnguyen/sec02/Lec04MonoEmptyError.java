package com.trungnguyen.sec02;

import com.trungnguyen.common.Util;
import reactor.core.publisher.Mono;

public class Lec04MonoEmptyError {

    public static void main(String[] args) {
        getUsername(3)
                .subscribe(
                        s -> System.out.println(s),
                        err -> {}
                );
    }

    private static Mono<String> getUsername(int userId) {
        return switch (userId) {
            case 1 -> Mono.just("Tn");
            case 2 -> Mono.empty();
            default -> Mono.error(new RuntimeException("Invalid Input"));
        };
    }
}
