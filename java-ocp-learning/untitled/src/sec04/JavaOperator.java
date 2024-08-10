package sec04;

public class JavaOperator {

    public static void main(String[] args) {
        /** Unary Arithmethic Operators
         * +
         * -
         * ++
         * --
         */
        System.out.println("==== Unary Arithmethic Operators ====");
        int i = +10;
        int i2 = -10;
        int i3 = ++i;
        int i4 = i++;
        int i5 = --i;
        int i6 = i--;
        System.out.println("i = " + i);
        System.out.println("i2 = " + i2);
        System.out.println("i3 = " + i3);
        System.out.println("i4 = " + i4);
        System.out.println("i5 = " + i5);
        System.out.println("i6 = " + i6);
        System.out.println("i = " + i);
        System.out.println();

        /** Binary Arithmetic Operator
         * +
         * -
         * /
         * %
         */
        System.out.println("==== Binary Arithmethic Operators ====");

        int i7 = 10 + 1;
        int i8 = i7 - 1;
        int i9 = i8 / 2;
        int i10 = i9 % 2;
        int i11 = 5 % 10;
        int i12 = i10 * 3;

        System.out.println("i7 = " + i7);
        System.out.println("i8 = " + i8);
        System.out.println("i9 = " + i9);
        System.out.println("i10 = " + i10);
        System.out.println("i11 = " + i11);
        System.out.println("i12 = " + i12);
        System.out.println("Hello " + "World");

        /** Assignment Operator
         * =
         * +=
         * -=
         * *=
         * /=
         * %=
         */
        System.out.println("==== Assignment Operators ====");

        int i13 = 10;
        int abc = i13;
        System.out.println("i13 = " + i13);
        System.out.println("abc = " + abc);

        /** Relational Operator
         * ==
         * !=
         * <
         * >
         * >=
         * <=
         */
        System.out.println("==== Relational Operators ====");
        int i14 = 10;
        int i15 = 20;

        System.out.println(i14 == i15);
        System.out.println(i14 != i15);
        System.out.println(i14 > i15);
        System.out.println(i14 < i15);
        System.out.println(i14 >= i15);
        System.out.println(i14 <= i15);
        System.out.println();

        /** Logical Operator
         * &
         * &&
         * |
         * ||
         * |
         * ^
         */
        System.out.println("==== Logical Operators ====");

//        System.out.println(false & (5 / 0 == 0)); //Runtime Exception cuz it will check 2 condition at same time
        System.out.println(false && (5 / 0 == 0)); // Not runtime since it check the first and then second
//        System.out.println(true | (5/0 ==0)); //Runtime Exception cuz it will check 2 condition at same time
        System.out.println(true || (5 / 0 == 0));// Not runtime since it check the first and then second
        System.out.println("!true = " + !true); // false
        System.out.println(true ^ true);        // false
        System.out.println(true ^ false);       // true
        System.out.println(false ^ true);       // true
        System.out.println();

        /** Bitwise Operator
         * & - Thực hiện phép toán AND trên từng bit của số nguyên
         * ^ - Thực hiến phép toán XOR trên từng bit của số nguyên
         * | - Thực hiện phép toán OR trên từng bit của số nguyên
         * ~ - Thực hiên phép toán đảo ngược tất cả các bit của số nguyên đó: Ví dụ ( 0001 - > 1110)
         * >> - Thực hiện dịch bit sang phải nhưng giữ nguyên dấu ( số âm/dương)
         * >>> - Thực hiên dịch bit sang phải nhưng không giữ nguyên
         * <<
         */
        System.out.println("==== Bitwise Operators ====");
        System.out.println("4 & 5 = " + (4 & 5));
        /**
         *          1 0 0 ~ 4
         *          & & &
         *          1 0 1 ~ 5
         *          ----
         *          1 0 0 = 4
         */
        System.out.println("4 | 5 = " + (4 | 5));
        /**
         *          1 0 0 ~ 4
         *          | | |
         *          1 0 1 ~ 5
         *          ----
         *          1 0 1 = 5
         */
        System.out.println("4 ^ 5 = " + (4 ^ 5));
        /**
         *          1 0 0 ~ 4
         *          ^ ^ ^
         *          1 0 1 ~ 5
         *          ----
         *          0 0 1 = 1
         */
        System.out.println("~1 = " + ~1);
        System.out.println(Integer.toBinaryString(1));
        System.out.println(Integer.toBinaryString(-2));
        System.out.println((byte) 0b11111110);
        System.out.println((byte) 0b10000000);
        System.out.println((byte) 0b11000000);

        System.out.println("5 = " + 0b101);
        System.out.println("5 >> 1 = " + (0b101 >> 1));
        System.out.println((byte) 0b00001000);

        int negativeValue = 0b11111111111111111111111111110000;
        System.out.println("-128 = " + negativeValue);                  //11111111111111111111111111110000
        System.out.println("-128 >>> 1= " + (negativeValue >>> 1));    //01111111111111111111111111111000
        System.out.println("-128 >> 1= " + (negativeValue >> 1));    //11111111111111111111111111111000


        /** Ternary Operator
         * (condition) ? true expression : false expresison
         */
        System.out.println("==== Ternary Operators ====");

        System.out.println(2 > 1 ? "2 is greater than 1" : "2 is not less than one");
        System.out.println(2 < 1 ? "2 is greater than 1" : "2 is not less than one");

        /** Operator Precedence
         * (condition) ? true expression : false expresison
         */
        System.out.println("==== Ternary Operators ====");
    }
}
