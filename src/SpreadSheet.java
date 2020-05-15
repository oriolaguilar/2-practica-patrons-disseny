import Excepcions.OutOfBounds;

public class SpreadSheet {


    private static int SIZE = 5;
    private static final Sheet SHEET = new Sheet(SIZE);

    public static void main(String[] args) throws OutOfBounds {
        put("a1", 7);
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
    public static void put(String name, Expression expr){
        return;
    }

    public static void put(String name, int value) throws OutOfBounds {
        SHEET.getCell(name).set(value);
        MaybeValue mV = SHEET.getCell(name).getExpression().evaluate();
        if(mV.hasValue()){
            SomeValue sV = (SomeValue) mV;
            System.out.println(sV.getValue());
        }
    }

    public static void put(String name, String refName){
        return;
    }
    public static void clear(){

    }



}
