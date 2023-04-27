package test;

import co.edu.uptc.model.Board;
import co.edu.uptc.model.Piece;
import co.edu.uptc.model.PieceColor;
import co.edu.uptc.model.PieceType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {
    /*
    private Board board;

    @BeforeEach
    void setUp() {
        board = new Board();
    }

    @AfterEach
    void tearDown() {
        board = null;
    }

    @Test
    void getPieceAt() {
        // Test getting a piece from a valid position
        Piece piece = board.getPieceAt(0, 0);
        assertNotNull(piece);

        // Test getting a piece from an invalid position
        piece = board.getPieceAt(-1, -1);
        assertNull(piece);
    }

    @Test
    void setPieceAt() {
        // Test setting a piece at a valid position
        Piece piece = new Piece(PieceType.PEON, PieceColor.BLANCA,1,1);
        board.setPieceAt(2, 2, piece);
        Piece newPiece = board.getPieceAt(2, 2);
        assertNotNull(newPiece);
        assertEquals(newPiece, piece);

        // Test setting a piece at an invalid position
        board.setPieceAt(-1, -1, piece);
        newPiece = board.getPieceAt(-1, -1);
        assertNull(newPiece);
    }

    @Test
    void removePieceAt() {
        // Test removing a piece from a valid position
        board.removePieceAt(0, 0);
        Piece piece = board.getPieceAt(0, 0);
        assertNull(piece);

        // Test removing a piece from an invalid position
        board.removePieceAt(-1, -1);
        piece = board.getPieceAt(-1, -1);
        assertNull(piece);
    }

    @Test
    void isValidMovePeon() {
        // Test valid moves for a white pawn
        assertTrue(board.isValidMovePeon(new Piece(PieceType.PEON, PieceColor.BLANCA,1,1), 1, 0));
        assertTrue(board.isValidMovePeon(new Piece(PieceType.PEON, PieceColor.BLANCA,2,0), 2, 0));
    }
    @Test
    void getGetError() {
    }*/
}