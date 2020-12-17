package com.rit;
import java.util.*;

public class Main {


    /**
     * This function prints out the game board that it was passed.
     * @param board is a list of 10 strings representing the board (ignore index 0).
     */
    public static void drawGameBoard(List<String> board){
        System.out.println(board.get(7) + " | " + board.get(8) + " | " + board.get(9));
        System.out.println("--+---+--");
        System.out.println(board.get(4) + " | " + board.get(5) + " | " + board.get(6));
        System.out.println("--+---+--");
        System.out.println(board.get(1) + " | " + board.get(2) + " | " + board.get(3));
    }

    /**
     * Lets the player type which letter they want to be.
     * @return Returns a list with the player's letter as the first item and the computer's letter as the second.
     */
    public static List<String> inputPlayerLetter(){
        Scanner input = new Scanner(System.in);
        String letter = "";
        while (!(letter.equals("X") || letter.equals("O"))){
            System.out.println("Do you want to be X or O ?");
            letter = input.next().toUpperCase();
        }
        // The first element in the list is the player's letter.
        // The second is the computer's letter.
        if(letter.equals("X"))
            return new ArrayList<>() {{add("X"); add("O");}};
        else
            return new ArrayList<>() {{add("O"); add("X");}};
    }

    /**
     * Randomly choose which player goes first.
     * @return
     */
    public static String whoGoesFirst(){
        Random random = new Random();
        if(random.nextInt(2) == 1)
            return "player";
        else
            return "computer";
    }

    /**
     * Simple makeMove function
     * @param board
     * @param letter
     * @param move
     */
    public static void makeMove(List<String> board, String letter, int move){
        board.set(move, letter);
    }

    /**
     * Return true if the passed move is free on the passed board.
     * @param move
     * @param board
     * @return
     */
    public static boolean isSpaceFree(int move, List<String> board){
        return board.get(move).equals(" ");
    }

    /**
     * Return true if every space on the board has been taken. Otherwise, return false.
     * @param gameBoard
     * @return
     */
    public static boolean isBoardFull(List<String> gameBoard){
        for (int i = 1; i < 10; i++) {
            if(isSpaceFree(i, gameBoard))
                return false;
        }
        return true;
    }

    /**
     * Given a board and a player's letter, this function returns True if that player has won.
     * We use "bo" instead of "board" and "le" instead of "letter" so we don't have to type as much.
     * @param bo
     * @param le
     * @return
     */
    public static boolean isWinner(List<String> bo, String le){
        return ( (bo.get(7).equals(le) && bo.get(8).equals(le) && bo.get(9).equals(le)) ||
                 (bo.get(4).equals(le) && bo.get(5).equals(le) && bo.get(6).equals(le)) ||
                 (bo.get(1).equals(le) && bo.get(2).equals(le) && bo.get(3).equals(le)) ||
                 (bo.get(7).equals(le) && bo.get(4).equals(le) && bo.get(1).equals(le)) ||
                 (bo.get(8).equals(le) && bo.get(5).equals(le) && bo.get(2).equals(le)) ||
                 (bo.get(9).equals(le) && bo.get(6).equals(le) && bo.get(3).equals(le)) ||
                 (bo.get(7).equals(le) && bo.get(5).equals(le) && bo.get(3).equals(le)) ||
                 (bo.get(9).equals(le) && bo.get(5).equals(le) && bo.get(1).equals(le)) );
    }

    /**
     * Make a copy of the board list and return it.
     * @param board
     * @return
     */
    public static List<String> getBoardCopy(List<String> board){
        List<String> boardCopy = new ArrayList<>();
        for (String value: board){
            boardCopy.add(value);
        }
        return boardCopy;
    }

    /**
     * Let the player enter their move.
     * @param board
     * @return
     */
    public static int getPlayerMove(List<String> board){
        Scanner input = new Scanner(System.in);
        String move = " ";
        while (!("123456789".contains(move)) || ! isSpaceFree(Integer.parseInt(move), board)){
            System.out.println("What is your next move (1-9): ");
            move = input.next();
        }
        return Integer.parseInt(move);
    }

    /**
     * Returns a valid move from the passed list on the passed board.
     * Returns 0 if there is no valid move.
     * @param board
     * @param movesList
     * @return
     */
    public static int chooseRandomMoveFromList(List<String> board, List<Integer> movesList){
        Random random = new Random();
        List<Integer> possibleMoves = new ArrayList<>();
        for(Integer item: movesList){
            if(isSpaceFree(item, board))
                possibleMoves.add(item);
        }
        if(possibleMoves.size() != 0)
            return possibleMoves.get(random.nextInt(possibleMoves.size()));
        else
            return 0;
    }

    /**
     * Given a board and the computer's letter,
     * determine where to move and return that move.
     * @param board
     * @param computerLetter
     * @return
     */
    public static int getComputerMove(List<String> board, String computerLetter){

        String playerLetter = "";
        if(computerLetter.equals("X"))
            playerLetter = "O";
        else
            playerLetter = "X";

        // Here is the algorithm for our Tic-Tac-Toe AI:
        // First, check if we can win in the next move.
        List<String> boardCopy = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            boardCopy = getBoardCopy(board);
            if(isSpaceFree(i, boardCopy)){
                makeMove(boardCopy, computerLetter, i);
                if(isWinner(boardCopy, computerLetter))
                    return i;
            }
        }

        // Check if the player could win on their next move and block them.
        for (int i = 1; i < 10; i++) {
            boardCopy = getBoardCopy(board);
            if(isSpaceFree(i, boardCopy)){
                makeMove(boardCopy, playerLetter, i);
                if(isWinner(boardCopy, playerLetter))
                    return i;
            }
        }

        // Try to take one of the corners, if they are free.
        int move = chooseRandomMoveFromList(board, new ArrayList<>(Arrays.asList(1, 3, 7, 9)));
        if(move != 0)
            return move;

        // Try too take the center, if it is free.
        if(isSpaceFree(5, board))
            return 5;

        // Move on one of the sides.
        return chooseRandomMoveFromList(board, new ArrayList<>(Arrays.asList(2, 4, 6, 8)));
    }

    /**
     * Return True if the player wants to play again. Otherwise, return False.
     * @return
     */
    public static boolean playAgain(){
        Scanner input = new Scanner(System.in);
        System.out.println("Do you want to play again? (yes or no): ");
        return input.next().toLowerCase().startsWith("y");  // No
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Tic-Tac-Toe AI Game");
        // The Game Loop ...
        while (true){
            // Reset the board.
            List<String> theGameBoard = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                theGameBoard.add(" ");
            }

            List<String> playerList = inputPlayerLetter();
            String playerLetter = playerList.get(0);
            String computerLetter = playerList.get(1);

            String turn = whoGoesFirst();
            System.out.println("The " + turn + " will go first.");

            boolean gameIsPlaying = true;

            while (gameIsPlaying){
                if(turn == "player"){
                    // Player's turn
                    drawGameBoard(theGameBoard);
                    int move = getPlayerMove(theGameBoard);
                    makeMove(theGameBoard, playerLetter, move);

                    if(isWinner(theGameBoard, playerLetter)){
                        drawGameBoard(theGameBoard);
                        System.out.println("Amazing! You have won the game :)");
                        gameIsPlaying = false;
                    }
                    else{
                        if(isBoardFull(theGameBoard)){
                            drawGameBoard(theGameBoard);
                            System.out.println("The game is draw!");
                            break;
                        }
                        else
                            turn = "computer";
                    }
                }
                else {
                    // Computer's turn
                    int move = getComputerMove(theGameBoard, computerLetter);
                    makeMove(theGameBoard, computerLetter, move);

                    if(isWinner(theGameBoard, computerLetter)){
                        drawGameBoard(theGameBoard);
                        System.out.println("The Computer has beaten you!. You Lose.");
                        gameIsPlaying = false;
                    }
                    else{
                        if(isBoardFull(theGameBoard)){
                            drawGameBoard(theGameBoard);
                            System.out.println("The game is draw!");
                            break;
                        }
                        else
                            turn = "player";
                    }
                }
            }

            if(!playAgain()){
                break;
            }
        }
    }
}

// Happy Learning
// @mrizwanse
