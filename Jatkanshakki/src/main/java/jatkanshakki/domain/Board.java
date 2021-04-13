package jatkanshakki.domain;

import java.util.ArrayList;

/**
 * Pelilautaa kuvaava luokka
 * 
 */
public class Board {
    
    private ArrayList<Space> spaces;
    private int size; //kokoa kuvataan yhdellä kokonaisluvulla, koko on siis size x size
    
    
    public Board(int size) {
        this.spaces = new ArrayList<>();
        this.size = size;
        this.initBoard(this.size);
    }
    
    private void initBoard(int size) {
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size; j++) {
                this.spaces.add(new Space(i, j));
            }
        }
    }
}
