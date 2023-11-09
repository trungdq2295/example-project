package design_pattern.behavior.nullobject;

import java.lang.reflect.Proxy;

public class NullObjectDemo {

    @SuppressWarnings("unchecked")
    public static <T> T noOp(Class<T> itf) {
        return (T) Proxy.newProxyInstance(
                itf.getClassLoader(),
                new Class<?>[]{itf},
                ((proxy, method, args) -> {
                    if (method.getReturnType().equals(Void.TYPE)) {
                        return null;
                    } else {
                        return method.getReturnType().getConstructor().newInstance();
                    }
                })
        );
    }

    public static void main(String[] args) {
//        Log consoleLog = new NullLog();
        Log log = noOp(NullLog.class);
        BankAccount bankAccount = new BankAccount(log);
        bankAccount.deposit(1);
    }

}

interface Log {
    void info(String msg);

    void warning(String msg);
}

class ConsoleLog implements Log {

    @Override
    public void info(String msg) {
        System.out.println(msg);
    }

    @Override
    public void warning(String msg) {
        System.out.println("WARNING: " + msg);
    }
}

final class NullLog implements Log {

    @Override
    public void info(String msg) {
        System.out.println(msg);
    }

    @Override
    public void warning(String msg) {

    }
}

class BankAccount {
    private Log log;

    private int balance = 0;

    public BankAccount(Log log) {
        this.log = log;
    }

    public void deposit(int amount) {
        balance += amount;
        if (log != null) {
            log.info("Deposited " + amount);
        }
    }
}
