package chess;

import chess.pieces.King;
import org.junit.Test;

import java.util.List;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

/**
 * Created by RM on 15.08.2015.
 */
public class KingTest extends BasePieceTest {

    King king = new King(owner);

    /**
     * Test possible moves white
     */
    @Test
    public final void testPossibleKingMovesWhite() {
        List<Position> possiblePositionList = king.possibleMoves(new Position('e', 2), positionToPieceMap, owner);
        //makes sure that it contains all possible moves
        assertTrue(possiblePositionList.contains(new Position('d', 2)));
        assertTrue(possiblePositionList.contains(new Position('f', 2)));
        assertTrue(possiblePositionList.contains(new Position('e', 1)));
        assertTrue(possiblePositionList.contains(new Position('e', 3)));

        assertTrue(possiblePositionList.contains(new Position('d', 3)));
        assertTrue(possiblePositionList.contains(new Position('f', 3)));
        assertTrue(possiblePositionList.contains(new Position('f', 1)));
        assertTrue(possiblePositionList.contains(new Position('d', 1)));

        //Check wrong moves
        assertFalse(possiblePositionList.contains(new Position('e', 5)));

    }

    /**
     * Test possible moves black
     */
    @Test
    public final void testPossibleKingMovesBlack() {
        owner = Player.Black;
        List<Position> possiblePositionList = king.possibleMoves(new Position('e', 7), positionToPieceMap, owner);
        //makes sure that it contains all possible moves
        assertTrue(possiblePositionList.contains(new Position('e', 8)));
        assertTrue(possiblePositionList.contains(new Position('e', 6)));
        assertTrue(possiblePositionList.contains(new Position('d', 7)));
        assertTrue(possiblePositionList.contains(new Position('f', 7)));

        assertTrue(possiblePositionList.contains(new Position('d', 6)));
        assertTrue(possiblePositionList.contains(new Position('f', 8)));
        assertTrue(possiblePositionList.contains(new Position('d', 8)));
        assertTrue(possiblePositionList.contains(new Position('f', 6)));

        //Check wrong moves
        assertFalse(possiblePositionList.contains(new Position('e', 5)));

    }
}
