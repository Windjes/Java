package Chess;

public class Pawn extends ChessPiece {
    public Pawn(String color) {
        super(color);
    }

    @Override
    String getColor() {
        return this.color;
    }

    @Override
    boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (this.checkPosition(line) && this.checkPosition(column) && this.checkPosition(toLine) && this.checkPosition(toColumn) && chessBoard.board[line][column] != null) {
            if (column != toColumn) {
                if ((column - toColumn == 1 || column - toColumn == -1) && (line - toLine == 1 || line - toLine == -1) && chessBoard.board[toLine][toColumn] != null) {
                    return !chessBoard.board[toLine][toColumn].getColor().equals(this.color);
                }

                return false;
            }

            byte dir;
            byte start;
            if (this.color.equals("White")) {
                dir = 1;
                start = 1;
            } else {
                dir = -1;
                start = 6;
            }

            if (line + dir == toLine) {
                return chessBoard.board[toLine][toColumn] == null;
            }

            if (line == start && line + 2 * dir == toLine) {
                return chessBoard.board[toLine][toColumn] == null && chessBoard.board[line + dir][column] == null;
            }
        }

        return false;
    }

    @Override
    String getSymbol() {
        return "P";
    }

    @Override
    boolean checkPosition(int position) {
        return position >= 0 && position <= 7;
    }
}
