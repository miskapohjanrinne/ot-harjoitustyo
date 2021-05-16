package jatkanshakki.domain;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class GameTest {

    Game game;

    @Before
    public void setUp() {
        game = new Game();
    }

    @Test
    public void turnGetterAndTurnSwapperWork() {
        assertEquals('O', game.getTurn());
        game.mark(1, 1);
        assertEquals('X', game.getTurn());
        game.mark(2, 2);
        assertEquals('O', game.getTurn());
        game.mark(3, 3);
        assertEquals('X', game.getTurn());
    }

    @Test
    public void methodMarkWorks() {
        assertEquals(true, game.mark(1, 1));
        assertEquals(false, game.mark(1, 1));
    }

    @Test
    public void checkingForWinWorksHorizontally() {
        game.mark(1, 1);
        game.mark(1, 2);
        game.mark(2, 1);
        game.mark(1, 3);
        game.mark(3, 1);
        game.mark(10, 10);
        game.mark(4, 1);
        game.mark(11, 11);
        game.mark(5, 1);
        assertEquals(true, game.checkForWin());
    }

    @Test
    public void checkingForWinWorksVertically() {
        game.mark(1, 1);
        game.mark(11, 11);
        game.mark(1, 2);
        game.mark(12, 12);
        game.mark(1, 3);
        game.mark(10, 10);
        game.mark(1, 4);
        game.mark(14, 14);
        game.mark(1, 5);
        assertEquals(true, game.checkForWin());
    }
}
