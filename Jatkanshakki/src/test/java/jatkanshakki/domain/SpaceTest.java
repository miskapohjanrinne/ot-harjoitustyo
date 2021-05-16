package jatkanshakki.domain;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class SpaceTest {

    Space space;

    @Before
    public void setUp() {
        space = new Space(5, 5);
    }

    @Test
    public void coordinateGettersWorkCorrectly() {
        assertEquals(5, space.getX());
        assertEquals(5, space.getY());
    }

    @Test
    public void valueSetterWorksCorrectly() {
        assertEquals(' ', space.getValue());
        space.setValue('X');
        assertEquals('X', space.getValue());
    }

    @Test
    public void valueGetterWorksCorrectly() {
        assertEquals(' ', space.getValue());
        space.setValue('O');
        assertEquals('O', space.getValue());
    }

    @Test
    public void methodHasBeenUsedWorksCorrectly() {
        assertEquals(false, space.hasBeenUsed());
        space.setValue('X');
        assertEquals(true, space.hasBeenUsed());
    }
}
