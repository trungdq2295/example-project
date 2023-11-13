//package design_pattern.behavior.visitor;
//
//
//public class ClassicVisitorDemo {
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
//        ExpressionPrinter ep = new ExpressionPrinter();
//        e.accept(ep);
//        System.out.println(ep);
//
//        ExpressionCalculator calculator = new ExpressionCalculator();
//        e.accept(calculator);
//        System.out.println(calculator.result);
//    }
//}
//
//abstract class Expression {
//    public abstract void accept(ExpressionVisitor visitor);
//}
//
//class DoubleExpression extends Expression {
//    public double value;
//
//    public DoubleExpression(double value) {
//        this.value = value;
//    }
//
//
//    @Override
//    public void accept(ExpressionVisitor visitor) {
//        visitor.visit(this);
//    }
//}
//
//class AdditionExpression extends Expression {
//    public Expression left, right;
//
//    public AdditionExpression(Expression left, Expression right) {
//        this.left = left;
//        this.right = right;
//    }
//
//    @Override
//    public void accept(ExpressionVisitor visitor) {
//        visitor.visit(this);
//    }
//}
////
////class ExpressionPrinter {
////    public static void print(Expression e, StringBuilder sb) {
////        if (e.getClass() == DoubleExpression.class) {
////            sb.append(((DoubleExpression) e).value);
////        } else if (e.getClass() == AdditionExpression.class) {
////            AdditionExpression ae = (AdditionExpression) e;
////            sb.append("(");
////            print(ae.left, sb);
////            sb.append("+");
////            print(ae.right, sb);
////            sb.append(")");
////        }
////    }
////}
//
//interface ExpressionVisitor {
//    void visit(DoubleExpression e);
//
//    void visit(AdditionExpression e);
//}
//
//class ExpressionPrinter implements ExpressionVisitor {
//
//    private StringBuilder sb = new StringBuilder();
//
//    @Override
//    public void visit(DoubleExpression e) {
//        sb.append(e.value);
//    }
//
//    @Override
//    public void visit(AdditionExpression e) {
//        sb.append("(");
//        e.left.accept(this);
//        sb.append("+");
//        e.right.accept(this);
//        sb.append(")");
//    }
//
//    public String toString() {
//        return sb.toString();
//    }
//}
//
//class ExpressionCalculator implements ExpressionVisitor {
//
//    public double result;
//
//    @Override
//    public void visit(DoubleExpression e) {
//        result = e.value;
//    }
//
//    @Override
//    public void visit(AdditionExpression e) {
//        e.left.accept(this);
//        double a = result;
//        e.right.accept(this);
//        double b = result;
//        result = a + b;
//    }
//}