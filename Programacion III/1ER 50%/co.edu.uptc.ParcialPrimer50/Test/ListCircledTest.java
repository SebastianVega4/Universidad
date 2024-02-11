import Logic.*;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class ListCircledTest {
    private ListCircled list;

    void setup(){
        list = new ListCircled();
        list.addNodeFirst( new Digit(2));
        list.addNodeFirst( new Digit(3));
        list.addNodeLast( new Digit(6));
        list.addNodeLast( new Digit(1));
        list.addNodeFirst( new Digit(5));
        list.addNodeFirst( new Digit(9));
        list.addNodeLast( new Digit(9));
    }

    @Test
    void findNode() {
        setup();
        assertNotNull( list.findNode(9));
        assertNull( list.findNode(19));
        assertEquals(9,list.findNode(9).getInfo().getDigit());
        assertEquals(5,list.findNode(5).getInfo().getDigit());
        assertEquals(3,list.findNode(3).getInfo().getDigit());
        assertEquals(2,list.findNode(2).getInfo().getDigit());
        assertEquals(6,list.findNode(6).getInfo().getDigit());
        assertEquals(1,list.findNode(1).getInfo().getDigit());
    }

    @Test
    void getLinked() {
        setup();
        assertEquals(7,list.getLinked().size());
        assertEquals(9,list.getLinked().get(0).getDigit());
        assertEquals(9,list.getLinked().get(6).getDigit());
        assertEquals(2,list.getLinked().get(3).getDigit());
        assertEquals(5,list.getLinked().get(1).getDigit());
    }

    @Test
    void jumping() {
        setup();
        assertEquals(3,list.jumping(list.findNode(5),1).getInfo().getDigit());
        assertEquals(6,list.jumping(list.findNode(9),4).getInfo().getDigit());
        assertEquals(1,list.jumping(list.findNode(3),10).getInfo().getDigit());
        assertEquals(9,list.jumping(list.findNode(2),3).getInfo().getDigit());
        assertEquals(6,list.jumping(list.findNode(6),7).getInfo().getDigit());
    }

    @Test
    void isJumping() {
        setup();
        assertFalse( list.isJumping());
        list = new ListCircled();
        list.addNodeLast( new Digit(2));
        list.addNodeLast( new Digit(3));
        list.addNodeLast( new Digit(1));
        list.addNodeLast( new Digit(2));
        assertTrue( list.isJumping());

        list = new ListCircled();
        list.addNodeLast(new Digit(4));
        assertTrue( list.isJumping());

        list = new ListCircled();
        list.addNodeLast(new Digit(1));
        list.addNodeLast(new Digit(1));
        assertTrue( list.isJumping());

        list = new ListCircled();
        list.addNodeLast(new Digit(2));
        list.addNodeLast(new Digit(2));
        assertFalse( list.isJumping());

        list = new ListCircled();
        list.addNodeLast(new Digit(2));
        list.addNodeLast(new Digit(1));
        list.addNodeLast(new Digit(3));
        assertFalse( list.isJumping());

        list = new ListCircled();
        list.addNodeLast(new Digit(1));
        list.addNodeLast(new Digit(2));
        list.addNodeLast(new Digit(2));
        list.addNodeLast(new Digit(3));
        assertTrue( list.isJumping());

        list = new ListCircled();
        list.addNodeLast(new Digit(1));
        list.addNodeLast(new Digit(0));
        assertFalse( list.isJumping());
    }
}