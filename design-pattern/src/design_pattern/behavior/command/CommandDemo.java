package design_pattern.behavior.command;//package design_pattern.structure.command;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//
//public class CommandDemo {
//
//    public static void main(String[] args) {
//        BankAccount ba = new BankAccount();
//        System.out.println(ba);
//
//        List<BankAccountCommand> commandList = new ArrayList<>(List.of(
//                new BankAccountCommand(ba, BankAccountCommand.Action.DEPOSIT, 100),
//                new BankAccountCommand(ba, BankAccountCommand.Action.WITHDRAW, 1000)
//        ));
//
//        for (BankAccountCommand command : commandList) {
//            command.call();
//            System.out.println(ba);
//        }
//
//        Collections.reverse(commandList);
//        for (BankAccountCommand command : commandList) {
//            command.undo();
//            System.out.println(ba);
//        }
//    }
//}
//
//class BankAccount {
//    private int balance;
//
//    private int overDraftLimit = -500;
//
//    public void deposit(int amount) {
//        balance += amount;
//        System.out.println("Deposited " + amount + ", balance is now " + balance);
//    }
//
//    public boolean withdraw(int amount) {
//        if (balance >= amount) {
//            balance -= amount;
//            System.out.println("Withdrew " + amount + ", balance is now " + balance);
//            return true;
//        }
//        return false;
//    }
//
//    @Override
//    public String toString() {
//        return "BankAccount{" +
//                "balance=" + balance +
//                '}';
//    }
//}
//
//interface Command {
//    void call();
//
//    void undo();
//}
//
//class BankAccountCommand implements Command {
//    private BankAccount account;
//    private boolean succeed;
//
//    public enum Action {
//        DEPOSIT, WITHDRAW
//    }
//
//    private Action action;
//    private int amount;
//
//    public BankAccountCommand(BankAccount account, Action action, int amount) {
//        this.account = account;
//        this.action = action;
//        this.amount = amount;
//    }
//
//    @Override
//    public void call() {
//        switch (this.action) {
//            case DEPOSIT:
//                succeed = true;
//                account.deposit(amount);
//                break;
//            case WITHDRAW:
//                succeed = account.withdraw(amount);
//                break;
//        }
//    }
//
//    @Override
//    public void undo() {
//        if (!succeed) {
//            return;
//        }
//        switch (this.action) {
//            case DEPOSIT:
//                account.withdraw(amount);
//                break;
//            case WITHDRAW:
//                account.deposit(amount);
//                break;
//        }
//    }
//}