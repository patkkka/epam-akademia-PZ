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

    public void play(){
        while(true){
            playOneGame();
            Player leader = checkWhoIsWinning();
            if (leader == null){
                System.out.println("Draw.");
            } else {
                System.out.println("Player " + leader.getGameChar() + " is leading.");
            }
            System.out.println("Player " + player1.getGameChar() + ": " + player1.getPoints());
            System.out.println("Player " + player2.getGameChar() + ": " + player2.getPoints());

            System.out.println("Do you want to play once again? Y/N");
            String input = scanner.nextLine();
            if (input == "Y"){
                continue;
            } else {
                break;
            }
        }
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

    public void playOneGame(){
        while(true){
            System.out.println("Player " + currentPlayer.getGameChar() + " turn: " +
                    " \nPlease insert row and column values, where you want to put your character (separated by space) and press Enter");
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            currentPlayer.move(x,y,board);

            board.printBoardState();

            if (checkGameWon()){
                System.out.println("Game finished!");
                System.out.println("The winner is " + currentPlayer.getGameChar());
                currentPlayer.addPoint();
                break;
            }
            if (checkGameTie()){
                System.out.println("Game finished! Board is full. There is no winner.");
                break;
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

    public Player checkWhoIsWinning (){
        if (player1.getPoints() > player2.getPoints()){
            return player1;
        } else if (player2.getPoints() > player1.getPoints()){
            return player2;
        } else {
            return null;
        }
    }
}
