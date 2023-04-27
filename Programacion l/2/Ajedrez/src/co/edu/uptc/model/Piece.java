package co.edu.uptc.model;

public class Piece {
    private final PieceType type;
    private final PieceColor color;
    private int fila;
    private int colum;
    private boolean firstMove;

    public Piece(PieceType type, PieceColor color, int fila, int colum) {
        this.type = type;
        this.color = color;
        this.fila = fila;
        this.colum = colum;
        this.firstMove = true;
    }
    public PieceType getType() {
        return type;
    }
    public PieceColor getColor() {
        return color;
    }
    public int getFila() {
        return fila;
    }
    public void setFila(int fila) {
        this.fila = fila;
    }
    public int getColum() {
        return colum;
    }
    public void setColum(int colum) {
        this.colum = colum;
    }
    public boolean getFirstMove() {
        return firstMove;
    }
    public void setFirstMove(boolean firstMove) {
        this.firstMove = firstMove;
    }
    public String getSymbol() {
        //Simbolos piesas blancas
        if (type == PieceType.PEON && color == PieceColor.BLANCA) {
            return "♙";
        } else if (type == PieceType.TORRE && color == PieceColor.BLANCA) {
            return "♖";
        } else if (type == PieceType.ALFIL && color == PieceColor.BLANCA) {
            return "♗";
        } else if (type == PieceType.CABALLO && color == PieceColor.BLANCA) {
            return "♘";
        } else if (type == PieceType.REY && color == PieceColor.BLANCA) {
            return "♔";
        } else if (type == PieceType.REINA && color == PieceColor.BLANCA) {
            return "♕";
        }
        //Simbolos piesas blancas
        if (type == PieceType.PEON && color == PieceColor.NEGRA) {
            return "♟";
        } else if (type == PieceType.TORRE && color == PieceColor.NEGRA) {
            return "♜";
        } else if (type == PieceType.ALFIL && color == PieceColor.NEGRA) {
            return "♝";
        } else if (type == PieceType.CABALLO && color == PieceColor.NEGRA) {
            return "♞";
        } else if (type == PieceType.REY && color == PieceColor.NEGRA) {
            return "♚";
        } else if (type == PieceType.REINA && color == PieceColor.NEGRA) {
            return "♛";
        }
        return null;
    }
}

