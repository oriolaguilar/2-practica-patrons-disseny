import Excepcions.OutOfBounds;

public class SpreadSheet {


    private static int SIZE = 5;
    private static final Sheet SHEET = new Sheet(SIZE);

    //Utilitzar per fer tests rapids
    public static void main(String[] args) throws OutOfBounds {
        put("c1", 13);
        put("a1", "c1");
        put("a2", "a1");
        //Testing
        MaybeValue mV = SHEET.getCell("a2").getExpression().evaluate();
        if(mV.hasValue()){
            SomeValue sV = (SomeValue) mV;
            System.out.println(sV.getValue());
        }else{
            System.out.println("No value");
        }
    }

    public static Expression plus(Expression expr1, Expression expr2){
        return null;
    }
    public static Expression plus(Expression expr1, int value2){
        return null;
    }
    public static Expression plus(Expression expr1, String ref2){
        return null;
    }
    public static Expression plus(int value1, Expression expr2){
        return null;
    }
    public static Expression plus(int value1, int value2){
        return null;
    }
    public static Expression plus(int value1, String ref2){
        return null;
    }
    public static Expression plus(String ref1, Expression exp2){
        return null;
    }
    public static Expression plus(String ref1, int value2){
        return null;
    }
    public static Expression plus(String ref1, String ref2){
        return null;
    }
    public static Expression mult(Expression expr1, Expression expr2){
        return null;
    }
    public static Expression mult(Expression expr1, int value2){
        return null;
    }
    public static Expression mult(Expression expr1, String ref2){
        return null;
    }
    public static Expression mult(int value1, Expression expr2){
        return null;
    }
    public static Expression mult(int value1, int value2){
        return null;
    }
    public static Expression mult(int value1, String ref2){
        return null;
    }
    public static Expression mult(String ref1, Expression exp2){
        return null;
    }
    public static Expression mult(String ref1, int value2){
        return null;
    }
    public static Expression mult(String ref1, String ref2){
        return null;
    }
    public static MaybeValue get(String name){
        return null;
    }

    public static void put(String name, Expression expr) throws OutOfBounds {
        SHEET.getCell(name).set(expr);
    }

    public static void put(String name, int value) throws OutOfBounds {
        SHEET.getCell(name).set(value);
    }
    public static void put(String name, String refName) throws OutOfBounds {
        Cell referencedCell = SHEET.getCell(refName);
        Reference reference = new Reference(referencedCell);
        SHEET.getCell(name).set(reference);
    }
    public static void clear(){
        SHEET.clear();
    }



}
