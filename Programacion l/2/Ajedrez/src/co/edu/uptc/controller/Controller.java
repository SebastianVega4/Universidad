package co.edu.uptc.controller;

import co.edu.uptc.model.*;

import javax.swing.*;
import java.util.Arrays;

public class Controller {
    private Board board;
    private PieceColor turno;

    public Controller() {
        board = new Board();
        turno = PieceColor.BLANCA;
    }
    public boolean movePiece(int fromFila, int fromCol, int toFila, int toCol) {
        Piece piece = board.getPieceAt(fromFila, fromCol);

        if (piece == null) {
            JOptionPane.showMessageDialog(null, "No selecciono ninguna ficha");
            return false;
        }
        if (piece.getColor() != turno) {
            JOptionPane.showMessageDialog(null, "Es turno de las fichas" + turno);
            return false;
        }

        if (piece.getType() == PieceType.PEON) {
            if (!board.isValidMovePeon(piece, toFila, toCol)) {
                return false;
            }
        } else if (piece.getType() == PieceType.CABALLO) {
            if (!board.isValidMoveCaballo(piece, toFila, toCol)) {
                return false;
            }
        } else if (piece.getType() == PieceType.ALFIL) {
            if (!board.isValidMoveAlfil(piece, toFila, toCol)) {
                return false;
            }
        } else if (piece.getType() == PieceType.TORRE) {
            if (!board.isValidMoveTorre(piece, toFila, toCol)) {
                return false;
            }
        } else if (piece.getType() == PieceType.REINA) {
            if (!board.isValidMoveReina(piece, toFila, toCol)) {
                return false;
            }
        } else if (piece.getType() == PieceType.REY) {
            if (!board.isValidMoveRey(piece, toFila, toCol)) {
                return false;
            }
        }

        // si se llega hasta aquí, el movimiento es válido
        board.removePieceAt(fromFila, fromCol);
        piece.setFila(toFila);
        piece.setColum(toCol);
        board.setPieceAt(toFila, toCol, piece);
        piece.setFirstMove(false);

        // cambiar el turno al siguiente jugador
        turno = (turno == PieceColor.BLANCA) ? PieceColor.NEGRA : PieceColor.BLANCA;

        return true;
    }

    public String showBoard() {
        StringBuilder message = new StringBuilder();
        int nColum = 0;

        for (int fila = -1; fila < 8; fila++) {
            for (int col = -1; col < 8; col++) {
                if (fila == -1) {
                    message = new StringBuilder("Es turno de las piezas color " + turno + "S\n        0    1    2    3   4    5    6   7");
                    continue;
                }
                if (col == -1) {
                    message.append("   ").append(nColum);
                    nColum++;
                    continue;
                }
                Piece piece = board.getPieceAt(fila, col);
                if (piece == null) {
                    message.append("      ");
                } else {
                    message.append("   ").append(piece.getSymbol());
                }
            }
            message.append("\n");
        }
        return message.toString();
    }

    public boolean entradaMove(String input) {
        int[] move = new int[4];
        String[] tokens = input.split(",");
        for (int i = 0; i < 4; i++) {
            move[i] = Integer.parseInt(tokens[i].trim());
        }
        return movePiece(move[0], move[1], move[2], move[3]);
    }

    public void showInvalidMoveMessage() {
        JOptionPane.showMessageDialog(null, board.getGetError() + "\n Movimiento invalido, intenta de nuevo");
    }
}
