package design_pattern.behavior.chain.of.responsibility;

import java.util.ArrayList;
import java.util.List;

public class Excercise {
}


abstract class Creature {

    protected String type = "NORMAL";
    public abstract int getAttack();

    public abstract int getDefense();
}

class Goblin extends Creature {

    private Game game;

    protected int attack = 0;
    protected int defense = 0;



    public Goblin(Game gameExcercise) {
        this.attack = 1;
        this.defense = 1;
        this.game = gameExcercise;
    }

    public Goblin(Game gameExcercise, int attack, int defense, String type) {
        this.attack = attack;
        this.defense = defense;
        this.game = gameExcercise;
        this.type = type;
    }

    @Override
    public int getAttack() {
        int result = game.creatures.stream().filter(creature -> creature.type.equals("KING")).findFirst().isPresent() ? this.attack + 3 : this.attack;
        return result;
    }

    @Override
    public int getDefense() {
        return defense + game.creatures.size() - 1;
    }
}

class GoblinKing extends Goblin {
    public GoblinKing(Game gameExcercise) {
        super(gameExcercise, 3, 3, "KING");
    }
}

enum Statistic {
    ATTACK, DEFENSE
}


class Game {
    public List<Creature> creatures = new ArrayList<>();
}


class Query {
    public String creatureNames;
    public Statistic argument;

    public int result;

    public Query(String creatureNames, Statistic argument, int result) {
        this.creatureNames = creatureNames;
        this.argument = argument;
        this.result = result;
    }
}

