package com.trungnguyen.sec02.client;

import com.trungnguyen.common.AbstractHttpClient;
import reactor.core.publisher.Mono;

public class ExternalServiceClient extends AbstractHttpClient {

    public Mono<String> getProductName(int productId){
        return this.httpClient.get()
                .uri("/demo01/product/" + productId)
                .responseContent()
                .asString()
                .next();
    }
}
