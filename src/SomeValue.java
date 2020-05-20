import java.util.HashSet;
import java.util.Set;

public class SomeValue extends MaybeValue {

    private final int value;

    public SomeValue(int value){
        super(true);
        this.value = value;
    }

    @Override
    public boolean equals(Object o){
        SomeValue sV = (SomeValue) o;
        return this.value == sV.value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public MaybeValue evaluate() {
        return this;
    }

    @Override
    public Set<Cell> references() {
        return new HashSet<>();
    }
}
