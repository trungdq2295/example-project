package design_pattern.behavior.mediator;

import io.reactivex.Observable;
import io.reactivex.Observer;

import java.util.ArrayList;
import java.util.List;

public class ReactiveEventBrokerDemo {

    public static void main(String[] args) {
        EventBroker broker = new EventBroker();
        FootballPlayer nguyen = new FootballPlayer(broker, "Nguyen");
        FootballCoach coach = new FootballCoach(broker);

        nguyen.score();
        nguyen.score();
        nguyen.score();
    }
}

class EventBroker extends Observable<Integer> {

    private List<Observer<? super Integer>> observerList = new ArrayList<>();

    @Override
    protected void subscribeActual(Observer<? super Integer> observer) {
        observerList.add(observer);
    }

    public void publish(int n) {
        for (Observer<? super Integer> observer : observerList) {
            observer.onNext(n);
        }
    }
}

class FootballPlayer {
    private int goalsScored = 0;
    private EventBroker broker;

    public String name;

    public FootballPlayer(EventBroker broker, String name) {
        this.broker = broker;
        this.name = name;
    }

    public void score() {
        broker.publish(++goalsScored);
    }
}

class FootballCoach {
    public FootballCoach(EventBroker broker) {
        broker.subscribe(integer -> {
            System.out.println("Hey you scored " + integer + " goals");
        });
    }
}