package Chess;

public class Queen extends ChessPiece {
    public Queen(String color) {
        super(color);
    }

    @Override
    String getColor() {
        return this.color;
    }

    @Override
    boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        int i;
        if (line != toLine && column != toColumn && this.getMax(line, toLine) - this.getMin(line, toLine) == this.getMax(column, toColumn) - this.getMin(column, toColumn) && this.checkPosition(line) && this.checkPosition(column) && this.checkPosition(toLine) && this.checkPosition(toColumn) && (chessBoard.board[toLine][toColumn] == null || !chessBoard.board[toLine][toColumn].color.equals(this.color)) && chessBoard.board[line][column] != null) {
            if (!chessBoard.board[line][column].equals(this)) {
                return false;
            } else {
                int fromC;
                int toC;
                int[][] positions;
                if ((column != this.getMin(column, toColumn) || line != this.getMax(line, toLine)) && (toColumn != this.getMin(column, toColumn) || toLine != this.getMax(line, toLine))) {
                    i = this.getMin(line, toLine);
                    fromC = this.getMin(column, toColumn);
                    this.getMax(line, toLine);
                    toC = this.getMax(column, toColumn);
                    positions = new int[toC - fromC][1];

                    for(i = 1; i < toC - fromC; ++i) {
                        if (chessBoard.board[i + i][fromC + i] == null) {
                            positions[i - 1] = new int[]{i + i, fromC + i};
                        } else {
                            if (chessBoard.board[i + i][fromC + i].color.equals(this.color) || i + i != toLine) {
                                return false;
                            }

                            positions[i - 1] = new int[]{i + i, fromC + i};
                        }
                    }

                    return true;
                } else {
                    i = this.getMax(line, toLine);
                    fromC = this.getMin(column, toColumn);
                    this.getMin(line, toLine);
                    toC = this.getMax(column, toColumn);
                    positions = new int[toC - fromC][1];

                    for(i = 1; i < toC - fromC; ++i) {
                        if (chessBoard.board[i - i][fromC + i] == null) {
                            positions[i - 1] = new int[]{i - i, fromC + i};
                        } else {
                            if (chessBoard.board[i - i][fromC + i].color.equals(this.color) || i - i != toLine) {
                                return false;
                            }

                            positions[i - 1] = new int[]{i - i, fromC + i};
                        }
                    }

                    return true;
                }
            }
        } else if (this.checkPosition(line) && this.checkPosition(column) && this.checkPosition(toLine) && this.checkPosition(toColumn)) {
            if (column == toColumn) {
                for(i = this.getMin(line, toLine); i < this.getMax(line, toLine); ++i) {
                    if (chessBoard.board[i][column] != null) {
                        if (chessBoard.board[i][column] == this && i == this.getMax(line, toLine)) {
                            return false;
                        }

                        if (chessBoard.board[i][column].getColor().equals(this.color) && i == toLine) {
                            return false;
                        }

                        if (!chessBoard.board[i][column].getColor().equals(this.color) && i == toLine) {
                            return true;
                        }

                        if (i != toLine && i != line) {
                            return false;
                        }
                    }
                }

                if (chessBoard.board[toLine][column] != null) {
                    if (chessBoard.board[toLine][column].getColor().equals(this.color) && chessBoard.board[toLine][column] != this) {
                        return false;
                    } else {
                        return !chessBoard.board[toLine][column].getColor().equals(this.color) && chessBoard.board[toLine][column] != this;
                    }
                } else {
                    return true;
                }
            } else if (line != toLine) {
                return false;
            } else {
                for(i = this.getMin(toColumn, column); i < this.getMax(column, toColumn); ++i) {
                    if (chessBoard.board[line][i] != null) {
                        if (chessBoard.board[line][i] == this && i == this.getMax(column, toColumn)) {
                            return false;
                        }

                        if (chessBoard.board[line][i].getColor().equals(this.color) && i == toColumn) {
                            return false;
                        }

                        if (!chessBoard.board[line][i].getColor().equals(this.color) && i == toColumn) {
                            return true;
                        }

                        if (i != toLine && i != column) {
                            return false;
                        }
                    }
                }

                if (chessBoard.board[toLine][toColumn] != null) {
                    if (chessBoard.board[toLine][toColumn].getColor().equals(this.color) && chessBoard.board[toLine][toColumn] != this) {
                        return false;
                    } else {
                        return !chessBoard.board[toLine][toColumn].getColor().equals(this.color) && chessBoard.board[toLine][toColumn] != this;
                    }
                } else {
                    return true;
                }
            }
        } else {
            return false;
        }
    }

    @Override
    String getSymbol() {
        return "Q";
    }

    public int getMax(int a, int b) {
        return Math.max(a, b);
    }

    public int getMin(int a, int b) {
        return Math.min(a, b);
    }

    @Override
    boolean checkPosition(int position) {
        return position >= 0 && position <= 7;
    }
}