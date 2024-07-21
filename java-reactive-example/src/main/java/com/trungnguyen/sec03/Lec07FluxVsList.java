package com.trungnguyen.sec03;

import com.trungnguyen.common.Util;
import com.trungnguyen.sec01.subscriber.SubscriberImpl;
import com.trungnguyen.sec03.helper.NameGenerator;

public class Lec07FluxVsList {

    public static void main(String[] args) {
//        var list = NameGenerator.getNames(10);
//        System.out.println(list);
        var subscriber = new SubscriberImpl();
        NameGenerator.getNamesFlux(10)
                .subscribe(subscriber);

        subscriber.getSubscription().request(3);
        for (int i =0; i< 5;i++){
            System.out.println("Hello world");
        }
        Util.sleepSeconds(5);

    }
}
