package spreadsheet;

import Excepcions.OutOfBounds;

public class SpreadSheet {


    private static int SIZE = 5;
    private static final Sheet SHEET = new Sheet(SIZE);

    //Utilitzar per fer tests rapids
    public static void main(String[] args) throws OutOfBounds {
        put("a1", 4);
        put("a2", "a1");
        put("a3", "a2");
        put("b4", mult(2, 4));
        put("a1", mult(3, "b4"));
        //clear();
        put("a2", "d3");

        String name = "a1";
        if (get(name).hasValue()){
            SomeValue sV = (SomeValue) get(name);
            System.out.println(sV.getValue());
        }else{
            System.out.println("No Object");
        }

        System.out.println(get("a2") == get("d4"));
    }

    public static Expression plus(Expression expr1, Expression expr2){
        return new Plus(expr1, expr2);
    }

    public static Expression plus(Expression expr1, int value2){
        return new Plus(expr1, new SomeValue(value2));
    }

    public static Expression plus(Expression expr1, String ref2) throws OutOfBounds {
        Cell referencedCell = SHEET.getCell(ref2);
        Reference reference = new Reference(referencedCell);
        return new Plus(expr1, reference);
    }

    public static Expression plus(int value1, Expression expr2){
        return new Plus(new SomeValue(value1), expr2);
    }

    public static Expression plus(int value1, int value2){
        return new Plus(new SomeValue(value1), new SomeValue(value2));
    }

    public static Expression plus(int value1, String ref2) throws OutOfBounds {
        Cell referencedCell = SHEET.getCell(ref2);
        Reference reference = new Reference(referencedCell);
        return new Plus(new SomeValue(value1), reference);
    }

    public static Expression plus(String ref1, Expression exp2) throws OutOfBounds {
        Cell referencedCell = SHEET.getCell(ref1);
        Reference reference = new Reference(referencedCell);
        return new Plus(reference, exp2);
    }

    public static Expression plus(String ref1, int value2) throws OutOfBounds {
        Cell referencedCell = SHEET.getCell(ref1);
        Reference reference = new Reference(referencedCell);
        return new Plus(reference, new SomeValue(value2));
    }

    public static Expression plus(String ref1, String ref2) throws OutOfBounds {
        Cell referencedCell1 = SHEET.getCell(ref1);
        Reference reference1 = new Reference(referencedCell1);
        Cell referencedCell2 = SHEET.getCell(ref2);
        Reference reference2 = new Reference(referencedCell2);
        return new Plus(reference1, reference2);
    }

    public static Expression mult(Expression expr1, Expression expr2){
        return new Mult(expr1, expr2);
    }

    public static Expression mult(Expression expr1, int value2){
        return new Mult(expr1, new SomeValue(value2));
    }

    public static Expression mult(Expression expr1, String ref2) throws OutOfBounds {
        Cell referencedCell = SHEET.getCell(ref2);
        Reference reference = new Reference(referencedCell);
        return new Mult(expr1, reference);
    }

    public static Expression mult(int value1, Expression expr2){
        return new Mult(new SomeValue(value1), expr2);
    }

    public static Expression mult(int value1, int value2){
        return new Mult(new SomeValue(value1), new SomeValue(value2));
    }

    public static Expression mult(int value1, String ref2) throws OutOfBounds {
        Cell referencedCell = SHEET.getCell(ref2);
        Reference reference = new Reference(referencedCell);
        return new Mult(new SomeValue(value1), reference);
    }

    public static Expression mult(String ref1, Expression exp2) throws OutOfBounds {
        Cell referencedCell = SHEET.getCell(ref1);
        Reference reference = new Reference(referencedCell);
        return new Mult(reference, exp2);
    }

    public static Expression mult(String ref1, int value2) throws OutOfBounds {
        Cell referencedCell = SHEET.getCell(ref1);
        Reference reference = new Reference(referencedCell);
        return new Mult(reference, new SomeValue(value2));
    }

    public static Expression mult(String ref1, String ref2) throws OutOfBounds {
        Cell referencedCell1 = SHEET.getCell(ref1);
        Reference reference1 = new Reference(referencedCell1);
        Cell referencedCell2 = SHEET.getCell(ref2);
        Reference reference2 = new Reference(referencedCell2);
        return new Mult(reference1, reference2);
    }

    public static MaybeValue get(String name) throws OutOfBounds {
        return SHEET.getCell(name).getValue();
    }

    public static void put(String name, Expression expr) throws OutOfBounds {
        SHEET.insertInto(name, expr);
    }

    public static void put(String name, int value) throws OutOfBounds {
        SHEET.insertInto(name, value);
    }

    public static void put(String name, String refName) throws OutOfBounds {
        Cell referencedCell = SHEET.getCell(refName);
        Reference reference = new Reference(referencedCell);
        SHEET.insertInto(name, reference);
    }

    public static Cell getCell(String name) throws OutOfBounds {
        return SHEET.getCell(name);
    }

    public static void clear(){
        SHEET.clear();
    }



}
