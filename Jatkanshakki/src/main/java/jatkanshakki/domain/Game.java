package jatkanshakki.domain;

public class Game {

    private Board board;
    private char turn;

    /**
     * Sovelluslogiikka
     */
    public Game() {
        this.board = new Board(15);
        this.turn = 'O';
    }

    private void swapTurns() {
        if (this.turn == 'O') {
            this.turn = 'X';
        } else if (this.turn == 'X') {
            this.turn = 'O';
        }
    }

    /**
     *
     * @return kumman pelaajan vuoro
     */
    public char getTurn() {
        return this.turn;
    }

    /**
     *
     * @param x merkattavan ruudun x-koordinaatti
     * @param y merkattavan ruudun y-koordinaatti
     * @return totuusarvo merkataanko haluttu ruutu onnistuneesti
     *
     */
    public boolean mark(int x, int y) {
        if (this.board.markSpace(x, y, this.turn)) {
            if (checkForWin()) {
                return true;
            }
            swapTurns();
            return true;
        } else {
            return false;
        }
    }

    /**
     *
     * @return totuusarvo onko kumpikaan pelaaja voittanut
     */
    public boolean checkForWin() {
        for (int x = 1; x <= this.board.getSize(); x++) {
            for (int y = 1; y <= this.board.getSize(); y++) {
                if (!this.board.spaceHasBeenUsed(x, y)) {
                    continue;
                }
                if (checkWinHorizontally(x, y) || checkWinVertically(x, y) || checkWinDiagonally(x, y)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkWinHorizontally(int x, int y) {
        if (x > 10) {
            return false;
        }
        for (int i = 1; i < 5; i++) {
            if (this.turn != this.board.getValueFromSpace(x + i, y) || this.board.getValueFromSpace(x + i, y) == ' ') {
                return false;
            }
        }
        return true;
    }

    private boolean checkWinVertically(int x, int y) {
        if (y > 10) {
            return false;
        }
        for (int i = 0; i < 5; i++) {
            if (this.turn != this.board.getValueFromSpace(x, y + i) || this.board.getValueFromSpace(x, y + i) == ' ') {
                return false;
            }
        }
        return true;
    }

    private boolean checkWinDiagonally(int x, int y) {
        boolean hasWon1 = true;
        boolean hasWon2 = true;
        boolean hasWon3 = true;
        boolean hasWon4 = true;
        if (x <= 10 && y >= 5) {
            for (int i = 0; i < 5; i++) {
                if (this.turn != this.board.getValueFromSpace(x + i, y - i) || this.board.getValueFromSpace(x + i, y - i) == ' ') {
                    hasWon1 = false;
                }
            }
        } else {
            hasWon1 = false;
        }
        if (x <= 10 && y <= 10) {
            for (int i = 0; i < 5; i++) {
                if (this.turn != this.board.getValueFromSpace(x + i, y + i) || this.board.getValueFromSpace(x + i, y + i) == ' ') {
                    hasWon2 = false;
                }
            }
        } else {
            hasWon2 = false;
        }
        if (x >= 5 && y <= 10) {
            for (int i = 0; i < 5; i++) {
                if (this.turn != this.board.getValueFromSpace(x - i, y + i) || this.board.getValueFromSpace(x - i, y + i) == ' ') {
                    hasWon3 = false;
                }
            }
        } else {
            hasWon3 = false;
        }
        if (x >= 5 && y >= 5) {
            for (int i = 0; i < 5; i++) {
                if (this.turn != this.board.getValueFromSpace(x - i, y - i) || this.board.getValueFromSpace(x - i, y - i) == ' ') {
                    hasWon4 = false;
                }
            }
        } else {
            hasWon4 = false;
        }
        return (hasWon1 || hasWon2 || hasWon3 || hasWon4);
    }

}
