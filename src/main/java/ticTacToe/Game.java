package ticTacToe;

public class Game {

    private String[][] field;
    private String turn;

    public Game() {
        this.field = new String[][]{{" ", " ", " "}, {" ", " ", " "}, {" ", " ", " "}};
        this.turn = "X";
    }

    public String getTurn() {
        return this.turn;
    }

    public String status(int x, int y) {
        if (indexOutOfBounds(x, y)) {
            return "";
        }

        return this.field[x][y];
    }

    public void place(int r, int c) {
        if (indexOutOfBounds(r, c)) {
            return;
        }

        if (!this.field[r][c].equals(" ")) {
            return;
        }

        this.field[r][c] = this.turn;
    }

    public void changeTurn() {
        if (this.turn.equals("X")) {
            this.turn = "O";
        } else {
            this.turn = "X";
        }
    }

    public boolean gameOver() {
        if (this.checkRows() || this.checkColumns() || this.checkDiagonals()) {
            return true;
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (this.field[i][j].equals(" ")) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean indexOutOfBounds(int x, int y) {
        if (x < 0 || y < 0 || x > 2 || y > 2) {
            return true;
        }
        return false;
    }

    private boolean checkRows() {
        for (int r = 0; r < 3; r++) {
            if (!this.field[r][0].equals(" ")
                    && this.field[r][0].equals(this.field[r][1])
                    && this.field[r][1].equals(this.field[r][2])) {
                System.out.println("won by row");
                return true;
            }
        }
        return false;
    }

    private boolean checkColumns() {
        for (int c = 0; c < 3; c++) {
            if (!this.field[0][c].equals(" ")
                    && this.field[0][c].equals(this.field[1][c])
                    && this.field[1][c].equals(this.field[2][c])) {
                System.out.println("won by col");
                return true;
            }
        }
        return false;
    }

    private boolean checkDiagonals() {
        if (this.field[1][1].equals(" ")) {
            return false;
        }

        if (this.field[0][0].equals(this.field[1][1]) && this.field[1][1].equals(this.field[2][2])) {
            return true;
        }

        if (this.field[0][2].equals(this.field[1][1]) && this.field[1][1].equals(this.field[2][0])) {
            return true;
        }

        return false;
    }
}
