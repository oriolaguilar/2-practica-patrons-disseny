public class NoValue extends MaybeValue {

    public NoValue(){
        super(false);
    }

    @Override
    public MaybeValue evaluate() {
        return this;
    }
}
