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


}
