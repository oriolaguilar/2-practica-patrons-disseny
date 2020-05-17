public class Cell {

    private Expression expression;
    private MaybeValue value;

    public Cell(Expression expr){
        expression = expr;
    }

    public MaybeValue getValue() {
        return value;
    }

    public MaybeValue evaluate(){
        MaybeValue value = expression.evaluate();
        this.value = value;
        return value;
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
