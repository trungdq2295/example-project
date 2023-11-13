//package design_pattern.behavior.visitor;
//
//public class AcyclicVisitorDemo {
//
//    public static void main(String[] args) {
//        AdditionExpression e = new AdditionExpression(
//                new DoubleExpression(1),
//                new AdditionExpression(
//                        new DoubleExpression(2),
//                        new DoubleExpression(3)
//                )
//        );
//
//        ExpressionPrinter ep = new ExpressionPrinter();
//        e.accept(ep);
//        System.out.println(ep.toString());
//    }
//}
//
//abstract class Expression {
//
//    public void accept(Visitor visitor) {
//        if (visitor instanceof ExpressionVisitor) {
//            ((ExpressionVisitor) visitor).visit(this);
//        }
//    }
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
//    public void accept(Visitor visitor) {
//        if (visitor instanceof DoubleExpressionVisitor) {
//            ((DoubleExpressionVisitor) visitor).visit(this);
//        }
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
//    public void accept(Visitor visitor) {
//        if (visitor instanceof AdditionExpressionVisitor) {
//            ((AdditionExpressionVisitor) visitor).visit(this);
//        }
//    }
//}
//
//interface Visitor {
//
//}
//
//interface ExpressionVisitor extends Visitor {
//    void visit(Expression e);
//}
//
//interface DoubleExpressionVisitor extends Visitor {
//    void visit(DoubleExpression e);
//}
//
//interface AdditionExpressionVisitor extends Visitor {
//    void visit(AdditionExpression e);
//}
//
//class ExpressionPrinter implements AdditionExpressionVisitor{
//
//    private StringBuilder sb = new StringBuilder();
//
////    @Override
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
//    public String toString(){
//        return sb.toString();
//    }
//}