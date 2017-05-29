/**
 * Created by Patka on 2017-05-29.
 */
public class Player {
    private String name;
    private char gameChar;
    private int points;

    public Player(String name, char gameChar) {
        this.name = name;

        char ucGameChar = Character.toUpperCase(gameChar);
        if (ucGameChar == 'X' || ucGameChar == 'O') {  //Arrays.asList(gameChars.getGameChars()).contains(ucGameChar)
            this.gameChar = ucGameChar;
        } else {
            throw new IllegalArgumentException("Player can use only specified game character");
        }

        this.points = 0;
    }

    public boolean move(int x, int y, Board board){
        if (board.getBoardChar(x,y) == Board.empty) {
            board.addMove(x, y, this.gameChar);
            return true;
        }
        return false;
    }

    public char getGameChar() {
        return gameChar;
    }

    public void addPoint(){
        this.points++;
    }

    public int getPoints() {
        return points;
    }
}
