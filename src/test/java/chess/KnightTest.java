package chess;

import chess.pieces.Knight;
import org.junit.Test;

import java.util.List;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

/**
 * Created by RM on 15.08.2015.
 */
public class KnightTest extends BasePieceTest {

    Knight knight = new Knight(owner);

    /**
     * Test possible moves
     */
    @Test
    public final void testPossibleKnightMovesWhite() {
        List<Position> possiblePositionList = knight.possibleMoves(new Position('d', 3), positionToPieceMap, owner);
        //makes sure that it contains all possible moves
        assertTrue(possiblePositionList.contains(new Position('b', 4)));
        assertTrue(possiblePositionList.contains(new Position('f', 4)));
        assertTrue(possiblePositionList.contains(new Position('b', 2)));
        assertTrue(possiblePositionList.contains(new Position('f', 2)));

        assertTrue(possiblePositionList.contains(new Position('c', 5)));
        assertTrue(possiblePositionList.contains(new Position('e', 5)));
        assertTrue(possiblePositionList.contains(new Position('c', 1)));
        assertTrue(possiblePositionList.contains(new Position('e', 1)));

        //Check wrong moves
        assertFalse(possiblePositionList.contains(new Position('b', 5)));

    }

    /**
     * Test possible moves
     */
    @Test
    public final void testPossibleKnightMovesBlack() {
        owner = Player.Black;
        List<Position> possiblePositionList = knight.possibleMoves(new Position('f', 6), positionToPieceMap, owner);
        //makes sure that it contains all possible moves
        assertTrue(possiblePositionList.contains(new Position('e', 8)));
        assertTrue(possiblePositionList.contains(new Position('g', 8)));
        assertTrue(possiblePositionList.contains(new Position('d', 7)));
        assertTrue(possiblePositionList.contains(new Position('h', 7)));

        assertTrue(possiblePositionList.contains(new Position('d', 5)));
        assertTrue(possiblePositionList.contains(new Position('h', 5)));
        assertTrue(possiblePositionList.contains(new Position('e', 4)));
        assertTrue(possiblePositionList.contains(new Position('g', 4)));

        //Check wrong moves
        assertFalse(possiblePositionList.contains(new Position('b', 5)));

    }
}
