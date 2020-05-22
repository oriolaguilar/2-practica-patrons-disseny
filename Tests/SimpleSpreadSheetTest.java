import Excepcions.OutOfBounds;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import spreadsheet.SomeValue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static  spreadsheet.SpreadSheet.*;
public class SimpleSpreadSheetTest {

    @BeforeEach
    public void setUpSheet() throws OutOfBounds {
        put("a3", mult("a1", "a2"));
        put("b1", "b2");
        put("b2", 100);
    }

    @Test
    public void most_simple_case() throws OutOfBounds {
        assertEquals(new SomeValue(100), get("b2"));
    }

    @Test
    public void changing_value_to_direct_reference() throws OutOfBounds {
        put("b2", 200);
        assertEquals(new SomeValue(200), get("b1"));
    }

    @Test
    public void cell_has_no_value_if_depends_on_empty_cells() throws OutOfBounds {
            assertFalse(get("a3").hasValue());
    }

    @Test
    public void recalculation_works() throws OutOfBounds {
        put("a1", 42);
        put("a2", 20);
        assertEquals(new SomeValue(840), get("a3"));
    }

    @AfterEach
    public void clearSheet() {
        clear(); }
}
