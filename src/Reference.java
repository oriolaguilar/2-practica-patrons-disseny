import java.util.HashSet;
import java.util.Set;

public class Reference implements Expression {

    private final Cell referencedTo;

    public Reference(Cell ref){
        referencedTo = ref;
    }

    @Override
    public MaybeValue evaluate() {
        return referencedTo.evaluate();
    }

    @Override
    public Set<Cell> references() {
        Set<Cell> referencedCell = new HashSet<>();
        referencedCell.add(referencedTo);
        return referencedCell;
    }

}
