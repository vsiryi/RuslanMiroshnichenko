package chess;

import chess.pieces.Piece;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class provides the basic CLI interface to the Chess game.
 */
public class CLI {
    private static final String NEWLINE = System.getProperty("line.separator");

    private final BufferedReader inReader;
    private final PrintStream outStream;

    private GameState gameState = null;

    public CLI(InputStream inputStream, PrintStream outStream) {
        this.inReader = new BufferedReader(new InputStreamReader(inputStream));
        this.outStream = outStream;
        writeOutput("Welcome to Chess!");
    }

    /**
     * Write the string to the output
     *
     * @param str The string to write
     */
    private void writeOutput(String str) {
        this.outStream.println(str);
    }

    /**
     * Retrieve a string from the console, returning after the user hits the 'Return' key.
     *
     * @return The input from the user, or an empty-length string if they did not type anything.
     */
    private String getInput() {
        try {
            this.outStream.print("> ");
            return inReader.readLine();
        } catch (IOException e) {
            throw new RuntimeException("Failed to read from input: ", e);
        }
    }

    void startEventLoop() {
        writeOutput("Type 'help' for a list of commands.");
        doNewGame();

        while (true) {
            showBoard();
            writeOutput(gameState.getCurrentPlayer() + "'s Move");

            String input = getInput();
            if (input == null) {
                break; // No more input possible; this is the only way to exit the event loop
            } else if (input.length() > 0) {
                if (input.equals("help")) {
                    showCommands();
                } else if (input.equals("new")) {
                    doNewGame();
                } else if (input.equals("quit")) {
                    writeOutput("Goodbye!");
                    System.exit(0);
                } else if (input.equals("board")) {
                    writeOutput("Current Game:");
                } else if (input.equals("list")) {
                    showPossibleMoves();
                } else if (input.startsWith("move")) {
                    movePieceOperation(input);
                } else {
                    writeOutput("I didn't understand that.  Type 'help' for a list of commands.");
                }
            }
        }
    }

    private void doNewGame() {
        gameState = new GameState();
        gameState.reset();
    }

    /**
     * Show list of possible moves
     */
    private void showPossibleMoves() {
        writeOutput(gameState.getCurrentPlayer() + "'s Possible moves:");

        StringBuilder possibleMoves = new StringBuilder();

        Map<Position, List<Position>> possibleMoveMap = getPossibleMoves();

        for (Map.Entry<Position, List<Position>> pieceItem : possibleMoveMap.entrySet()) {

            Position fromPosition = pieceItem.getKey();
            List<Position> toPositionList = pieceItem.getValue();

            for (Position toPositionItem : toPositionList) {
                possibleMoves.append(fromPosition).append("->").append(toPositionItem).append("\n");
            }
        }

        writeOutput(possibleMoves.toString());

    }

    private Map<Position, List<Position>> getPossibleMoves() {
        HashMap<Position, List<Position>> possibleMoveMap = new HashMap<>();

        Map<Position, Piece> pieceMap = gameState.getPieceMap(gameState.getCurrentPlayer());

        for (Map.Entry<Position, Piece> pieceItem : pieceMap.entrySet()) {

            Position position = pieceItem.getKey();
            Piece piece = pieceItem.getValue();

            List<Position> possibleMovesList = piece.possibleMoves(position, pieceMap, gameState.getCurrentPlayer());

            possibleMoveMap.put(position, possibleMovesList);

        }


        return possibleMoveMap;
    }

    private void movePieceOperation(String input) {
        String[] moveCommandItems = input.split("\\s+");

        if (moveCommandItems.length != 3) {
            writeOutput("Not allowed move command");
            return;
        }

        Position positionFrom = new Position(moveCommandItems[1]);
        Position positionTo = new Position(moveCommandItems[2]);

        Map<Position, List<Position>> possibleMoves = getPossibleMoves();

        List<Position> positions = possibleMoves.get(positionFrom);

        if (positions != null && positions.contains(positionTo)) {
            //Perform move operation
            gameState.movePiece(positionFrom, positionTo);

            //Switch current user
            if (Player.White == gameState.getCurrentPlayer()) {
                gameState.setCurrentPlayer(Player.Black);
            } else {
                gameState.setCurrentPlayer(Player.White);
            }

            //CheckMate
            if (checkMate()) {
                writeOutput("The game is over. Congrats to " + gameState.getCurrentPlayer());
                System.exit(0);
            }

        } else {
            writeOutput("Not allowed move command");
        }
    }

    public boolean checkMate() {
        //TODO: Implement Checkmate functionality
        return false;
    }

    private void showBoard() {
        writeOutput(getBoardAsString());
    }

    private void showCommands() {
        writeOutput("Possible commands: ");
        writeOutput("    'help'                       Show this menu");
        writeOutput("    'quit'                       Quit Chess");
        writeOutput("    'new'                        Create a new game");
        writeOutput("    'board'                      Show the chess board");
        writeOutput("    'list'                       List all possible moves");
        writeOutput("    'move <colrow> <colrow>'     Make a move");
    }

    /**
     * Display the board for the user(s)
     */
    String getBoardAsString() {
        StringBuilder builder = new StringBuilder();
        builder.append(NEWLINE);

        printColumnLabels(builder);
        for (int i = Position.MAX_ROW; i >= Position.MIN_ROW; i--) {
            printSeparator(builder);
            printSquares(i, builder);
        }

        printSeparator(builder);
        printColumnLabels(builder);

        return builder.toString();
    }


    private void printSquares(int rowLabel, StringBuilder builder) {
        builder.append(rowLabel);

        for (char c = Position.MIN_COLUMN; c <= Position.MAX_COLUMN; c++) {
            Piece piece = gameState.getPieceAt(String.valueOf(c) + rowLabel);
            char pieceChar = piece == null ? ' ' : piece.getIdentifier();
            builder.append(" | ").append(pieceChar);
        }
        builder.append(" | ").append(rowLabel).append(NEWLINE);
    }

    private void printSeparator(StringBuilder builder) {
        builder.append("  +---+---+---+---+---+---+---+---+").append(NEWLINE);
    }

    private void printColumnLabels(StringBuilder builder) {
        builder.append("   ");
        for (char c = Position.MIN_COLUMN; c <= Position.MAX_COLUMN; c++) {
            builder.append(" ").append(c).append("  ");
        }

        builder.append(NEWLINE);
    }

    public static void main(String[] args) {
        CLI cli = new CLI(System.in, System.out);
        cli.startEventLoop();
    }
}
