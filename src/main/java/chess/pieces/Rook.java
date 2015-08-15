package chess.pieces;

import chess.Player;
import chess.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * The 'Rook' class
 */
public class Rook extends Piece {

    public Rook(Player owner) {
        super(owner);
    }

    @Override
    protected char getIdentifyingCharacter() {
        return 'r';
    }


    /**
     * Calculate possible moves of Rook from current position
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

        // moves in the horizontal right
        for (int i = x + 1; i <= Position.MAX_COLUMN; i++) {
            Position position = new Position((char) i, y);
            if (isAllowedPosition(positionToPieceMap, position)) {
                moves.add(position);
            } else {
                break;
            }

        }

        // moves in the horizontal left
        for (int i = x - 1; i >= Position.MIN_COLUMN; i--) {
            Position position = new Position((char) i, y);
            if (isAllowedPosition(positionToPieceMap, position)) {
                moves.add(position);
            } else {
                break;
            }

        }

        //all possible moves in the vertical down
        for (int j = y + 1; j <= Position.MAX_ROW; j++) {
            Position position = new Position(x, j);
            if (isAllowedPosition(positionToPieceMap, position)) {
                moves.add(position);
            } else {
                break;
            }

        }

        // moves in the vertical up
        for (int j = y - 1; j >= Position.MIN_ROW; j--) {
            Position position = new Position(x, j);
            if (isAllowedPosition(positionToPieceMap, position)) {
                moves.add(position);
            } else {
                break;
            }
        }
        return moves;

    }

    private List<Position> possibleMovesBlack(Position currentPosition, Map<Position, Piece> positionToPieceMap) {

        char x = currentPosition.getColumn();
        int y = currentPosition.getRow();

        moves = new ArrayList<>();

        // moves in the horizontal right
        for (int i = x - 1; i >= Position.MIN_COLUMN; i--) {
            Position position = new Position((char) i, y);
            if (isAllowedPosition(positionToPieceMap, position)) {
                moves.add(position);
            } else {
                break;
            }

        }

        // moves in the horizontal left
        for (int i = x + 1; i <= Position.MAX_COLUMN; i++) {
            Position position = new Position((char) i, y);
            if (isAllowedPosition(positionToPieceMap, position)) {
                moves.add(position);
            } else {
                break;
            }

        }

        //all possible moves in the vertical down
        for (int j = y - 1; j >= Position.MIN_ROW; j--) {
            Position position = new Position(x, j);
            if (isAllowedPosition(positionToPieceMap, position)) {
                moves.add(position);
            } else {
                break;
            }

        }

        // moves in the vertical up
        for (int j = y + 1; j <= Position.MAX_ROW; j++) {
            Position position = new Position(x, j);
            if (isAllowedPosition(positionToPieceMap, position)) {
                moves.add(position);
            } else {
                break;
            }
        }
        return moves;

    }

}
