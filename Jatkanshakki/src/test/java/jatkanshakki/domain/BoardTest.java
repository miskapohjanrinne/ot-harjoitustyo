package jatkanshakki.domain;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BoardTest {

    Board board;

    @Before
    public void setUp() {
        board = new Board(15);
    }

    @Test
    public void sizeGetterWorks() {
        assertEquals(15, board.getSize());
    }

    @Test
    public void valueGetterWorks() {
        assertEquals(' ', board.getValueFromSpace(1, 1));
        board.markSpace(1, 1, 'O');
        assertEquals('O', board.getValueFromSpace(1, 1));
    }

    @Test
    public void methodMarkSpaceWorks() {
        assertEquals(true, board.markSpace(1, 1, 'X'));
        assertEquals(false, board.markSpace(1, 1, 'O'));
    }

    @Test
    public void methodSpaceHasBeenUsedWorks() {
        assertEquals(false, board.spaceHasBeenUsed(1, 1));
        board.markSpace(1, 1, 'X');
        assertEquals(true, board.spaceHasBeenUsed(1, 1));
    }
}
