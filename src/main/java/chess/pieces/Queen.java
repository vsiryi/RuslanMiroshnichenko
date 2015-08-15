package chess.pieces;

import chess.Player;
import chess.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * The Queen
 */
public class Queen extends Piece {
    public Queen(Player owner) {
        super(owner);
    }

    @Override
    protected char getIdentifyingCharacter() {
        return 'q';
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

        // moves in the vertical up
        for (int j = y + 1; j <= Position.MAX_ROW; j++) {
            Position position = new Position(x, j);
            if (isAllowedPosition(positionToPieceMap, position)) {
                moves.add(position);
            } else {
                break;
            }
        }

        // moves in the vertical down
        for (int j = y - 1; j >= Position.MIN_ROW; j--) {
            Position position = new Position(x, j);
            if (isAllowedPosition(positionToPieceMap, position)) {
                moves.add(position);
            } else {
                break;
            }
        }

        // moves in the right up diagonal
        for (int j = y + 1, i = x + 1; j <= Position.MAX_ROW && i <= Position.MAX_COLUMN; j++, i++) {
            Position position = new Position((char) i, j);
            if (isAllowedPosition(positionToPieceMap, position)) {
                moves.add(position);
            } else {
                break;
            }

        }

        // moves in the right down diagonal
        for (int j = y - 1, i = x + 1; j >= Position.MIN_ROW && i <= Position.MAX_COLUMN; j--, i++) {
            Position position = new Position((char) i, j);
            if (isAllowedPosition(positionToPieceMap, position)) {
                moves.add(position);
            } else {
                break;
            }
        }

        // moves in the left down diagonal
        for (int j = y - 1, i = x - 1; j >= Position.MIN_ROW && i >= Position.MIN_COLUMN; j--, i--) {
            Position position = new Position((char) i, j);
            if (isAllowedPosition(positionToPieceMap, position)) {
                moves.add(position);
            } else {
                break;
            }
        }

        //all possible moves in the left up diagonal
        for (int j = y + 1, i = x - 1; j <= Position.MAX_ROW && i >= Position.MIN_COLUMN; j++, i--) {
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

        // moves in the vertical up
        for (int j = y - 1; j >= Position.MIN_ROW; j--) {
            Position position = new Position(x, j);
            if (isAllowedPosition(positionToPieceMap, position)) {
                moves.add(position);
            } else {
                break;
            }
        }

        // moves in the vertical down
        for (int j = y + 1; j <= Position.MAX_ROW; j++) {
            Position position = new Position(x, j);
            if (isAllowedPosition(positionToPieceMap, position)) {
                moves.add(position);
            } else {
                break;
            }
        }

        // moves in the right up diagonal
        for (int j = y - 1, i = x - 1; j >= Position.MIN_ROW && i >= Position.MIN_COLUMN; j--, i--) {
            Position position = new Position((char) i, j);
            if (isAllowedPosition(positionToPieceMap, position)) {
                moves.add(position);
            } else {
                break;
            }

        }

        // moves in the right down diagonal
        for (int j = y + 1, i = x - 1; j <= Position.MAX_ROW && i >= Position.MIN_COLUMN; j++, i--) {
            Position position = new Position((char) i, j);
            if (isAllowedPosition(positionToPieceMap, position)) {
                moves.add(position);
            } else {
                break;
            }
        }

        // moves in the left down diagonal
        for (int j = y + 1, i = x + 1; j <= Position.MAX_ROW && i <= Position.MAX_COLUMN; j++, i++) {
            Position position = new Position((char) i, j);
            if (isAllowedPosition(positionToPieceMap, position)) {
                moves.add(position);
            } else {
                break;
            }
        }

        //all possible moves in the left up diagonal
        for (int j = y - 1, i = x + 1; j >= Position.MIN_ROW && i <= Position.MAX_COLUMN; j--, i++) {
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
