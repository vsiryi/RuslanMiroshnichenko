package chess;

import chess.pieces.Pawn;
import org.junit.Test;

import java.util.List;

import static junit.framework.Assert.*;

/**
 * Created by RM on 15.08.2015.
 */
public class PawnTest extends BasePieceTest {

    Pawn pawn = new Pawn(owner);

    /**
     * Test possible moves white
     */
    @Test
    public final void testPossiblePawnMovesWhite() {
        List<Position> possiblePositionList = pawn.possibleMoves(new Position('a', 2), positionToPieceMap, owner);
        //makes sure that it contains all possible moves
        assertEquals(3, possiblePositionList.size());
        assertTrue(possiblePositionList.contains(new Position('a', 3)));
        assertTrue(possiblePositionList.contains(new Position('a', 4)));
        assertTrue(possiblePositionList.contains(new Position('b', 3)));

        //Check wrong moves
        assertFalse(possiblePositionList.contains(new Position('b', 4)));

    }

    /**
     * Test possible moves black
     */
    @Test
    public final void testPossiblePawnMovesBlack() {
        owner = Player.Black;

        List<Position> possiblePositionList = pawn.possibleMoves(new Position('a', 7), positionToPieceMap, owner);
        //makes sure that it contains all possible moves
        assertEquals(3, possiblePositionList.size());
        assertTrue(possiblePositionList.contains(new Position('a', 6)));
        assertTrue(possiblePositionList.contains(new Position('a', 5)));
        assertTrue(possiblePositionList.contains(new Position('b', 6)));

        //Check wrong moves
        assertFalse(possiblePositionList.contains(new Position('b', 7)));

    }

}
