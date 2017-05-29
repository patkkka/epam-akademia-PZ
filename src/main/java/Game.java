import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Patka on 2017-05-29.
 */
public class Game {
    private Player player1;
    private Player player2;
    private Board board;

    private Player currentPlayer;
    private Player winner;

    private List<WinCondition> winConditions = new ArrayList<WinCondition>();

    private static Scanner scanner = new Scanner(System.in);

    public Game(Player player1, Player player2, Board board) {
        this.player1 = player1;
        this.player2 = player2;
        this.board = board;

        WinCondition rowCondition = new RowCondition();
        WinCondition colCondition = new ColumnCondition();
        WinCondition diagCondition = new DiagCondition();
        WinCondition adiagCondition = new AntiDiagCondition();

        winConditions.add(rowCondition);
        winConditions.add(colCondition);
        winConditions.add(diagCondition);
        winConditions.add(adiagCondition);
    }

    public void start(){
        System.out.println("Who goes first? X or O");
        String input = scanner.nextLine();
        char firstPlayer = input.charAt(0);
        if (firstPlayer == player1.getGameChar()){
            currentPlayer = player1;
        } else {
            currentPlayer = player2;
        }
    }

    public void play(){
        while(true){
            System.out.println("Player " + currentPlayer.getGameChar() +
                    " please insert integer x(row) and y(column) where you want to put your character");
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            currentPlayer.move(x,y,board);

            board.printBoardState();

            if (checkGameWon()){
                System.out.println("Game finished!");
                System.out.println("The winner is " + currentPlayer.getGameChar());
                break;
            }
            if (checkGameTie()){
                System.out.println("Game finished! Board is full. There is no winner.");
            }
            currentPlayer = nextPlayer();
        }
    }

    public boolean checkGameWon(){
        char currentChar = currentPlayer.getGameChar();
        char [][] boardState = board.getBoardState();
        int x = board.getLastMoveX();
        int y = board.getLastMoveY();

        for (WinCondition wc: winConditions){
            if (wc.checkCondition(x,y,currentChar,boardState)){
                winner = currentPlayer;
                return true;
            }
        }
        return false;
    }

    public boolean checkGameTie(){
        return board.checkIfBoardFull();
    }

    public Player nextPlayer(){
        if (currentPlayer == player1){
            return player2;
        }
        else {
            return player1;
        }
    }
}
