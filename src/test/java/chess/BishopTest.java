package chess;

import chess.pieces.Bishop;
import org.junit.Test;

import java.util.List;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

/**
 * Created by RM on 15.08.2015.
 */
public class BishopTest extends BasePieceTest {

    Bishop bishop = new Bishop(owner);

    /**
     * Test possible moves white
     */
    @Test
    public final void testPossibleBishopMovesWhite() {
        List<Position> possiblePositionList = bishop.possibleMoves(new Position('e', 4), positionToPieceMap, owner);
        //makes sure that it contains all possible moves
        assertTrue(possiblePositionList.contains(new Position('a', 8)));
        assertTrue(possiblePositionList.contains(new Position('h', 7)));
        assertTrue(possiblePositionList.contains(new Position('b', 1)));
        assertTrue(possiblePositionList.contains(new Position('h', 1)));

        //Check wrong moves
        assertFalse(possiblePositionList.contains(new Position('b', 3)));

    }

    /**
     * Test possible moves black
     */
    @Test
    public final void testPossibleBishopMovesBlack() {
        owner = Player.Black;
        List<Position> possiblePositionList = bishop.possibleMoves(new Position('d', 6), positionToPieceMap, owner);
        //makes sure that it contains all possible moves
        assertTrue(possiblePositionList.contains(new Position('b', 8)));
        assertTrue(possiblePositionList.contains(new Position('h', 2)));
        assertTrue(possiblePositionList.contains(new Position('f', 8)));
        assertTrue(possiblePositionList.contains(new Position('a', 3)));

        //Check wrong moves
        assertFalse(possiblePositionList.contains(new Position('b', 3)));

    }
}
