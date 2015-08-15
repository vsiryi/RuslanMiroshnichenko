package chess.pieces;

import chess.Player;
import chess.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * The Knight class
 */
public class Knight extends Piece {
    public Knight(Player owner) {
        super(owner);
    }

    @Override
    protected char getIdentifyingCharacter() {
        return 'n';
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

        //check (x+1,y+2)
        if (x + 1 <= Position.MAX_COLUMN && y + 2 <= Position.MAX_ROW) {
            Position position = new Position((char) (x + 1), y + 2);
            if (isAllowedPosition(positionToPieceMap, position)) {
                moves.add(position);
            }
        }

        //check (x+1,y-2)
        if (x + 1 <= Position.MAX_COLUMN && y - 2 >= Position.MIN_ROW) {
            Position position = new Position((char) (x + 1), y - 2);
            if (isAllowedPosition(positionToPieceMap, position)) {
                moves.add(position);
            }

        }

        //check (x-1,y+2)
        if (x - 1 >= Position.MIN_COLUMN && y + 2 <= Position.MAX_ROW) {
            Position position = new Position((char) (x - 1), y + 2);
            if (isAllowedPosition(positionToPieceMap, position)) {
                moves.add(position);
            }

        }

        //check (x-1,y-2)
        if (x - 1 >= Position.MIN_COLUMN && y - 2 >= Position.MIN_ROW) {
            Position position = new Position((char) (x - 1), y - 2);
            if (isAllowedPosition(positionToPieceMap, position)) {
                moves.add(position);
            }
        }

        //check (x+2,y+1)
        if (y + 1 <= Position.MAX_ROW && x + 2 <= Position.MAX_COLUMN) {
            Position position = new Position((char) (x + 2), y + 1);
            if (isAllowedPosition(positionToPieceMap, position)) {
                moves.add(position);
            }
        }

        // check (x-2,y+1)
        if (y + 1 <= Position.MAX_ROW && x - 2 >= Position.MIN_COLUMN) {
            Position position = new Position((char) (x - 2), y + 1);
            if (isAllowedPosition(positionToPieceMap, position)) {
                moves.add(position);
            }
        }

        //check (x+2,y-1)
        if (y - 1 >= Position.MIN_ROW && x + 2 <= Position.MAX_COLUMN) {
            Position position = new Position((char) (x + 2), y - 1);
            if (isAllowedPosition(positionToPieceMap, position)) {
                moves.add(position);
            }

        }

        //check (x-2,y-1)
        if (y - 1 >= Position.MIN_ROW && x - 2 >= Position.MIN_COLUMN) {
            Position position = new Position((char) (x - 2), y - 1);
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

        //check (x+1,y+2)
        if (x - 1 >= Position.MIN_COLUMN && y - 2 >= Position.MIN_ROW) {
            Position position = new Position((char) (x - 1), y - 2);
            if (isAllowedPosition(positionToPieceMap, position)) {
                moves.add(position);
            }
        }

        //check (x+1,y-2)
        if (x - 1 >= Position.MIN_COLUMN && y + 2 <= Position.MAX_ROW) {
            Position position = new Position((char) (x - 1), y + 2);
            if (isAllowedPosition(positionToPieceMap, position)) {
                moves.add(position);
            }

        }

        //check (x-1,y+2)
        if (x + 1 <= Position.MAX_COLUMN && y - 2 >= Position.MIN_ROW) {
            Position position = new Position((char) (x + 1), y - 2);
            if (isAllowedPosition(positionToPieceMap, position)) {
                moves.add(position);
            }

        }

        //check (x-1,y-2)
        if (x + 1 <= Position.MAX_COLUMN && y + 2 <= Position.MAX_ROW) {
            Position position = new Position((char) (x + 1), y + 2);
            if (isAllowedPosition(positionToPieceMap, position)) {
                moves.add(position);
            }
        }

        //check (x+2,y+1)
        if (y - 1 >= Position.MIN_ROW && x - 2 >= Position.MIN_COLUMN) {
            Position position = new Position((char) (x - 2), y - 1);
            if (isAllowedPosition(positionToPieceMap, position)) {
                moves.add(position);
            }
        }

        // check (x-2,y+1)
        if (y - 1 >= Position.MIN_ROW && x + 2 <= Position.MAX_COLUMN) {
            Position position = new Position((char) (x + 2), y - 1);
            if (isAllowedPosition(positionToPieceMap, position)) {
                moves.add(position);
            }
        }

        //check (x+2,y-1)
        if (y + 1 <= Position.MAX_ROW && x - 2 >= Position.MIN_COLUMN) {
            Position position = new Position((char) (x - 2), y + 1);
            if (isAllowedPosition(positionToPieceMap, position)) {
                moves.add(position);
            }

        }

        //check (x-2,y-1)
        if (y + 1 <= Position.MAX_ROW && x + 2 <= Position.MAX_COLUMN) {
            Position position = new Position((char) (x + 2), y + 1);
            if (isAllowedPosition(positionToPieceMap, position)) {
                moves.add(position);
            }
        }

        return moves;
    }

}