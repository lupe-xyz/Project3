package csc130_project_3;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class gameFrame extends JFrame implements ActionListener {
    
    //declaring variables/arrays
    int bankOffer = 0; //money offered to player
    int prizeFactor = 0; //denominator for offer, it increases as game goes on, to 100
    int casesToOpen = 0; //how many cases left to open before next bank offer
    int numCasesOpened = 0; //was caseCount_yourCase
    int casesInRound = 1; // keeps track of cases left to choose. Initialized with 1 because player chooses 1 case to start.
    boolean isFirstTurn = true; //changes to false after the first turn
    
    
    
    //declaring GUI components
    JLabel topLabel; //holds the "CHOOSE X CASE(S)" text at the top of the frame
    JLabel bottomLabel;
    JButton bDeal;
    JButton bNoDeal;
    JButton[] caseButtons = new JButton[25]; //cases labeled 1-25
    JCheckBox[] checkBoxes = new JCheckBox[25]; //labeled with the prize values
    JPanel casePanel; //center panel holding caseButtons
    JPanel leftPanel; //left side of GUI, first 13 prize values
    JPanel rightPanel; //right side of GUI, last 12 prize values
    ImageIcon xIcon; //Icon for checkBoxes when selected    
    
    
    //all three arrays use the values from this array
    Integer[] playValues = { 1, 5, 10, 25, 50, 75, 100, 200, 300, 400, 
                            500, 750, 1000, 5000, 10000, 25000, 50000, 
                            75000, 100000, 200000, 300000, 400000, 
                            500000, 750000, 1000000 };
    
    //this array is shuffled and put into the case buttons
    List<Integer> caseValuesArray = new ArrayList<>();
    //this array is used to initialize checkboxes and keep track
    List<Integer> prizeValuesArray = new ArrayList<>();
    //this array is used for the bank offer/averages
    List<Integer> avgSumsArray = new ArrayList<>();
    
    //gameFrame Constructor
    gameFrame() {
        
        for(int i = 0; i < playValues.length; i++) {
            caseValuesArray.add(playValues[i]);
            prizeValuesArray.add(playValues[i]);
            avgSumsArray.add(playValues[i]);
        }
        //shuffling case values
        Collections.shuffle(caseValuesArray);
        

        //JLabel specs
        topLabel = new JLabel();
        topLabel.setOpaque(true);
        topLabel.setBounds(380,10,640, 80);
        //int c = 1;
        topLabel.setHorizontalAlignment(JLabel.CENTER);
        topLabel.setFont(new Font ("Comic Sans", Font.BOLD, 40));
        topLabel.setText("CHOOSE YOUR CASE");
        
        bottomLabel = new JLabel();
        bottomLabel.setOpaque(true);
        bottomLabel.setBounds(380, 681, 640, 80);
        bottomLabel.setForeground(Color.WHITE);
        bottomLabel.setBackground(Color.BLACK);
        bottomLabel.setLayout(new GridLayout(1,2,250,10));
        bottomLabel.setHorizontalAlignment(JLabel.CENTER);
        bottomLabel.setFont(new Font ("Comic Sans", Font.BOLD, 20));
        bottomLabel.setText("CLICK ANY CASE");
        
        //JPanel = a GUI component that functions as a container to hold other components
        
        //This panel is in the middle and is where the cases will be displayed.
        casePanel = new JPanel();
        //redPanel.setLayout(null);
        casePanel.setBackground(Color.BLACK);
        casePanel.setBounds(350,100,700,570); //og height is 770
        casePanel.setLayout(new GridLayout(5, 5, 10, 10));
        //redPanel.setLayout(new BorderLayout());
        
        //This panel is displaying the first 13 prize values on the left hand side of gui
        leftPanel = new JPanel();
        leftPanel.setBackground(Color.BLACK);
        leftPanel.setBounds(0,0,350, 770);
        leftPanel.setLayout(new GridLayout(13, 1, 10,10));
        
        //Right side of GUi
        rightPanel = new JPanel();
        rightPanel.setBackground(Color.BLACK);
        rightPanel.setBounds(1050,0,350,770);
        rightPanel.setLayout(new GridLayout(12,1,10,10));

        //initializing button specs
        for (int i = 0; i < caseButtons.length; i++) {
            caseButtons[i] = new JButton(Integer.toString(i + 1));
            //caseButtons[i].setText(Integer.toString(i+1));
            caseButtons[i].setOpaque(true);
            caseButtons[i].setFocusable(false);
            caseButtons[i].setFont(new Font("Comic Sans", Font.BOLD, 40));
            caseButtons[i].setForeground(Color.BLACK); //font color
            caseButtons[i].setBackground(Color.LIGHT_GRAY);
            caseButtons[i].setBorder(BorderFactory.createEtchedBorder());
            caseButtons[i].addActionListener(this);

        }
        
        //DEAL button
        bDeal = new JButton("DEAL");
        bDeal.setOpaque(true);
        bDeal.setFocusable(false);
        bDeal.setFont(new Font("Comic Sans", Font.BOLD, 30));
        bDeal.setForeground(Color.BLACK);
        bDeal.setBackground(Color.LIGHT_GRAY);
        bDeal.setBorder(BorderFactory.createEtchedBorder());
        bDeal.addActionListener(this);
        bDeal.setEnabled(false);
            
        //NO DEAL button
        bNoDeal = new JButton("NO DEAL");
        bNoDeal.setOpaque(true);
        bNoDeal.setFocusable(false);
        bNoDeal.setFont(new Font("Comic Sans", Font.BOLD, 30));
        bNoDeal.setForeground(Color.BLACK);
        bNoDeal.setBackground(Color.LIGHT_GRAY);
        bNoDeal.setBorder(BorderFactory.createEtchedBorder());
        bNoDeal.addActionListener(this);
        bNoDeal.setEnabled(false);
        bottomLabel.add(bDeal);
        bottomLabel.add(bNoDeal);
        
        //image file for when checkbox is selected
        xIcon = new ImageIcon("x.png");
        
        //initializing checkbox specs
        for (int i = 0; i < checkBoxes.length; i++) {
            checkBoxes[i] = new JCheckBox();
            checkBoxes[i].setFocusable(false);
            checkBoxes[i].setText("$"+ Integer.toString(prizeValuesArray.get(i)));
            checkBoxes[i].setOpaque(true);
            checkBoxes[i].setFont(new Font("Comic Sans", Font.BOLD, 30));
            checkBoxes[i].setHorizontalAlignment(JCheckBox.CENTER );
            checkBoxes[i].setBackground(new Color (229,204,81));
            checkBoxes[i].setForeground(Color.BLACK);
            checkBoxes[i].setBorder(BorderFactory.createEtchedBorder());
        }
        
        //JFrame (GUI window to add components to
        this.setTitle("DEAL OR NO DEAL"); //sets title of frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //allows application to exit when frame is closed
        this.setLayout(null);
        this.setSize(1400, 800); //sets x and y dimensions of frame. Currently set to mostly fit the MBP screen
        this.setResizable(false); //frame cannot be resized/expanded to full screen
        this.getContentPane().setBackground(Color.BLACK); //changes frame color
        
        //this allows buttons to be seen. Adding buttons to panels.
        for(int i = 0; i < caseButtons.length; i++) {
            casePanel.add(caseButtons[i]);
        }   
        for(int i = 0; i < 13; i++) {
            leftPanel.add(checkBoxes[i]);
        }
        for(int i = 13; i < 25; i++) {
            rightPanel.add(checkBoxes[i]);
        }

        //Adding panels to JFrame
        this.add(casePanel);
        this.add(leftPanel);
        this.add(rightPanel);
        this.add(topLabel);
        this.add(bottomLabel);

        this.setVisible(true); //makes frame visible, must be last

    }
    //end gameFrame Constructor
    
    
    //getAvg method calculates the bank offer using averages
    public void getAvg() {
        int currentSum = 0;
        int currentAverage = 0;
        for (int i = 0; i < avgSumsArray.size(); i++) {
            currentSum += avgSumsArray.get(i);
        }
        currentAverage = currentSum/avgSumsArray.size();       
        
        System.out.println("avg: " + currentAverage);
        System.out.println("sum: " + currentSum);
        
        switch (numCasesOpened) {
            case 6 -> {
                //opened 6 out of 25
                topLabel.setText("BANK OFFER - OPEN 5 CASES");
                prizeFactor = 10; //10%
                bankOffer = currentAverage / prizeFactor;
                bottomLabel.setText("Offer = " + bankOffer);
                casesToOpen = 5;
            }
            case 11 -> {
                //another 5 have been opened (11/25)
                topLabel.setText("BANK OFFER - OPEN 4 CASES");
                prizeFactor = 7; //%14.2
                bankOffer = currentAverage / prizeFactor;
                bottomLabel.setText("Offer = " + bankOffer);
                casesToOpen = 4;
            }
            case 15 -> {
                //another 4 have been opened (15/25)
                topLabel.setText("BANK OFFER - OPEN 3 CASES");
                prizeFactor = 5; //20%
                bankOffer = currentAverage / prizeFactor;
                bottomLabel.setText("Offer = " + bankOffer);
                casesToOpen = 3;
            }
            case 18 -> {
                //another 3 have been opened (18/25)
                topLabel.setText("BANK OFFER - OPEN 2 CASES");
                prizeFactor = 3; //33%
                bankOffer = currentAverage / prizeFactor;
                bottomLabel.setText("Offer = " + bankOffer);
                casesToOpen = 2;
            }
            case 20 -> {
                //another 2 have been opened (20/25)
                topLabel.setText("BANK OFFER - OPEN 1 CASE");
                prizeFactor = 2; //50%
                bankOffer = currentAverage / prizeFactor;
                bottomLabel.setText("Offer = " + bankOffer);
                casesToOpen = 1;
            }
            case 21 -> {
                //another 1 have been opened (21/25)
                topLabel.setText("BANK OFFER - OPEN 1 CASE");
                prizeFactor = 3; //33% * 2 = 66%
                bankOffer = (currentAverage / prizeFactor) * 2;
                bottomLabel.setText("Offer = " + bankOffer);
                casesToOpen = 1;
            }
            case 22 -> {
                //another 1 have been opened (22/25)
                topLabel.setText("BANK OFFER - OPEN 1 CASES");
                prizeFactor = 5; //20% * 4 = 80%
                bankOffer = (currentAverage / prizeFactor) * 4;
                bottomLabel.setText("Offer = " + bankOffer);
                casesToOpen = 1;
            }
            case 23 -> {
                //another 1 have been opened, only 2 left, final choice goes here
                prizeFactor = 1; //100%
                bankOffer = currentAverage / prizeFactor;
                bottomLabel.setText("Last Offer = " + bankOffer);
                casesToOpen = 1;
            }
            case 24 -> //this is opened to see if you have won
                //prizeFactor = 25;
                //bankOffer = currentAverage / prizeFactor;
                bottomLabel.setText("THE END");
            default -> {
            }
        }
        casesToOpen--;
    }
    
    //action specs
    @Override
    public void actionPerformed(ActionEvent e) {

        Object o = e.getSource(); // holds pointer to caseButtons[i];
        
        //searches through all buttons for a match and changes accordingly
        for(int i = 0; i < caseButtons.length; i++) {
            if(o == caseButtons[i]) {
                System.out.println("button " + (i + 1) + " clicked"); //debug

                if(isFirstTurn == true) {
                    //topLabel.setText("CHOOSE YOUR CASE");
                    //System.out.println("first turn"); //debug
                    caseButtons[i].setText("YOUR CASE"); //changes text for the first case chosen (player's case)
                    caseButtons[i].setFont(new Font("Comic Sans", Font.BOLD, 20));
                    //topLabel.setText("YOUR CASE IS NUMBER " + (i + 1));
                    casesToOpen = 6;
                    topLabel.setText("OPEN " + casesToOpen + " CASE(S)");

                    System.out.println("     ** YOUR CASE IS " + (i + 1) + " **");
                    getAvg();
                    isFirstTurn = false;

                }
                else if(isFirstTurn == false) {
                    numCasesOpened++;

                    topLabel.setText("OPEN " + casesToOpen + " CASE(S)");
                    //updating button
                    System.out.println("Opening Case " + (i + 1));
                    caseButtons[i].setEnabled(false); //so button can't be clicked again
                    caseButtons[i].setOpaque(false); //turns buttons opacity off
                    caseButtons[i].setText("$" + Integer.toString(caseValuesArray.get(i)));
                    caseButtons[i].setFont(new Font("Comic Sans", Font.BOLD, 20));

                    //the integer values of caseValuesArray[i] and prizeValuesArray[t] are compared
                    Integer n = caseValuesArray.get(i); //gets Integer value held by caseValuesArray[i]
                    System.out.println(n + " is in");
                    if(numCasesOpened < 25) {
                        avgSumsArray.remove(n);
                        getAvg();
                    }

                    for(int t = 0; t < prizeValuesArray.size(); t++) {
                        Integer q = prizeValuesArray.get(t);
                        if (q.intValue() == n.intValue()) {
                            checkBoxes[t].setSelected(true);
                            checkBoxes[t].setIcon(xIcon); //icon for visibility purposes


                        }
                    }
                    System.out.println("numCasesOpened1 = " + numCasesOpened + " end of action");

                } // end else if

            } // end if
        } // end for loop
    } //end ActionPerformed
   
}
