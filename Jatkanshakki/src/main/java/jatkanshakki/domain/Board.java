package jatkanshakki.domain;

/**
 * Pelilautaa kuvaava luokka
 *
 */
public class Board {

    private Space[][] spaces;
    private int size;

    /**
     *
     * @param size pelilaudan koko, size x size
     */
    public Board(int size) {
        this.spaces = new Space[size + 1][size + 1];
        this.size = size;
        this.initBoard(this.size);
    }

    public int getSize() {
        return this.size;
    }

    /**
     *
     * @param x koordinaatti
     * @param y koordinaatti
     * @return kysytyn ruudun arvo, X/O/tyhjä
     */
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

    /**
     *
     * @param x koordinaatti
     * @param y koordinaatti
     * @param marker merkataanko O vai X
     * @return onnistuiko merkkaaminen
     */
    public boolean markSpace(int x, int y, char marker) {
        if (this.spaces[x][y].hasBeenUsed()) {
            return false;
        } else {
            this.spaces[x][y].setValue(marker);
            return true;
        }
    }

    /**
     *
     * @param x koordinaatti
     * @param y koordinaatti
     * @return onko ruutu jo merkattu
     */
    public boolean spaceHasBeenUsed(int x, int y) {
        return this.spaces[x][y].hasBeenUsed();
    }
}
