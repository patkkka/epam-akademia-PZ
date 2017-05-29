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

    private List<WinCondition> winConditions;

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
        while(true)
        {

            currentPlayer = nextPlayer();
        }
    }

    public boolean checkGameFinished(){
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

    public Player nextPlayer(){
        if (currentPlayer == player1){
            return player2;
        }
        else {
            return player1;
        }
    }
}
