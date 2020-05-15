package Excepcions;

public class OutOfBounds extends Exception {
    public OutOfBounds(){
        super("This cell is out of bonds. Index to high or negative");
    }
}
