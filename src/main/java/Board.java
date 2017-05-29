/**
 * Created by Patka on 2017-05-29.
 */
public class Board {
    private char [][] boardState;
    private int lastMoveX;
    private int lastMoveY;
    public static final char empty = '\u0000';

    public Board() {
        this.boardState = new char[3][3];
    }

    public Board(int x, int y) {
        this.boardState = new char[x][y];
    }

    public void addMove(int x, int y, char gameChar){
        boardState[x][y] = gameChar;
        this.lastMoveX = x;
        this.lastMoveY = y;
    }

    public char getBoardChar(int x, int y){
        return boardState[x][y];
    }

    public void printBoardState(){
        for (int i=0; i < boardState.length; i++){
            for (int j=0; j < boardState[0].length; j++) {
                if (boardState[i][j] == empty){
                    System.out.print("-");
                } else {
                    System.out.print(boardState[i][j]);
                }
            }
            System.out.println();
        }
    }

    public char[][] getBoardState() {
        return boardState;
    }

    public int getLastMoveX() {
        return lastMoveX;
    }

    public int getLastMoveY() {
        return lastMoveY;
    }

    public boolean checkIfBoardFull(){
        for (int i=0; i < boardState.length; i++){
            for (int j=0; j < boardState[0].length; j++) {
                if (boardState[i][j] == empty){
                    return false;
                }
            }
        }
        return true;
    }
}
