package fall2018.csc2017.slidingtiles;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExtraUnitTests {

    Board board;
    /** The board manager for testing. */
    BoardManager boardManager;
    List<Tile> tiles;

    /**
     * Make a set of tiles that are in order.
     * @return a set of tiles that are in order
     */
    private List<Tile> makeTiles() {
        tiles = new ArrayList<>();
        final int numTiles = Board.NUM_ROWS * Board.NUM_COLS;
        for (int tileNum = 0; tileNum != numTiles; tileNum++) {
            tiles.add(new Tile(tileNum + 1, tileNum));
        }

        return tiles;
    }

    /**
     * Make a solved Board.
     */
    private void setUpCorrect() {
        List<Tile> tiles = makeTiles();
        board = new Board(tiles);
        boardManager = new BoardManager(board);
    }

    /**
     * Shuffle a few tiles.
     */
    private void swapFirstTwoTiles() {
        boardManager.getBoard().swapTiles(0, 0, 0, 1);
    }

    /**
     * Test whether Board is Iterable.
     */
    @Test
    public void testBoardIterableSimple() {
        setUpCorrect();
	assertTrue(board instanceof Iterable);
	if(board instanceof Iterable) {
		Iterable<Tile> it = (Iterable<Tile>)board;
        	Iterator<Tile> i = it.iterator();
        	assert(i.hasNext());
        	assertEquals(i.next(), tiles.get(0));
        
       		i = it.iterator();
        	assertEquals(i.next(), tiles.get(0));    
	}
    }

    /**
     * Test whether swapping the middle two tiles works.
     */
    @Test
    public void testSwapMiddleTwo() {
        setUpCorrect();
        assertEquals(3, boardManager.getBoard().getTile(0, 2).getId());
        assertEquals(4, boardManager.getBoard().getTile(0, 3).getId());
        boardManager.getBoard().swapTiles(0, 2, 0, 3);
        assertEquals(4, boardManager.getBoard().getTile(0, 2).getId());
        assertEquals(3, boardManager.getBoard().getTile(0, 3).getId());
    }

    /**
     * Test whether the puzzle is solved
     */
    @Test
    public void testPuzzleSolved() {
        setUpCorrect();
        assertTrue(boardManager.puzzleSolved());
        boardManager.getBoard().swapTiles(3, 3, 3, 2);
        assertFalse(boardManager.puzzleSolved());
    }

    /**
     * Test whether the puzzle is solved after a series of touches
     */
    @Test
    public void testPuzzleSolvedTouches() {
        setUpCorrect();
        assertTrue(boardManager.puzzleSolved());
        boardManager.touchMove(14);
        assertFalse(boardManager.puzzleSolved());
        boardManager.touchMove(15);
        assertTrue(boardManager.puzzleSolved());
    }
}

