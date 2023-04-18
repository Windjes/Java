package Chess;

public class King extends ChessPiece {
    public King(String color) {
        super(color);
    }

    @Override
    String getColor() {
        return this.color;
    }

    @Override
    boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (this.checkPosition(line) && this.checkPosition(column) && this.checkPosition(toLine) && this.checkPosition(toColumn)) {
            if (Math.abs(line - toLine) <= 1 && Math.abs(column - toColumn) <= 1) {
                if (this.isUnderAttack(chessBoard, toLine, toColumn)) {
                    return false;
                } else if (chessBoard.board[toLine][toColumn] != null) {
                    return !chessBoard.board[toLine][toColumn].getColor().equals(this.color);
                } else {
                    return true;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    String getSymbol() {
        return "K";
    }

    public boolean isUnderAttack(ChessBoard chessBoard, int line, int column) {
        if (this.checkPosition(line) && this.checkPosition(column)) {
            for (int i = 0; i < 7; ++i) {
                for (int j = 0; j < 7; ++j) {
                    if (chessBoard.board[i][j] != null && !chessBoard.board[i][j].getColor().equals(this.color) && chessBoard.board[i][j].canMoveToPosition(chessBoard, i, j, line, column)) {
                        return true;
                    }
                }
            }

            return false;
        } else {
            return false;
        }
    }

    @Override
    boolean checkPosition(int position) {
        return position >= 0 && position <= 7;
    }
}