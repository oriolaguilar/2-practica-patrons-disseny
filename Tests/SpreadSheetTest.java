import Excepcions.OutOfBounds;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import spreadsheet.Cell;
import spreadsheet.Expression;
import spreadsheet.SomeValue;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static  spreadsheet.SpreadSheet.*;
public class SpreadSheetTest {

    @BeforeEach
    public void setUpSheet() throws OutOfBounds {
        put("a3", mult("a1", "a2"));
        put("b1", "b2");
        put("b2", 100);
    }

    @Test
    public void mostSimpleCase() throws OutOfBounds {
        assertEquals(new SomeValue(100), get("b2"));
    }

    @Test
    public void changingValueToDirectReference() throws OutOfBounds {
        put("b2", 200);
        assertEquals(new SomeValue(200), get("b1"));
    }

    @Test
    public void cellHasNoValueIfDependsOnEmptyCells() throws OutOfBounds {
            assertFalse(get("a3").hasValue());
    }

    @Test
    public void recalculationWorks() throws OutOfBounds {
        put("a1", 42);
        put("a2", 20);
        assertEquals(new SomeValue(840), get("a3"));
    }

    @Test
    public void referenceWorks() throws OutOfBounds {
        Set<Cell> references = new HashSet<>();
        references.add(getCell("a1"));
        references.add(getCell("a2"));
        Expression exp = mult("a1", "a2");
        assertEquals(references, exp.references());
    }
    
    @Test
    public void singletonWorks() throws OutOfBounds {
        assertSame(get("a1"), get("a2"));
    }

    @AfterEach
    public void clearSheet() {
        clear();
    }
}
