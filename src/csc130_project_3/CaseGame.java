
package csc130_project_3;

import java.util.Collections;
import java.util.Arrays;
import java.util.List;


public class CaseGame {
    
    
    public static void printArray(Integer[] array) {
        int n = array.length;
        for(int i = 0; i < n; i++) {
            System.out.print(array[i] + " ");
        }
    }
    
    public static void main(String[] args) {
        
        System.out.println("Case Game test.");
        
        
        Integer[] defaultCaseArray = { 1, 5, 10, 25, 50, 75, 100, 200, 300, 400, 
                            500, 750, 1000, 5000, 10000, 25000, 50000, 
                            75000, 100000, 200000, 300000, 400000, 
                            500000, 750000, 1000000 };
        
        
        printArray(defaultCaseArray);
        System.out.println();
        
        //Shuffling the cases
        List<Integer> intList;
        intList = Arrays.asList(defaultCaseArray);
        Collections.shuffle(intList);
        intList.toArray(defaultCaseArray);
        
        //Printing test
        printArray(defaultCaseArray);
        System.out.println("\n" + defaultCaseArray[2]);
        
        
        
        
    
    }
    
}
