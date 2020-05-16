public class Cell {

    private Expression expression;

    public Cell(Expression expr){
        expression = expr;
    }
    public MaybeValue evaluate(){
        return expression.evaluate();
    }

    public Expression getExpression() {
        return expression;
    }
    public void set(Expression exp){
        expression = exp;
    }
    public void set(int value){
        set(new SomeValue(value));
    }

}
