package design_pattern.behavior.template.methods;

public class TemplateMethodDemo {

    public static void main(String[] args) {
        Chess chess = new Chess();
        chess.run();
    }
}


abstract class Game {
    protected int currentPlayer;

    protected final int numberOfPlayer;

    public Game(int numberOfPlayer) {
        this.numberOfPlayer = numberOfPlayer;
    }

    public void run() {
        start();
        while (!haveWinner()) {
            takeTurn();
        }
        System.out.println("Player " + getWinningPlayer() + " win");
    }

    abstract void start();

    abstract void takeTurn();

    abstract int getWinningPlayer();

    abstract boolean haveWinner();
}

class Chess extends Game {

    private int maxTunrs = 10;
    private int currentTurn = 1;

    public Chess() {
        super(2);
    }

    @Override
    void start() {
        System.out.println("Starting a game of chess...");
    }

    @Override
    void takeTurn() {
        System.out.println("Turn " + (currentTurn++) + " taken by player " + currentPlayer);
        currentPlayer = (currentPlayer + 1) % numberOfPlayer;
    }

    @Override
    int getWinningPlayer() {
        return 0;
    }

    @Override
    boolean haveWinner() {
        return currentTurn == maxTunrs;
    }
}