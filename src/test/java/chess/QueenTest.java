package chess;

import chess.pieces.Queen;
import org.junit.Test;

import java.util.List;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

/**
 * Created by RM on 15.08.2015.
 */
public class QueenTest extends BasePieceTest {

    Queen queen = new Queen(owner);

    /**
     * Test possible moves white
     */
    @Test
    public final void testPossibleQueenMovesWhite() {
        List<Position> possiblePositionList = queen.possibleMoves(new Position('d', 3), positionToPieceMap, owner);
        //makes sure that it contains all possible moves
        assertTrue(possiblePositionList.contains(new Position('a', 3)));
        assertTrue(possiblePositionList.contains(new Position('h', 3)));
        assertTrue(possiblePositionList.contains(new Position('d', 1)));
        assertTrue(possiblePositionList.contains(new Position('d', 8)));

        assertTrue(possiblePositionList.contains(new Position('b', 1)));
        assertTrue(possiblePositionList.contains(new Position('h', 7)));
        assertTrue(possiblePositionList.contains(new Position('a', 6)));
        assertTrue(possiblePositionList.contains(new Position('f', 1)));

        //Check wrong moves
        assertFalse(possiblePositionList.contains(new Position('e', 5)));

    }

    /**
     * Test possible moves black
     */
    @Test
    public final void testPossibleQueenMovesBlack() {
        owner = Player.Black;
        List<Position> possiblePositionList = queen.possibleMoves(new Position('d', 6), positionToPieceMap, owner);
        //makes sure that it contains all possible moves
        assertTrue(possiblePositionList.contains(new Position('d', 8)));
        assertTrue(possiblePositionList.contains(new Position('d', 1)));
        assertTrue(possiblePositionList.contains(new Position('a', 6)));
        assertTrue(possiblePositionList.contains(new Position('h', 6)));

        assertTrue(possiblePositionList.contains(new Position('a', 3)));
        assertTrue(possiblePositionList.contains(new Position('f', 8)));
        assertTrue(possiblePositionList.contains(new Position('b', 8)));
        assertTrue(possiblePositionList.contains(new Position('h', 2)));

        //Check wrong moves
        assertFalse(possiblePositionList.contains(new Position('g', 5)));

    }
}
