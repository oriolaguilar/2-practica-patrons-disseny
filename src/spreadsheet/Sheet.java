package spreadsheet;

import Excepcions.OutOfBounds;

public class Sheet {

    private Cell[][] sheet;


    public Sheet(int size){
        this.sheet = new Cell[size][size];
        initializeCells();
    }
    private void initializeCells(){
        int size = sheet.length;
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                sheet[i][j] = new Cell(new NoValue());
                sheet[i][j].recalculate();
            }
        }
    }

    public Cell getCell(String name) throws OutOfBounds {
        int row = nameToRow(name);
        int column = nameToColumn(name);
        if (outOfRange(row, column)){
            throw new OutOfBounds();
        }
        return sheet[row][column];
    }

    public void insertInto(String name, Expression expression) throws OutOfBounds {
        int row = nameToRow(name);
        int column = nameToColumn(name);
        if (outOfRange(row, column)){
            throw new OutOfBounds();
        }
        sheet[row][column].insert(expression);
    }

    public void insertInto(String name, int value) throws OutOfBounds {
        insertInto(name, new SomeValue(value));
    }

    public void clear(){
        initializeCells();
    }

    private boolean outOfRange(int i1, int i2){
        return i1 < 0 || i1 > 5 || i2 < 0 || i2 > 5;
    }

    private int nameToColumn(String name) {
        char letter = name.charAt(0);
        return ((int) letter) - ((int) 'a');
    }

    private int nameToRow(String name){
        String number = name.substring(1);
        return Integer.parseInt(number) - 1;
    }

}
