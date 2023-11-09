package design_pattern.behavior.mediator;

import java.util.ArrayList;
import java.util.List;

public class Excercise {

    public static void main(String[] args) {
        Mediator mediator = new Mediator();
        Participant participant1 = new Participant(mediator);
        Participant participant2 = new Participant(mediator);
        Participant participant3 = new Participant(mediator);

        participant1.say(2);
        participant3.say(4);
        mediator.participantList.stream().forEach(System.out::println);
    }
}


class Participant {

    public int value;

    public Mediator mediator;

    public Participant(Mediator mediator) {
        this.value = 0;
        this.mediator = mediator;
        mediator.participantList.add(this);
        // todo
    }

    public void say(int n) {
        for (Participant participant : mediator.participantList) {
            if (!this.equals(participant)) {
                participant.value = n;
            }
        }
    }

    @Override
    public String toString() {
        return "Participant{" +
                "value=" + value +
                '}';
    }
}

class Mediator {
    public List<Participant> participantList = new ArrayList<>();


    // todo
}
