package chess.pieces;

import chess.Player;
import chess.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * The King class
 */
public class King extends Piece {
    public King(Player owner) {
        super(owner);
    }

    @Override
    protected char getIdentifyingCharacter() {
        return 'k';
    }

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

        // move in the horizontal right
        if ((x + 1) <= Position.MAX_COLUMN) {
            Position position = new Position((char) (x + 1), y);
            if (isAllowedPosition(positionToPieceMap, position)) {
                moves.add(position);
            }
        }

        // move in the horizontal left
        if ((x - 1) >= Position.MIN_COLUMN) {
            Position position = new Position((char) (x - 1), y);
            if (isAllowedPosition(positionToPieceMap, position)) {
                moves.add(position);
            }

        }
        // move in the vertical down
        if ((y + 1) <= Position.MAX_ROW) {
            Position position = new Position(x, y + 1);
            if (isAllowedPosition(positionToPieceMap, position)) {
                moves.add(position);
            }

        }
        // move in the vertical up
        if ((y - 1) >= Position.MIN_ROW) {
            Position position = new Position(x, y - 1);
            if (isAllowedPosition(positionToPieceMap, position)) {
                moves.add(position);
            }
        }
        // move in the down positive diagonal
        if ((x + 1) <= Position.MAX_COLUMN && (y + 1) <= Position.MAX_ROW) {
            Position position = new Position((char) (x + 1), y + 1);
            if (isAllowedPosition(positionToPieceMap, position)) {
                moves.add(position);
            }
        }
        // move in the up positive diagonal
        if ((x + 1) <= Position.MAX_COLUMN && (y - 1) >= Position.MIN_ROW) {
            Position position = new Position((char) (x + 1), y - 1);
            if (isAllowedPosition(positionToPieceMap, position)) {
                moves.add(position);
            }
        }
        // move in the up negative diagonal
        if ((x - 1) >= Position.MIN_COLUMN && (y - 1) >= Position.MIN_ROW) {
            Position position = new Position((char) (x - 1), y - 1);
            if (isAllowedPosition(positionToPieceMap, position)) {
                moves.add(position);
            }
        }
        // move in the down negative diagonal
        if ((x - 1) >= Position.MIN_COLUMN && (y + 1) <= Position.MAX_ROW) {
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

        // move in the horizontal right
        if ((x - 1) >= Position.MIN_COLUMN) {
            Position position = new Position((char) (x - 1), y);
            if (isAllowedPosition(positionToPieceMap, position)) {
                moves.add(position);
            }
        }

        // move in the horizontal left
        if ((x + 1) <= Position.MAX_COLUMN) {
            Position position = new Position((char) (x + 1), y);
            if (isAllowedPosition(positionToPieceMap, position)) {
                moves.add(position);
            }

        }
        // move in the vertical down
        if ((y - 1) >= Position.MIN_ROW) {
            Position position = new Position(x, y - 1);
            if (isAllowedPosition(positionToPieceMap, position)) {
                moves.add(position);
            }

        }
        // move in the vertical up
        if ((y + 1) <= Position.MAX_ROW) {
            Position position = new Position(x, y + 1);
            if (isAllowedPosition(positionToPieceMap, position)) {
                moves.add(position);
            }
        }
        // move in the down positive diagonal
        if ((x - 1) >= Position.MIN_COLUMN && (y - 1) >= Position.MIN_ROW) {
            Position position = new Position((char) (x - 1), y - 1);
            if (isAllowedPosition(positionToPieceMap, position)) {
                moves.add(position);
            }
        }
        // move in the up positive diagonal
        if ((x - 1) >= Position.MIN_COLUMN && (y + 1) <= Position.MAX_ROW) {
            Position position = new Position((char) (x - 1), y + 1);
            if (isAllowedPosition(positionToPieceMap, position)) {
                moves.add(position);
            }
        }
        // move in the up negative diagonal
        if ((x + 1) <= Position.MAX_COLUMN && (y + 1) <= Position.MAX_ROW) {
            Position position = new Position((char) (x + 1), y + 1);
            if (isAllowedPosition(positionToPieceMap, position)) {
                moves.add(position);
            }
        }
        // move in the down negative diagonal
        if ((x + 1) <= Position.MAX_COLUMN && (y - 1) >= Position.MIN_ROW) {
            Position position = new Position((char) (x + 1), y - 1);
            if (isAllowedPosition(positionToPieceMap, position)) {
                moves.add(position);
            }
        }

        return moves;
    }
}
