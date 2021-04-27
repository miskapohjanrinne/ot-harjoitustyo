package jatkanshakki.domain;

/**
 * Yksittäistä ruutua kuvaava luokka
 */
public class Space {
    
    private int coordinateX;
    private int coordinateY;
    private boolean used;
    private char value;
    
    public Space(int x, int y) {
        this.coordinateX = x;
        this.coordinateY = y;
        this.used = false;
    }
    
    public int getX() {
        return this.coordinateX;
    }
    
    public int getY() {
        return this.coordinateY;
    }
    
    public char getValue() {
        if (!this.hasBeenUsed()) {
            return ' ';
        }
        return this.value;
    }
    
    public boolean hasBeenUsed() {
        return this.used;
    }
    
    public void setValue(char value) {
        this.value = value; //asettaa ruudun arvoksi X tai O
        this.used = true;
    }
    
}
