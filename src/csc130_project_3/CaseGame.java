
package csc130_project_3;

public class CaseGame {
    
    public static void playFirstTurn(gameFrame frame_in) {
        System.out.println("playing first turn");
        frame_in.changeCaseCount(1);
        
    }
    
    public static void playFirstRound(gameFrame frame_in) {
        System.out.println("playing first round");
        //frame_in.changeCaseCount(6);
    }
    
    
    public static void main(String[] args) {

        
        gameFrame frame = new gameFrame(); //initializing GUI
        
        playFirstTurn(frame);
        playFirstRound(frame);
 

    }
    
}