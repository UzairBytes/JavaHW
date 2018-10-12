package fall2018.csc2017.slidingtiles;

import java.util.Observable;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * The sliding tiles board.
 */
public class Board extends Observable implements Serializable {

    /**
     * The number of rows.
     */
    final static int NUM_ROWS = 4;

    /**
     * The number of rows.
     */
    final static int NUM_COLS = 4;

    /**
     * The tiles on the board in row-major order.
     */
    private Tile[][] tiles = new Tile[NUM_ROWS][NUM_COLS];

    @Override
    public Iterator<Tile> iterator() {
        Iterator<Tile> iter = new Iterator<Tile>() {
            private int currentRow = 0;
            private int currentColumn = 0;

            @Override
            public boolean hasNext() {
                return (currentColumn < NUM_COLS - 1 || currentRow < NUM_ROWS - 1)
                        && tiles[currentRow][currentColumn] != null;

            }

            @Override
            public Tile next() {
                if (currentColumn < NUM_COLS - 1) {
                    return tiles[currentRow][currentColumn++];
                } else if (currentColumn == NUM_COLS - 1) {
                    currentColumn = 0;
                    return tiles[currentRow++][currentColumn];
                }
                return null;
            }
        };
        return iter;
    }

    /**
     * A new board of tiles in row-major order.
     * Precondition: len(tiles) == NUM_ROWS * NUM_COLS
     *
     * @param tiles the tiles for the board
     */
    Board(List<Tile> tiles) {
        Iterator<Tile> iter = tiles.iterator();

        for (int row = 0; row != Board.NUM_ROWS; row++) {
            for (int col = 0; col != Board.NUM_COLS; col++) {
                this.tiles[row][col] = iter.next();
            }
        }
    }

    /**
     * Return the number of tiles on the board.
     *
     * @return the number of tiles on the board
     */
    int numTiles() {
        return NUM_COLS * NUM_ROWS;
    }

    /**
     * Return the tile at (row, col)
     *
     * @param row the tile row
     * @param col the tile column
     * @return the tile at (row, col)
     */
    Tile getTile(int row, int col) {
        return tiles[row][col];
    }

    /**
     * Swap the tiles at (row1, col1) and (row2, col2)
     *
     * @param row1 the first tile row
     * @param col1 the first tile col
     * @param row2 the second tile row
     * @param col2 the second tile col
     */
    void swapTiles(int row1, int col1, int row2, int col2) {
        Tile currentTile1 = this.getTile(row1, col1);
        Tile currentTile2 = this.getTile(row2, col2);

        tiles[row1][col1] = currentTile2;
        tiles[row2][col2] = currentTile1;

        setChanged();
        notifyObservers();
    }

    @Override
    public String toString() {
        return "Board{" +
                "tiles=" + Arrays.toString(tiles) +
                '}';
    }
}
