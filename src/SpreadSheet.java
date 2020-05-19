import Excepcions.OutOfBounds;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SpreadSheet {


    private static int SIZE = 5;
    private static final Sheet SHEET = new Sheet(SIZE);
    private static final List<String> allPositions = allPositions();

    //Utilitzar per fer tests rapids
    public static void main(String[] args) throws OutOfBounds {
        put("a1", 4);
        put("a2", "a1");
        put("a3", "a2");
        put("b4", 2);
        put("a1", plus(3, "b4"));
        put("a2", 10);

        String name = "a3";
        if (get(name) instanceof SomeValue){
            SomeValue sV = (SomeValue) get(name);
            System.out.println(sV.getValue());
        }else{
            System.out.println("No Object");
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
        return new Plus(new SomeValue(value1), new SomeValue(value2));
    }

    public static Expression plus(int value1, String ref2) throws OutOfBounds {
        Cell referencedCell = SHEET.getCell(ref2);
        Reference reference = new Reference(referencedCell);
        return new Plus(new SomeValue(value1), reference);
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

    public static MaybeValue get(String name) throws OutOfBounds {
        return SHEET.getCell(name).getValue();
    }

    public static void put(String name, Expression expr) throws OutOfBounds {
        SHEET.getCell(name).set(expr);
        SHEET.getCell(name).recalculate();

    }

    public static void put(String name, int value) throws OutOfBounds {
        SHEET.getCell(name).set(value);
        SHEET.getCell(name).recalculate();

    }

    public static void put(String name, String refName) throws OutOfBounds {
        Cell referencedCell = SHEET.getCell(refName);
        Reference reference = new Reference(referencedCell);
        SHEET.getCell(name).set(reference);
        SHEET.getCell(name).recalculate();
    }

    private static void recalcualteAffectedCells(String changedCell) throws OutOfBounds {
        for (String position : allPositions){
            if (affectedCell(changedCell, position)){
                SHEET.getCell(position).evaluate();
                recalcualteAffectedCells(position);
            }
        }
    }
    private static boolean affectedCell(String affectedCell, String position) throws OutOfBounds {
        Set<Cell> referencedCells = SHEET.getCell(position).getExpression().references();
        return referencedCells.contains(SHEET.getCell(affectedCell));
    }
    private static List<String> allPositions(){
        List<String> list = new ArrayList<>();
        for(int i = 0; i < SIZE; i++){
            char row = (char) ((int) 'a' + i);
            for(int j = 0; j < SIZE; j++){
                String position = String.valueOf(row) + String.valueOf(j+1);
                list.add(position);
            }
        }
        return list;
    }

    public static void clear(){
        SHEET.clear();
    }



}
