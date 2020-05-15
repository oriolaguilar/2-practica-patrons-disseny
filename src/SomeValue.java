public class SomeValue extends MaybeValue {

    private final int value;

    public SomeValue(int value){
        super(true);
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public MaybeValue evaluate() {
        return this;
    }
}
