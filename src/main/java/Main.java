/**
 * Created by Patka on 2017-05-28.
 */
public class Main {
    public static void main(String[] args) {
        Player player1 = new Player("XXX",'X');
        Player player2 = new Player("YYY", 'O');

        Board board = new Board();

        Game game = new Game(player1, player2, board);

     //   game.start();
        board.printBoardState();

    }
}
