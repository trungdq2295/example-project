package exception;

public class Example {
}

class LowBalanceException extends WithdrawalException {
    public LowBalanceException(String msg) {
        super(msg);
    }
}

class WithdrawalException extends RuntimeException {
    public WithdrawalException(String msg) {
        super(msg);
    }
}

class Account {
    double balance;

    public void withdraw(double amount) {
        try {
            throw new LowBalanceException("Not Implemented");
        } catch (WithdrawalException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static void main(String[] args) {
        try {
            Account a = new Account();
            a.withdraw(100.0);
        } catch (WithdrawalException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}