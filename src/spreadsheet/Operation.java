package spreadsheet;

import java.util.HashSet;
import java.util.Set;

public abstract class Operation implements Expression {

    public Expression e1;
    public Expression e2;

    public Operation (Expression e1, Expression e2){
        this.e1 = e1;
        this.e2 = e2;
    }

    public Set<Cell> references(){
        Set<Cell> allCellsInvolved = new HashSet<>();
        allCellsInvolved.addAll(e1.references());
        allCellsInvolved.addAll(e2.references());
        return allCellsInvolved;
    }

    @Override
    public MaybeValue evaluate() {
        MaybeValue mV1 = e1.evaluate();
        MaybeValue mV2 = e2.evaluate();
        if (!mV1.hasValue() || !mV2.hasValue()){
            return new NoValue();
        }else{
            SomeValue sV1 = (SomeValue) mV1;
            SomeValue sV2 = (SomeValue) mV2;
            return new SomeValue(operate(sV1.getValue(), sV2.getValue()));
        }
    }

    public abstract int operate(int i1, int i2);


}
