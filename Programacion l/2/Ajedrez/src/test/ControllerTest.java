package test;

import co.edu.uptc.controller.Controller;
import co.edu.uptc.model.Board;
import co.edu.uptc.model.PieceColor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {
/*
    Controller controller = new Controller();
    private Board board;
    private PieceColor turno;
    @BeforeEach
    void setUp() {
        Controller controller = new Controller();
    }

    @AfterEach
    void tearDown() {
        controller = null;
    }

    @Test
    void gameController() {
        assertNotNull(controller.showBoard());
        assertEquals(PieceColor.BLANCA, controller.getTurno());
    }

    @Test
    void startGame() {
        // Para esta prueba, podemos simular la entrada de un movimiento válido
        // que permita avanzar el juego a la siguiente jugada.
        assertTrue(controller.movePiece(1, 0, 2, 0));
        assertEquals(PieceColor.NEGRA, controller.getTurno());
    }

    @Test
    void movePiece() {
        // Movimiento válido de peón
        assertTrue(controller.movePiece(1, 0, 2, 0));


        // Movimiento inválido de peón
        assertFalse(controller.movePiece(6, 0, 4, 0));

        // Movimiento válido de caballo
        assertTrue(controller.movePiece(0, 1, 2, 0));


        // Movimiento inválido de caballo
        assertFalse(controller.movePiece(0, 1, 2, 2));

        // Movimiento válido de alfil
        assertTrue(controller.movePiece(1, 2, 2, 3));

        // Movimiento inválido de alfil
        assertFalse(controller.movePiece(1, 2, 3, 3));

        // Movimiento válido de torre
        assertTrue(controller.movePiece(0, 0, 2, 0));

        // Movimiento inválido de torre
        assertFalse(controller.movePiece(0, 0, 2, 1));

        // Movimiento válido de reina
        assertTrue(controller.movePiece(0, 3, 2, 5));

        // Movimiento inválido de reina
        assertFalse(controller.movePiece(0, 3, 3, 5));

        // Movimiento válido de rey
        assertTrue(controller.movePiece(0, 4, 1, 3));


        // Movimiento inválido de rey
        assertFalse(controller.movePiece(0, 4, 2, 3));

    }

    @Test
    void showBoard() {
        assertDoesNotThrow(() -> controller.showBoard());
    }
    @Test
    void showInvalidMoveMessage() {
    }*/
}