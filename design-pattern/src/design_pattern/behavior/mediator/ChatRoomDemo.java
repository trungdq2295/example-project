package design_pattern.behavior.mediator;

import java.util.ArrayList;
import java.util.List;

public class ChatRoomDemo {

    public static void main(String[] args) {
        ChatRoom room = new ChatRoom();
        Person john = new Person("John");
        Person jane = new Person("Jane");
        room.join(john);
        room.join(jane);

        john.say("hi room");
        jane.say("oh, hey john");
    }
}

class Person {
    public String name;

    public ChatRoom room;
    private List<String> chatLog = new ArrayList<>();

    public Person(String name) {
        this.name = name;
    }

    public void receive(String sender, String message) {
        String s = sender + ": '" + message + "'";
        System.out.println("[" + name + "'s chat session] " + s);
        chatLog.add(s);
    }

    public void say(String message) {
        room.broadcast(name, message);
    }

    public void privateMessage(String who, String message) {
        room.message(name, who, message);
    }
}

class ChatRoom {

    private List<Person> people = new ArrayList<>();

    public void join(Person p) {
        String joinMsg = p.name + " joins the room";
        broadcast("room", joinMsg);
        p.room = this;
        people.add(p);
    }

    public void broadcast(String source, String message) {
        for (Person person : people) {
            if (!person.name.equals(source)) {
                person.receive(source, message);
            }
        }
    }

    public void message(String source, String desitination, String message) {
        people.stream()
                .filter(p -> p.name.equals(desitination))
                .findFirst()
                .ifPresent(person -> person.receive(source, message));
    }
}
