package sec04;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class OperationWithIntegeresAndDoubles {

    public static void main(String[] args) {
        int i = 20;
        System.out.println(i / 3);
        System.out.println(i - (6 * 3));
        System.out.println((double) i / 3);

        BigDecimal rideFee = BigDecimal.valueOf(20).setScale(2);
        BigDecimal amountOfPeole = BigDecimal.valueOf(3);
        BigDecimal chargePerson = rideFee.divide(amountOfPeole, RoundingMode.HALF_UP);
        System.out.println(chargePerson);

        double d = 3.1;
        double d2 = 1.21;

        System.out.println(d - d2);

        BigDecimal d3 = BigDecimal.valueOf(3.1).setScale(3);
        BigDecimal d4 = BigDecimal.valueOf(1.21).setScale(2);
        System.out.println(d3.subtract(d4));
    }
}
