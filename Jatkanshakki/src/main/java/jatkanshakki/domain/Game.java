package jatkanshakki.domain;

/**
 *
 * Sovelluslogiikka
 */
public class Game {

    private Board board;
    private char turn;

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

    public char getTurn() {
        return this.turn;
    }

    public void mark(int x, int y) {
        if (x > this.board.getSize() || y > this.board.getSize()) {
            System.out.println("virhe");
        }
        if (this.board.markSpace(x, y, this.turn)) {
            //checkForWin(x, y);
            swapTurns();
        } else {
            System.out.println("Ruutu varattu");
        }
    }

    /*public boolean checkForWin(int x, int y) {
        for (int i = 1; i <= 11; i++) {
            for (int j = 1; j <= 11; i++) {

            }
        }
        return false;
    }*/

}
