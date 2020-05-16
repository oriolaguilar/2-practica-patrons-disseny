public class Reference implements Expression {

    private final Cell referencedTo;

    @Override
    public MaybeValue evaluate() {
        return referencedTo.evaluate();
    }

    public Reference(Cell ref){
        referencedTo = ref;
    }
}
