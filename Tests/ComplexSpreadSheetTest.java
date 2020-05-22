import Excepcions.OutOfBounds;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import spreadsheet.NoValue;
import spreadsheet.SomeValue;

import static org.junit.jupiter.api.Assertions.*;
import static spreadsheet.SpreadSheet.*;

public class ComplexSpreadSheetTest {
    @BeforeEach
    public void setUp() throws OutOfBounds {
         put("c1", mult("a1", "b1"));
         put("c2", mult("a2", "b2"));
         put("c3", plus("c1", "c2"));
         put("a1", 10);
         put("b1", 20);
         put("a2", 30);
         put("b2", 40);
         put("d1", plus("c1", "b2"));
         put("d2", mult("d1", "b1"));
    }

    @Test
    public void changing_value_to_chained_expressions() throws OutOfBounds {
        assertAll(()->assertEquals(new SomeValue(200), get("c1")), ()->assertEquals(new SomeValue(1400), get("c3")),
                ()->assertEquals(new SomeValue(240), get("d1")), ()->assertEquals(new SomeValue(4800), get("d2")));
        put("a1", 100);
        assertAll(()->assertEquals(new SomeValue(2000), get("c1")), ()->assertEquals(new SomeValue(3200), get("c3")),
                ()->assertEquals(new SomeValue(2040), get("d1")), ()->assertEquals(new SomeValue(40800), get("d2")));
    }

    @Test
     public void chained_expressions(){
        assertAll(()->assertEquals(new SomeValue(200), get("c1")), ()->assertEquals(new SomeValue(1200), get("c2")),
                ()->assertEquals(new SomeValue(1400), get("c3")));
    }

    @Test
    public void chained_NoValue_propagations() throws OutOfBounds {
        put("a1", new NoValue());
        assertAll(()->assertFalse(get("c1").hasValue()),()->assertFalse(get("c3").hasValue()),
                ()->assertFalse(get("d1").hasValue()), ()->assertFalse(get("d2").hasValue()));
    }

    @Test
     public void chained_propagations() throws OutOfBounds {
        put("a1", "b1");
        assertEquals(new SomeValue(1600), get("c3"));
    }
    @AfterEach
    public void tearDown() {
        clear();
    }
}

