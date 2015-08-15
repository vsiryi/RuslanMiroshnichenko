package chess.pieces;

import chess.Player;
import chess.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * The Pawn
 */
public class Pawn extends Piece {

    private boolean isJumped; // Check jump in the begin

    public Pawn(Player owner) {
        super(owner);
    }

    @Override
    protected char getIdentifyingCharacter() {
        return 'p';
    }

    /**
     * Calculate possible moves of Pawn from current position
     *
     * @param currentPosition The current position
     * @return List of possible moves
     */
    @Override
    public List<Position> possibleMoves(Position currentPosition, Map<Position, Piece> positionToPieceMap, Player player) {

        if (Player.White == player) {
            return possibleMovesWhite(currentPosition, positionToPieceMap);
        } else {
            return possibleMovesBlack(currentPosition, positionToPieceMap);
        }
    }

    private List<Position> possibleMovesWhite(Position currentPosition, Map<Position, Piece> positionToPieceMap) {
        char x = currentPosition.getColumn();
        int y = currentPosition.getRow();

        moves = new ArrayList<>();

        // one move forward
        if ((x < Position.MAX_COLUMN) && (y + 1 < Position.MAX_ROW)) {
            Position position = new Position(x, y + 1);
            if (isAllowedPosition(positionToPieceMap, position)) {
                moves.add(position);
            }

        }

        // two move forward
        if (x < Position.MAX_COLUMN && y + 2 < Position.MAX_ROW && !isJumped()) {
            Position position = new Position(x, y + 2);
            if (isAllowedPosition(positionToPieceMap, position)) {
                moves.add(position);
            }
        }

        // diagonal move right (fire enemy piece)
        if (x + 1 < Position.MAX_COLUMN && y + 1 < Position.MAX_ROW) {
            Position position = new Position((char) (x + 1), y + 1);
            if (isAllowedPosition(positionToPieceMap, position)) {
                moves.add(position);
            }

        }

        // diagonal move left (fire enemy piece)
        if (x - 1 >= Position.MIN_COLUMN && y + 1 < Position.MAX_ROW) {
            Position position = new Position((char) (x - 1), y + 1);
            if (isAllowedPosition(positionToPieceMap, position)) {
                moves.add(position);
            }
        }

        return moves;

    }

    private List<Position> possibleMovesBlack(Position currentPosition, Map<Position, Piece> positionToPieceMap) {
        char x = currentPosition.getColumn();
        int y = currentPosition.getRow();

        moves = new ArrayList<>();

        // one move forward
        if ((x >= Position.MIN_COLUMN) && (y - 1 > Position.MIN_ROW)) {
            Position position = new Position(x, y - 1);
            if (isAllowedPosition(positionToPieceMap, position)) {
                moves.add(position);
            }

        }

        // two move forward
        if (x >= Position.MIN_COLUMN && y - 2 > Position.MIN_ROW && !isJumped()) {
            Position position = new Position(x, y - 2);
            if (isAllowedPosition(positionToPieceMap, position)) {
                moves.add(position);
            }
        }

        // diagonal move right (fire enemy piece)
        if (x - 1 >= Position.MIN_COLUMN && y - 1 >= Position.MIN_ROW) {
            Position position = new Position((char) (x - 1), y - 1);
            if (isAllowedPosition(positionToPieceMap, position)) {
                moves.add(position);
            }

        }

        // diagonal move left (fire enemy piece)
        if (x + 1 <= Position.MAX_COLUMN && y - 1 >= Position.MIN_ROW) {
            Position position = new Position((char) (x + 1), y - 1);
            if (isAllowedPosition(positionToPieceMap, position)) {
                moves.add(position);
            }
        }

        return moves;

    }

    public boolean isJumped() {
        return this.isJumped;
    }

}
