public class Plus extends Operation{

    public Plus(Expression e1, Expression e2){
        super(e1, e2);
    }

    public int operate(int i1, int i2){
        return i1 + i2;
    }

    @Override
    public MaybeValue evaluate() {
        MaybeValue mV1 = e1.evaluate();
        MaybeValue mV2 = e2.evaluate();
        if (mV1 instanceof NoValue || mV2 instanceof NoValue){
            return new NoValue();
        }else{
            SomeValue sV1 = (SomeValue) mV1;
            SomeValue sV2 = (SomeValue) mV2;
            return new SomeValue(operate(sV1.getValue(), sV2.getValue()));
        }
    }
}
