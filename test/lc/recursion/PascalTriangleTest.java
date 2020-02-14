package lc.recursion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PascalTriangleTest {

    @Test
    void fieldValue() {

        assertEquals(1, PascalTriangle.fieldValue(1,1));
        assertEquals(1, PascalTriangle.fieldValue(2,1));
        assertEquals(1, PascalTriangle.fieldValue(2,2));
        assertEquals(1, PascalTriangle.fieldValue(3,1));
        assertEquals(2, PascalTriangle.fieldValue(3,2));
        assertEquals(1, PascalTriangle.fieldValue(3,3));
        assertEquals(1, PascalTriangle.fieldValue(4,1));
        assertEquals(3, PascalTriangle.fieldValue(4,2));
        assertEquals(3, PascalTriangle.fieldValue(4,3));
        assertEquals(1, PascalTriangle.fieldValue(4,4));
        assertEquals(1, PascalTriangle.fieldValue(5,1));
        assertEquals(4, PascalTriangle.fieldValue(5,2));
        assertEquals(6, PascalTriangle.fieldValue(5,3));
        assertEquals(4, PascalTriangle.fieldValue(5,4));
        assertEquals(1, PascalTriangle.fieldValue(5,5));

    }

    @Test
    void outOfBound() {
        assertEquals("index < 1", assertThrows(IndexOutOfBoundsException.class, () -> PascalTriangle.fieldValue(0,1)).getMessage());
        assertEquals("index < 1", assertThrows(IndexOutOfBoundsException.class, () -> PascalTriangle.fieldValue(1,0)).getMessage());
        assertEquals("column > row", assertThrows(IndexOutOfBoundsException.class, () -> PascalTriangle.fieldValue(1,2)).getMessage());
    }
}