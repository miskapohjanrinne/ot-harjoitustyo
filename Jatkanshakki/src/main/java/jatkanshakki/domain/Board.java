package jatkanshakki.domain;

/**
 * Pelilautaa kuvaava luokka
 *
 */
public class Board {

    private Space[][] spaces;
    private int size; //kokoa kuvataan yhdellä kokonaisluvulla, koko on siis size x size

    public Board(int size) {
        this.spaces = new Space[size + 1][size + 1];
        this.size = size;
        this.initBoard(this.size);
    }

    public int getSize() {
        return this.size;
    }

    public char getValueFromSpace(int x, int y) {
        return this.spaces[x][y].getValue();
    }

    private void initBoard(int size) {
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size; j++) {
                this.spaces[i][j] = new Space(i, j);
            }
        }
    }

    public boolean markSpace(int x, int y, char marker) {
        if (this.spaces[x][y].hasBeenUsed()) {
            return false;
        } else {
            this.spaces[x][y].setValue(marker);
            return true;
        }
    }

    public boolean spaceHasBeenUsed(int x, int y) {
        return this.spaces[x][y].hasBeenUsed();
    }

}
