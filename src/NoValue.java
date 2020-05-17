import java.util.HashSet;
import java.util.Set;

public class NoValue extends MaybeValue {

    public static final NoValue INSTANCE = new NoValue();

    public NoValue(){
        super(false);
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
