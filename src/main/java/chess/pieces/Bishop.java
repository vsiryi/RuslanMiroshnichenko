package chess.pieces;

import chess.Player;
import chess.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * The 'Bishop' class
 */
public class Bishop extends Piece {
    public Bishop(Player owner) {
        super(owner);
    }

    @Override
    protected char getIdentifyingCharacter() {
        return 'b';
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

        // moves in the up right diagonal
        for (int j = y + 1, i = x + 1; j <= Position.MAX_ROW && i <= Position.MAX_COLUMN; j++, i++) {
            Position position = new Position((char) i, j);
            if (isAllowedPosition(positionToPieceMap, position)) {
                moves.add(position);
            } else {
                break;
            }

        }

        // moves in the up left diagonal
        for (int j = y + 1, i = x - 1; j <= Position.MAX_ROW && i >= Position.MIN_COLUMN; j++, i--) {
            Position position = new Position((char) i, j);
            if (isAllowedPosition(positionToPieceMap, position)) {
                moves.add(position);
            } else {
                break;
            }

        }

        // moves in the down right diagonal
        for (int j = y - 1, i = x + 1; j >= Position.MIN_ROW && i <= Position.MAX_COLUMN; j--, i++) {
            Position position = new Position((char) i, j);
            if (isAllowedPosition(positionToPieceMap, position)) {
                moves.add(position);
            } else {
                break;
            }
        }

        // moves in the down left diagonal
        for (int j = y - 1, i = x - 1; j >= Position.MIN_ROW && i >= Position.MIN_COLUMN; j--, i--) {
            Position position = new Position((char) i, j);
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

        // moves in the up right diagonal
        for (int j = y - 1, i = x - 1; j >= Position.MIN_ROW && i >= Position.MIN_COLUMN; j--, i--) {
            Position position = new Position((char) i, j);
            if (isAllowedPosition(positionToPieceMap, position)) {
                moves.add(position);
            } else {
                break;
            }

        }

        // moves in the up left diagonal
        for (int j = y - 1, i = x + 1; j >= Position.MIN_ROW && i <= Position.MAX_COLUMN; j--, i++) {
            Position position = new Position((char) i, j);
            if (isAllowedPosition(positionToPieceMap, position)) {
                moves.add(position);
            } else {
                break;
            }

        }

        // moves in the down right diagonal
        for (int j = y + 1, i = x - 1; j <= Position.MAX_ROW && i >= Position.MIN_COLUMN; j++, i--) {
            Position position = new Position((char) i, j);
            if (isAllowedPosition(positionToPieceMap, position)) {
                moves.add(position);
            } else {
                break;
            }
        }

        // moves in the down left diagonal
        for (int j = y + 1, i = x + 1; j <= Position.MAX_ROW && i <= Position.MAX_COLUMN; j++, i++) {
            Position position = new Position((char) i, j);
            if (isAllowedPosition(positionToPieceMap, position)) {
                moves.add(position);
            } else {
                break;
            }

        }

        return moves;

    }

}