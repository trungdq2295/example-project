package design_pattern.behavior.template.methods;


import java.util.Objects;

/**
 * Template Method Coding Exercise
 * Imagine a typical collectible card game which has cards representing creatures. Each creature has two values: Attack and Health. Creatures can fight each other, dealing their Attack damage, thereby reducing their opponent's health.
 * <p>
 * The class CardGame implements the logic for two creatures fighting one another. However, the exact mechanics of how damage is dealt is different:
 * <p>
 * TemporaryCardDamageGame : In some games (e.g., Magic: the Gathering), unless the creature has been killed, its health returns to the original value at the end of combat.
 * PermanentCardDamageGame : In other games (e.g., Hearthstone), health damage persists.
 * You are asked to implement classes TemporaryCardDamageGame  and PermanentCardDamageGame  that would allow us to simulate combat between creatures.
 * <p>
 * Some examples:
 * <p>
 * With temporary damage, creatures 1/2 and 1/3 can never kill one another. With permanent damage, second creature will win after 2 rounds of combat.
 * With either temporary or permanent damage, two 2/2 creatures kill one another.
 */
public class Excercise {

    public static void main(String[] args) {
        Creature[] creatures = new Creature[]{
                new Creature(1,4),
                new Creature(2,3)
        };
        CardGame cardGame = new PermanentCardDamageGame(creatures);
        System.out.println(cardGame.combat(0,1));
    }
}

class Creature {
    public int attack, health;

    public Creature(int attack, int health) {
        this.attack = attack;
        this.health = health;
    }
}

abstract class CardGame {
    public Creature[] creatures;

    public CardGame(Creature[] creatures) {
        this.creatures = creatures;
    }

    // returns -1 if no clear winner (both alive or both dead)
    public int combat(int creature1, int creature2) {
        Creature first = creatures[creature1];
        Creature second = creatures[creature2];
        while (first.health > 0 && second.health > 0) {
            hit(first, second);
            hit(second, first);
        }
        return first.health > 0 ? creature1 : creature2;

    }

    // attacker hits other creature
    protected abstract void hit(Creature attacker, Creature other);
}

class TemporaryCardDamageGame extends CardGame {
    public TemporaryCardDamageGame(Creature[] creatures) {
        super(creatures);
    }

    @Override
    protected void hit(Creature attacker, Creature other) {
        if(attacker.attack != other.attack){
            other.health -= attacker.attack;
        }
    }
    // todo
}

class PermanentCardDamageGame extends CardGame {
    public PermanentCardDamageGame(Creature[] creatures) {
        super(creatures);
    }

    @Override
    protected void hit(Creature attacker, Creature other) {
        other.health -= attacker.attack;
    }
    // todo
}
