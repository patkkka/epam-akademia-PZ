/**
 * Created by Patka on 2017-05-29.
 */
public abstract class WinCondition {

    public WinCondition() {
    }

    public abstract boolean checkCondition(int x, int y, char currentChar, char [][] boardState);
}
