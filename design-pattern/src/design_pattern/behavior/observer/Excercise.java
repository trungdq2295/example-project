package design_pattern.behavior.observer;

import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Excercise {

    public static void main(String[] args) {
        Game game = new Game();
        try(
                Rat rat1 = new Rat(game);
                Rat rat2 = new Rat(game);
                ){
            System.out.println(game);
            System.out.println(rat1);
            System.out.println(rat2);
        }catch (Exception e){

        }
    }
}


class Game
{
    public List<Rat> listRat = new ArrayList();
    public int attackCount = 0;

    public void addRat(Rat rat){
        listRat.add(rat);
        attackCount++;
        updateAttack();
    }


    public void removeRat(Rat rat){
        this.listRat.remove(rat);
        attackCount--;
        updateAttack();
    }

    private void updateAttack(){
        System.out.println("attackCount " + attackCount);
        for(Rat rat: this.listRat){
            rat.setAttackValue(attackCount);
        }
    }

    @Override
    public String toString() {
        return "Game{" +
                "listRat=" + listRat +
                ", attackCount=" + attackCount +
                '}';
    }

    // todo
}

class Rat implements Closeable
{
    private Game game;
    public int attack = 1;

    public Rat(Game game)
    {
        this.game = game;
        this.game.addRat(this);
    }

    public void setAttackValue(int value) {
        attack = value;
    }


    @Override
    public void close() throws IOException
    {
        this.game.removeRat(this);
        // todo: rat dies ;(
    }

    @Override
    public String toString() {
        return "Rat{" +
                "attack=" + attack +
                '}';
    }
}
