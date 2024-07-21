package com.trungnguyen.sec02;

import com.trungnguyen.common.Util;
import com.trungnguyen.sec02.client.ExternalServiceClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Lec11NonBlockingIo {

    private static final Logger log = LoggerFactory.getLogger(Lec11NonBlockingIo.class);
    public static void main(String[] args) {
        var client = new ExternalServiceClient();
        log.info("starting");
        for (int i = 0; i <= 5; i++) {
            client.getProductName(i)
                    .block();
//                    .subscribe(Util.subscriber());
        }

        Util.sleepSeconds(2);

    }
}
