package test;

import co.edu.uptc.model.Board;
import co.edu.uptc.model.Piece;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    Board board = new Board();

    @Test
    void isValidMovePeon() {
        Piece piece = board.getPieceAt(1, 0);
        assertEquals(board.isValidMovePeon(piece,3,0),true);
    }

    @Test
    void isValidMoveCaballo() {
        Piece piece = board.getPieceAt(0, 1);
        assertEquals(board.isValidMoveCaballo(piece,2,2),true);
    }

    @Test
    void isValidMoveAlfil() {
        Piece piece = board.getPieceAt(0, 3);
        assertEquals(board.isValidMoveAlfil(piece,5,2),false);
    }

    @Test
    void isValidMoveTorre() {
        Piece piece = board.getPieceAt(0, 0);
        assertEquals(board.isValidMoveTorre(piece,6,0),false);
    }

    @Test
    void isValidMoveReina() {
        Piece piece = board.getPieceAt(0, 4);
        assertEquals(board.isValidMoveReina(piece,7,4),false);
    }

    @Test
    void isValidMoveRey() {
        Piece piece = board.getPieceAt(0, 5);
        assertEquals(board.isValidMovePeon(piece,1,6),false);
    }
}