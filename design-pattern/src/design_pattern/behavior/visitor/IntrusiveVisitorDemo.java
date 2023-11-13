//package design_pattern.behavior.visitor;
//
//public class IntrusiveVisitorDemo {
//
//    public static void main(String[] args) {
//        AdditionExpression e = new AdditionExpression(
//                new DoubleExpression(1),
//                new AdditionExpression(
//                        new DoubleExpression(2),
//                        new DoubleExpression(3)
//                )
//        );
//        StringBuilder sb = new StringBuilder();
//        e.print(sb);
//        System.out.println(sb.toString());
//    }
//}
//
//abstract class Expression {
//    abstract void print(StringBuilder sb);
//}
//
//class DoubleExpression extends Expression {
//    private double value;
//
//    public DoubleExpression(double value) {
//        this.value = value;
//    }
//
//    @Override
//    void print(StringBuilder sb) {
//        sb.append(value);
//    }
//}
//
//class AdditionExpression extends Expression {
//    private Expression left, right;
//
//    public AdditionExpression(Expression left, Expression right) {
//        this.left = left;
//        this.right = right;
//    }
//
//    @Override
//    void print(StringBuilder sb) {
//        sb.append("(");
//        left.print(sb);
//        sb.append("+");
//        right.print(sb);
//        sb.append(")");
//    }
//}
//
