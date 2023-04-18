package Chess;

public class Horse extends ChessPiece {
    public Horse(String color) {
        super(color);
    }

    @Override
    String getColor() {
        return this.color;
    }


    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (this.checkPosition(line) && this.checkPosition(column) && this.checkPosition(toLine) && this.checkPosition(toColumn)) {
            if (line != toLine && column != toColumn && (chessBoard.board[toLine][toColumn] == null || !chessBoard.board[toLine][toColumn].color.equals(this.color)) && chessBoard.board[line][column] != null) {
                if (!chessBoard.board[line][column].equals(this)) {
                    return false;
                }

                int[][] positions = new int[][]{{line - 2, column - 1}, {line - 2, column + 1}, {line + 2, column - 1}, {line + 2, column + 1}, {line - 1, column - 2}, {line - 1, column + 2}, {line + 1, column - 2}, {line + 1, column + 2}};

                for (int i = 0; i < positions.length; ++i) {
                    if (positions[i][0] == toLine && positions[i][1] == toColumn) {
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
    String getSymbol() {
        return "H";
    }

    @Override
    boolean checkPosition(int position) {
        return position >= 0 && position <= 7;
    }
}
