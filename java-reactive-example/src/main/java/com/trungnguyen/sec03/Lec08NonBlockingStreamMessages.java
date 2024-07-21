package com.trungnguyen.sec03;

import com.trungnguyen.common.Util;
import com.trungnguyen.sec03.client.ExternalServiceClient;

public class Lec08NonBlockingStreamMessages {


    public static void main(String[] args) {
        var client = new ExternalServiceClient();
        var flux = client.getNames();
        flux.subscribe(Util.subscriber("sub 1"));
        flux.subscribe(Util.subscriber("sub 2"));

        Util.sleepSeconds(5);
    }
}
