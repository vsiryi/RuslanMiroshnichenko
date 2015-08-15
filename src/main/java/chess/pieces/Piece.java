package chess.pieces;

import chess.Player;
import chess.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * A base class for chess pieces
 */
public abstract class Piece {

    //Possible movies
    protected ArrayList<Position> moves;

    private final Player owner;

    protected Piece(Player owner) {
        this.owner = owner;
    }

    public char getIdentifier() {
        char id = getIdentifyingCharacter();
        if (owner.equals(Player.White)) {
            return Character.toLowerCase(id);
        } else {
            return Character.toUpperCase(id);
        }
    }

    public Player getOwner() {
        return owner;
    }

    protected abstract char getIdentifyingCharacter();

    /**
     * Calculate possible moves
     *
     * @param currentPosition The current position
     * @param player Current player
     * @return List of possible moves
     */
    public abstract List<Position> possibleMoves(Position currentPosition, Map<Position, Piece> positionToPieceMap, Player player);

    /**
     * Check is empty position
     *
     * @param positionToPieceMap Current position state
     * @param position           New position
     * @return Is allowed position
     */
    protected Boolean isAllowedPosition(Map<Position, Piece> positionToPieceMap, Position position) {
        if (positionToPieceMap.get(position) == null) {
            return true;
        }
        return false;
    }


}
