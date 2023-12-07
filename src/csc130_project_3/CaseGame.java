
package csc130_project_3;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CaseGame {
    
    Integer[] caseValuesArray = { 1, 5, 10, 25, 50, 75, 100, 200, 300, 400, 
                            500, 750, 1000, 5000, 10000, 25000, 50000, 
                            75000, 100000, 200000, 300000, 400000, 
                            500000, 750000, 1000000 };
    
    //Shuffling caseValuesArray
    
    
    //gameFrame frame = new gameFrame();
    
    int totalCasesLeft = 25; // how many cases are left in play
    int casesToOpen = 0; // how many cases left to open in current round
    
    public static void choosePlayerCase(gameFrame frame_in) {
        System.out.println("in choosePlayerCase");
        //frame_in.topLabel.setText("CHOOSE YOUR CASE");
        //frame_in.updateCasesToOpen(1);
        //frame_in.updateCasesToOpen(5);
        
        openCases(1); //instead of frame_in.updateCasesToOpen;
        
        System.out.println("out choosePlayerCase");
    }
    
    public static void openCases(int n) { //(gameFrame frame_in, int caseCount) {
        //System.out.println("Opening cases");
        //frame_in.updateCasesToOpen(6);
        while(n > 0) {
            System.out.println("     n = " + n);
            //action click here?
            
            
            
            n--;
        }
        
    }
    
    
    public static void main(String[] args) {
        
    //    List<Integer> intList;
    //intList = Arrays.asList(caseValuesArray);
    //Collections.shuffle(intList);
    //intList.toArray(caseValuesArray);
    
    //    shuffle();

        
        gameFrame frame = new gameFrame(); //initializing GUI
        
        
        
        choosePlayerCase(frame);
        //this needs to printed after the first case has been clicked
        
        //openCases(frame, 6);
 

    }

    private static class caseValuesArray {

        public caseValuesArray() {
        }
    }
    
}