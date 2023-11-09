package design_pattern.behavior.responsibility;//package design_pattern.structure.chain.of.responsibility;
//
//import java.util.HashMap;
//import java.util.Map;
//import java.util.function.Consumer;
//
//public class BrokerChainDemo {
//
//    public static void main(String[] args) {
//        Game game = new Game();
//        CreatureAbc goblin = new CreatureAbc(game, "Strong goblin", 2, 2);
//        System.out.println(goblin);
//        IncreaseDefenseModifierAbc icm = new IncreaseDefenseModifierAbc(game, goblin);
//        DoubleAttackModifierAbc dam = new DoubleAttackModifierAbc(game, goblin);
//        try(dam) {
//            System.out.println(goblin);
//        } catch (Exception e) {
//
//        }
//        System.out.println(goblin);
//    }
//}
//
//class Event<Args> {
//
//    private int index = 0;
//    private Map<Integer, Consumer<Args>> handlers = new HashMap<>();
//
//    public int subscribe(Consumer<Args> handler) {
//        int i = index;
//        handlers.put(index++, handler);
//        return i;
//    }
//
//    public void unsubscribe(int key) {
//        handlers.remove(key);
//    }
//
//    public void fire(Args args) {
//        for (Consumer<Args> handler : handlers.values()) {
//            handler.accept(args);
//        }
//    }
//}
//
//class Query {
//    public String creatureNames;
//
//    enum Argument {
//        ATTACK, DEFENSE;
//    }
//
//    public Argument argument;
//
//    public int result;
//
//    public Query(String creatureNames, Argument argument, int result) {
//        this.creatureNames = creatureNames;
//        this.argument = argument;
//        this.result = result;
//    }
//}
//
//class Game {
//    public Event<Query> queries = new Event<>();
//}
//
//class CreatureAbc {
//    private Game game;
//
//    public String name;
//
//    public int baseAttack, baseDefense;
//
//    public CreatureAbc(Game game, String name, int baseAttack, int baseDefense) {
//        this.game = game;
//        this.name = name;
//        this.baseAttack = baseAttack;
//        this.baseDefense = baseDefense;
//    }
//
//    public int getAttack() {
//        Query query = new Query(name, Query.Argument.ATTACK, baseAttack);
//        game.queries.fire(query);
//        return query.result;
//    }
//
//    public int getDefense() {
//        Query query = new Query(name, Query.Argument.DEFENSE, baseDefense);
//        game.queries.fire(query);
//        return query.result;
//    }
//
//    @Override
//    public String toString() {
//        return "CreatureAbc{" +
//                "name='" + name + '\'' +
//                ", baseAttack=" + getAttack() +
//                ", baseDefense=" + getDefense() +
//                '}';
//    }
//}
//
//class CreatureModiferAbc {
//    protected Game game;
//    protected CreatureAbc creatureAbc;
//
//    public CreatureModiferAbc(Game game, CreatureAbc creatureAbc) {
//        this.game = game;
//        this.creatureAbc = creatureAbc;
//    }
//}
//
//
//class IncreaseDefenseModifierAbc extends CreatureModiferAbc implements AutoCloseable {
//    private final int token;
//
//    public IncreaseDefenseModifierAbc(Game game, CreatureAbc creatureAbc) {
//        super(game, creatureAbc);
//        token = game.queries.subscribe(q -> {
//            if (q.creatureNames.equals(creatureAbc.name)
//                    && q.argument == Query.Argument.DEFENSE
//            ) {
//                q.result += 3;
//            }
//        });
//    }
//
//    @Override
//    public void close() /*throws Exception */ {
//        game.queries.unsubscribe(token);
//    }
//}
//
//class DoubleAttackModifierAbc extends CreatureModiferAbc implements AutoCloseable {
//    private final int token;
//
//    public DoubleAttackModifierAbc(Game game, CreatureAbc creatureAbc) {
//        super(game, creatureAbc);
//        token = game.queries.subscribe(q -> {
//            if (q.creatureNames.equals(creatureAbc.name)
//                    && q.argument == Query.Argument.ATTACK
//            ) {
//                q.result *= 2;
//            }
//        });
//    }
//
//    @Override
//    public void close() /*throws Exception */ {
//        game.queries.unsubscribe(token);
//    }
//}