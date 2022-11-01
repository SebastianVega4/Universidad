package logic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyArrayTest {
    private MyArray myArray;

    void setup() {
        myArray = new MyArray();
        myArray.add("54");
        myArray.add("62");
        myArray.add("75");
        myArray.add("92");
        myArray.add("19");
    }

    @Test
    void add() {
        setup();
        assertEquals(5, myArray.getSize());
        myArray.add("Hola");
        myArray.add("Mundo");
        assertEquals(7, myArray.getSize());
        assertEquals(10, myArray.getArray().length);
        myArray.add("Sogamoso");
        myArray.add("Duitama");
        myArray.add("Paipa");
        myArray.add("Tunja");
        assertEquals(15, myArray.getArray().length);
    }

    @Test
    void get() {
        setup();
        assertThrows(Exception.class, () -> {
            myArray.get(-3);
            assertNull(myArray.get(5));
        });

        assertDoesNotThrow(() -> {
            assertEquals("75", myArray.get(2));
        });
    }

    @Test
    void clear() {
        setup();
        myArray.clear();
        assertEquals(0, myArray.getSize());
        assertEquals(10, myArray.getArray().length);
    }

    @Test
    void indexOf() {
        setup();
        assertEquals(2, myArray.indexOf("75"));
        assertEquals(-1, myArray.indexOf("9999"));
        myArray.add("62");
        assertEquals(1, myArray.indexOf("62"));
    }

    @Test
    void lastIndexOf() {
        setup();
        myArray.add("62");
        assertEquals(5, myArray.lastIndexOf("62"));
        assertEquals(-1, myArray.lastIndexOf("Lola"));
    }

    @Test
    void remove() {
        setup();
        assertEquals("75", myArray.remove(2));
        System.out.println(myArray);
        System.out.println(myArray.getSize());
        assertEquals(-1, myArray.indexOf("75"));
        assertEquals(4, myArray.getSize());
        assertNull(myArray.remove(10));
        assertNull(myArray.remove(-2));
    }

    @Test
    void setThis() {
        setup();
        try {
            assertEquals("62", myArray.get(1));
            assertEquals("100", myArray.setThis(1, "100"));
            assertEquals("100", myArray.get(1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void getSize() {
        setup();
    }
}