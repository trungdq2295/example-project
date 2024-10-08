import java.math.BigDecimal;
import java.math.RoundingMode;

public class Main {
    public static void main(String[] args) {
        BigDecimal income = BigDecimal.valueOf(1000);
        try {
            System.out.println(calculateTax(income));
        } catch (InvalidIncomeException invalidIncomeException){
            System.out.println("Invalid income");
        } catch (Exception e) {
            System.out.println("Exception happened");
        }
    }

    private static BigDecimal calculateTax(BigDecimal income) throws InvalidIncomeException {
        if(income.compareTo(BigDecimal.ZERO) <= 0){
            throw new InvalidIncomeException();
        }
        BigDecimal MAX_NO_TAX = BigDecimal.valueOf(10_000);
        BigDecimal MAX_TEN_PERCENTAGE_TAX = BigDecimal.valueOf(20_000);
        if(income.compareTo(MAX_NO_TAX) <= 0){
            return BigDecimal.ZERO;
        } else if (income.compareTo(MAX_TEN_PERCENTAGE_TAX) <= 0) {
            return income.multiply(BigDecimal.valueOf(0.1)).setScale(2, RoundingMode.CEILING);
        } else {
            return income.multiply(BigDecimal.valueOf(0.2)).setScale(2, RoundingMode.CEILING);
        }
    }

    static class InvalidIncomeException extends Exception{

    }
}