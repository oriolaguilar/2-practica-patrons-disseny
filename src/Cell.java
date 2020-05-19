import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Cell {

    public String id;
    private Expression expression;
    private MaybeValue value;
    private List<Cell> observers = new ArrayList<>();

    public Cell(Expression expr, String id){
        expression = expr;
        this.id = id;
    }

    public MaybeValue getValue() {
        return value;
    }

    public void registerObservers(Cell cell){
        observers.add(cell);
    }
    public void unregisterObservers(Cell cell){
        observers.remove(cell);
    }
    private void notifyObservers(){
        for(Cell observer : observers){
            observer.recalculate();
        }
    }

    public void recalculate(){
        evaluate();
        notifyObservers();
    }

    public MaybeValue evaluate(){
        MaybeValue value = expression.evaluate();
        this.value = value;
        //notifyObservers();
        //System.out.println("value");
        return value;
    }

    public Expression getExpression() {
        return expression;
    }

    public void set(Expression exp) {
        Set<Cell> oldReferences = expression.references();
        expression = exp;
        Set<Cell> newReferences = expression.references();
        observeNewReferences(oldReferences, newReferences);
    }

    private void observeNewReferences(Set<Cell> oldReferences, Set<Cell> newReferences){
        for(Cell old : oldReferences){
            old.unregisterObservers(this);
        }
        for(Cell toObserve : newReferences){
            toObserve.registerObservers(this);
        }
    }
    public void set(int value){
        set(new SomeValue(value));
    }

}
