public class Mult extends Operation {

    public Mult(Expression e1, Expression e2){
        super(e1, e2);
    }

    public int operate(int i1, int i2){
        return i1 * i2;
    }
}
