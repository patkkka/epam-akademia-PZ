/**
 * Created by Patka on 2017-05-29.
 */
public class RowCondition extends WinCondition {

    @Override
    public boolean checkCondition(int x, int y, char currentChar, char[][] boardState) {
        int n = boardState[0].length;
        //iterate rows
        for (int i = 0; i < n; i++){
            if (boardState[i][y] != currentChar){
                break;
            }
            if (i == n-1){
                return true;
            }
        }
        return false;
    }
}
