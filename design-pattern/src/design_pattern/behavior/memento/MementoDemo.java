//package design_pattern.behavior.memento;
//
//public class MementoDemo {
//    public static void main(String[] args) {
//        BankAccount bankAccount = new BankAccount(100);
//        Memento mementoDeposit50 = bankAccount.deposit(50);
//        Memento mementoDeposit25 = bankAccount.deposit(25);
//        System.out.println(bankAccount);
//        //restore
//        bankAccount.restore(mementoDeposit50);
//        System.out.println(bankAccount);
//
//        //restore 20
//        bankAccount.restore(mementoDeposit25);
//        System.out.println(bankAccount);
//    }
//
//}
//
//
//class BankAccount {
//    private int balance;
//
//    public BankAccount(int balance) {
//        this.balance = balance;
//    }
//
//    public Memento deposit(int amount) {
//        balance += amount;
//        return new Memento(balance);
//    }
//
//    public void restore(Memento memento) {
//        this.balance = memento.getBalance();
//    }
//
//    @Override
//    public String toString() {
//        return "BankAccount{" +
//                "balance=" + balance +
//                '}';
//    }
//
//
//}
//
//class Memento {
//    private int balance;
//
//    public Memento(int balance) {
//        this.balance = balance;
//    }
//
//    public int getBalance() {
//        return balance;
//    }
//
//    public void setBalance(int balance) {
//        this.balance = balance;
//    }
//}