package com.trungnguyen.sec03.assignment;

import com.trungnguyen.common.AbstractHttpClient;
import com.trungnguyen.common.Util;
import reactor.core.publisher.Flux;

public class ExternalAssignmentServiceClient extends AbstractHttpClient {

    public Flux<Integer> getStockPrices() {
        return this.httpClient.get()
                .uri("/demo02/stock/stream")
                .responseContent()
                .asString()
                .map(Integer::parseInt);
    }

    public static void main(String[] args) {
        var client = new ExternalAssignmentServiceClient();
        var subscriber = new StockSubscriberImpl();
        client.getStockPrices()
                .subscribe(subscriber);
        subscriber.getSubscription().request(Long.MAX_VALUE);


        Util.sleepSeconds(100);
    }
}
