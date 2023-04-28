package test;

import co.edu.uptc.controller.Controller;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {
    Controller controller = new Controller();
    @Test
    void movePiece() {
        assertEquals(controller.movePiece(1,0,3,0),true);
        assertEquals(controller.movePiece(7,7,6,0),false);
        assertEquals(controller.movePiece(6,1,4,1),true);
        assertEquals(controller.movePiece(0,0,2,0),true);

    }
}