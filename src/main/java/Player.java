/**
 * Created by Patka on 2017-05-29.
 */
public class Player {
    private String name;
    private char gameChar;

    public Player(String name, char gameChar) {
        this.name = name;

        char ucGameChar = Character.toUpperCase(gameChar);
        if (ucGameChar == 'X' || ucGameChar == 'O') {  //Arrays.asList(gameChars.getGameChars()).contains(ucGameChar)
            this.gameChar = ucGameChar;
        } else {
            throw new IllegalArgumentException("Player can use only specified game character");
        }
    }

    public void move(int x, int y, Board board){

    }
}
