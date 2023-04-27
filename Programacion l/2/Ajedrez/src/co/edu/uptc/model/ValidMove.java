package co.edu.uptc.model;

public class ValidMove {

    private String getError;
    private Piece[][] pieces;

    public void inipieces(Piece[][] pieces){
        this.pieces = pieces;
    }
    public Piece getPieceAt(int fila, int colum) {
        return pieces[fila][colum];
    }
    public void setPieceAt(int fila, int colum, Piece piece) {
        pieces[fila][colum] = piece;
    }
    public void removePieceAt(int fila, int colum) {
        pieces[fila][colum] = null;
    }
    // Métodos para validar los movimientos de cada pieza
    public boolean isValidMovePeon(Piece peon, int newFila, int newColum) {
        // implementar la lógica para validar el movimiento del peón
        int anteriorFila = peon.getFila();
        int anteriorColum = peon.getColum();
        // Si el peón está en su posición inicial, puede avanzar dos casillas
        if (anteriorFila == 1 && newFila == 3 && pieces[2][anteriorColum] == null && pieces[3][anteriorColum] == null && pieces[anteriorFila][anteriorColum].getColor() == PieceColor.BLANCA) {
            System.out.println("2 movimientos solo al iniciar");
            return true;
        } else if (anteriorFila == 6 && newFila == 4 && pieces[5][anteriorColum] == null && pieces[4][anteriorColum] == null && pieces[anteriorFila][anteriorColum].getColor() == PieceColor.NEGRA) {
            System.out.println("2 movimientos solo al iniciar");
            return true;
        }
        // El peón solo puede avanzar una casilla a la vez (o dos si está en su posición inicial)
        if (newFila != anteriorFila + 1 && newFila != anteriorFila + 2 && pieces[anteriorFila][anteriorColum].getColor() == PieceColor.BLANCA) {
            getError = "El peón solo puede avanzar una casilla a la vez y hacia delante";
            return false;
        } else if (newFila != anteriorFila - 1 && newFila != anteriorFila - 2 && pieces[anteriorFila][anteriorColum].getColor() == PieceColor.NEGRA) {
            getError = "El peón solo puede avanzar una casilla a la vez y hacia delante";
            return false;
        }

        // El peón no puede capturar hacia adelante
        if (peon.getColor() == PieceColor.BLANCA) {
            if (newFila == anteriorFila + 1 && (newColum == anteriorColum - 1 || newColum == anteriorColum + 1)) {
                System.out.println(" si entro aca 5,4");
                if (pieces[newFila][newColum] != null && (pieces[newFila][newColum].getColor() == PieceColor.NEGRA)) {
                    System.out.println(" El peon blanco capturo");
                    return true;
                }
            }
        } else {
            if (newFila == anteriorFila - 1 && (newColum == anteriorColum - 1 || newColum == anteriorColum + 1)) {
                System.out.println(" si entro aca 6,2");
                if (pieces[newFila][newColum] != null && (pieces[newFila][newColum].getColor() == PieceColor.BLANCA)) {
                    System.out.println(" El peon negro capturo");
                    return true;
                }
            }
        }
        // El peón solo puede moverse hacia adelante
        if (newColum != anteriorColum) {
            getError = " El peón solo puede moverse hacia adelante";
            return false;
        }
        // El peón no puede avanzar si hay una pieza en su camino
        if (pieces[newFila][newColum] != null) {
            getError = "El peón no puede avanzar si hay una pieza en su camino";
            return false;
        }
        System.out.println(" El peon se movio");
        return true;
        // Si llegamos aquí, el movimiento es válido
    }
    public boolean isValidMoveCaballo(Piece caballo, int newFila, int newCol) {
        int anteriorFila = caballo.getFila();
        int anteriorColm = caballo.getColum();
        // calcular la distancia horizontal y vertical del movimiento
        int newFilaBlanca = Math.abs(newFila - anteriorFila);
        int newColBlanca = Math.abs(newCol - anteriorColm);


        // validar que la distancia es correcta para el movimiento del caballo
        if ((newFilaBlanca == 2 && newColBlanca == 1) || (newFilaBlanca == 1 && newColBlanca == 2)) {
            // validar que la casilla de destino no contiene una pieza del mismo color
            Piece destPiece = getPieceAt(newFila, newCol);
            if (destPiece == null || (destPiece.getColor() != caballo.getColor())) {
                System.out.println("El caballo se movio");
                return true;
            }
        }
        getError = "Compruebe la nueva posicion y su trayectoria";
        return false;
    }
    public boolean isValidMoveAlfil(Piece alfil, int newFila, int newCol) {
        int anteriorFila = alfil.getFila();
        int anteriorColu = alfil.getColum();

        // calcular la distancia horizontal y vertical del movimiento
        int newFilaBlanca = Math.abs(newFila - anteriorFila);
        int newColuBlanca = Math.abs(newCol - anteriorColu);

        // validar que la distancia es correcta para el movimiento del alfil
        if (newFilaBlanca == newColuBlanca) {
            // validar que no hay ninguna pieza en el camino del alfil
            int stepFila = (newFila > anteriorFila) ? 1 : -1;
            int stepCol = (newCol > anteriorColu) ? 1 : -1;

            int fila = anteriorFila + stepFila;
            int col = anteriorColu + stepCol;
            while (fila != newFila && col != newCol) {
                Piece piece = getPieceAt(fila, col);
                if (piece != null) {
                    getError = "Hay una pieza en el camino";
                    return false;
                }
                fila += stepFila;
                col += stepCol;
            }

            // validar que la casilla de destino no contiene una pieza del mismo color
            Piece destPiece = getPieceAt(newFila, newCol);
            if (destPiece == null || (destPiece.getColor() != alfil.getColor())) {
                System.out.println("El alfin se movio");
                return true;
            }
        }
        getError = "Compruebe la nueva posicion y su trayectoria";
        return false;
    }

    public boolean isValidMoveTorre(Piece torre, int newFila, int newCol) {
        int currentFila = torre.getFila();
        int currentCol = torre.getColum();

        // Verificar si la nueva posición es válida
        if (newFila < 0 || newFila > 7 || newCol < 0 || newCol > 7) {
            getError = "fuera del tablero";
            return false;
        }

        // Verificar si la torre se mueve en una fila o columna
        if (newFila != currentFila && newCol != currentCol) {
            getError = "no se puede mover en diagonal";
            return false;
        }

        // Verificar si hay piezas entre la posición actual y la nueva posición
        int start, end;
        if (newFila == currentFila) {
            start = Math.min(currentCol, newCol) + 1;
            end = Math.max(currentCol, newCol);
            for (int i = start; i < end; i++) {
                if (getPieceAt(currentFila, i) != null) {
                    getError = "Hay una pieza en el camino de la fila";
                    return false;
                }
            }
        } else {
            start = Math.min(currentFila, newFila) + 1;
            end = Math.max(currentFila, newFila);
            for (int i = start; i < end; i++) {
                if (getPieceAt(i, currentCol) != null) {
                    getError = "Hay una pieza en el camino de la columna";
                    return false;
                }
            }
        }

        // Verificar si la nueva posición está vacía o tiene una pieza del color opuesto
        Piece pieceAtNewPos = getPieceAt(newFila, newCol);
        return pieceAtNewPos == null || (pieceAtNewPos.getColor() != torre.getColor());
    }

    public boolean isValidMoveReina(Piece reina, int newFila, int newCol) {
        int currFila = reina.getFila();
        int currCol = reina.getColum();

        // Verificar si la nueva posición está dentro del tablero
        if (newFila < 0 || newFila > 7 || newCol < 0 || newCol > 7) {
            getError = "fuera del tablero";
            return false;
        }
        // Verificar si hay una pieza del mismo color en la nueva posición
        Piece pieceAtNewPos = getPieceAt(newFila, newCol);
        if (pieceAtNewPos != null && (pieceAtNewPos.getColor() == reina.getColor())) {
            getError = "no puede matarse a si mismo";
            return false;
        }

        // Verificar si el movimiento es en línea recta o en diagonal
        if (currFila != newFila && currCol != newCol && Math.abs(currFila - newFila) != Math.abs(currCol - newCol)) {
            getError = "solo se puede mover diagonal o linealmente";
            return false;
        }

        // Verificar si hay piezas en el camino del movimiento
        int diffFila = Integer.compare(newFila, currFila);
        int diffCol = Integer.compare(newCol, currCol);

        if (currFila != newFila && currCol != newCol) {
            int fila = currFila + diffFila;
            int col = currCol + diffCol;
            while (fila != newFila && col != newCol) {
                if (getPieceAt(fila, col) != null) {
                    getError = "Hay una pieza en el camino (alfin)";
                    return false;
                }
                fila += diffFila;
                col += diffCol;
            }
        } else if (currFila != newFila) {
            int fila = currFila + diffFila;
            while (fila != newFila) {
                if (getPieceAt(fila, currCol) != null) {
                    getError = "Hay una pieza en el camino de la columna (torre)";
                    return false;
                }
                fila += diffFila;
            }
        } else {
            int col = currCol + diffCol;
            while (col != newCol) {
                if (getPieceAt(currFila, col) != null) {
                    getError = "Hay una pieza en el camino de la fila (torre)";
                    return false;
                }
                col += diffCol;
            }
        }

        // Si se pasaron todas las validaciones, entonces el movimiento es válido
        System.out.println("La reina se movio");
        return true;
    }

    public boolean isValidMoveRey(Piece rey, int newFila, int newCol) {
        int currentFila = rey.getFila();
        int currentCol = rey.getColum();

        // El Rey se puede mover una casilla en cualquier dirección
        if (Math.abs(currentFila - newFila) <= 1 && Math.abs(currentCol - newCol) <= 1) {
            // Comprobar que la casilla a la que se quiere mover está vacía o tiene una pieza del otro color
            if (getPieceAt(newFila, newCol) == null || (getPieceAt(newFila, newCol).getColor() != rey.getColor())) {
                System.out.println("El rey se movio");
                return true;
            }
        }
        getError = "Compruebe la nueva posicion";
        return false;
    }
    public String getGetError() {
        return getError;
    }
}