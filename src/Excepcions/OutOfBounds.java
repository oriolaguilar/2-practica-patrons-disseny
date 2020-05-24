package Excepcions;

public class OutOfBounds extends Exception {
    public OutOfBounds(){
        super("This cell is out of bounds. Index to high or negative");
    }
}
