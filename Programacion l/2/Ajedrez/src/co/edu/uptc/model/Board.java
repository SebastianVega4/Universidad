package co.edu.uptc.model;


public class Board extends  ValidMove{
    private final Piece[][] pieces;

    public Board() {
        pieces = new Piece[8][8];
        // inicializar el tablero con las piezas en su posición inicial
        // Piezas BLANCA
        pieces[0][0] = new Piece(PieceType.TORRE, PieceColor.BLANCA, 0, 0);
        pieces[0][1] = new Piece(PieceType.CABALLO, PieceColor.BLANCA, 0, 1);
        pieces[0][2] = new Piece(PieceType.ALFIL, PieceColor.BLANCA, 0, 2);
        pieces[0][3] = new Piece(PieceType.REINA, PieceColor.BLANCA, 0, 3);
        pieces[0][4] = new Piece(PieceType.REY, PieceColor.BLANCA, 0, 4);
        pieces[0][5] = new Piece(PieceType.ALFIL, PieceColor.BLANCA, 0, 5);
        pieces[0][6] = new Piece(PieceType.CABALLO, PieceColor.BLANCA, 0, 6);
        pieces[0][7] = new Piece(PieceType.TORRE, PieceColor.BLANCA, 0, 7);
        for (int i = 0; i < 8; i++) {
            pieces[1][i] = new Piece(PieceType.PEON, PieceColor.BLANCA, 1, i);
        }
        // Piezas NEGRAS
        pieces[7][0] = new Piece(PieceType.TORRE, PieceColor.NEGRA, 7, 0);
        pieces[7][1] = new Piece(PieceType.CABALLO, PieceColor.NEGRA, 7, 1);
        pieces[7][2] = new Piece(PieceType.ALFIL, PieceColor.NEGRA, 7, 2);
        pieces[7][3] = new Piece(PieceType.REINA, PieceColor.NEGRA, 7, 3);
        pieces[7][4] = new Piece(PieceType.REY, PieceColor.NEGRA, 7, 4);
        pieces[7][5] = new Piece(PieceType.ALFIL, PieceColor.NEGRA, 7, 5);
        pieces[7][6] = new Piece(PieceType.CABALLO, PieceColor.NEGRA, 7, 6);
        pieces[7][7] = new Piece(PieceType.TORRE, PieceColor.NEGRA, 7, 7);
        for (int i = 0; i < 8; i++) {
            pieces[6][i] = new Piece(PieceType.PEON, PieceColor.NEGRA, 6, i);
        }
        super.inipieces(pieces);
    }

    public Piece[][] getPieces() {
        return pieces;
    }
}

