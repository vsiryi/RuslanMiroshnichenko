package chess;

import chess.pieces.Rook;
import org.junit.Test;

import java.util.List;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

/**
 * Created by RM on 15.08.2015.
 */
public class RookTest extends BasePieceTest {

    Player owner = Player.White;

    Rook rook = new Rook(owner);

    /**
     * Test possible moves
     */
    @Test
    public final void testPossibleRookMovesWhite() {
        List<Position> possiblePositionList = rook.possibleMoves(new Position('d', 3), positionToPieceMap, owner);
        //makes sure that it contains all possible moves
        assertTrue(possiblePositionList.contains(new Position('a', 3)));
        assertTrue(possiblePositionList.contains(new Position('h', 3)));
        assertTrue(possiblePositionList.contains(new Position('d', 1)));
        assertTrue(possiblePositionList.contains(new Position('d', 8)));

        //Check wrong moves
        assertFalse(possiblePositionList.contains(new Position('b', 4)));

    }

    /**
     * Test possible moves
     */
    @Test
    public final void testPossibleRookMovesBlack() {
        owner = Player.Black;
        List<Position> possiblePositionList = rook.possibleMoves(new Position('b', 6), positionToPieceMap, owner);
        //makes sure that it contains all possible moves
        assertTrue(possiblePositionList.contains(new Position('b', 8)));
        assertTrue(possiblePositionList.contains(new Position('b', 1)));
        assertTrue(possiblePositionList.contains(new Position('a', 6)));
        assertTrue(possiblePositionList.contains(new Position('h', 6)));

        //Check wrong moves
        assertFalse(possiblePositionList.contains(new Position('c', 5)));

    }
}
