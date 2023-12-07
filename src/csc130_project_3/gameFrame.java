package csc130_project_3;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
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
    int casesToOpen = 1; // keeps track of cases left to choose. Initialized with 1 because player chooses 1 case to start.
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
    //ImageIcon checkIcon; //icon for when checkBoxes are unselected, may add later
    
    
    //ATTEMPT: use this array to calculate the average for Banker class
    //this array is shuffled and assigned to caseButtons
    Integer[] caseValuesArray = { 1, 5, 10, 25, 50, 75, 100, 200, 300, 400, 
                            500, 750, 1000, 5000, 10000, 25000, 50000, 
                            75000, 100000, 200000, 300000, 400000, 
                            500000, 750000, 1000000 };
    
    //this array stays the same and assigned to checkBoxes
    Integer[] prizeValuesArray = { 1, 5, 10, 25, 50, 75, 100, 200, 300, 400, 
                            500, 750, 1000, 5000, 10000, 25000, 50000, 
                            75000, 100000, 200000, 300000, 400000, 
                            500000, 750000, 1000000 };

    
    //gameFrame Constructor
    gameFrame() {
        //Shuffling caseValuesArray
        List<Integer> intList;
        intList = Arrays.asList(caseValuesArray);
        Collections.shuffle(intList);
        intList.toArray(caseValuesArray);
        
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
        bottomLabel.setBackground(Color.BLACK);
        bottomLabel.setLayout(new GridLayout(1,2,10,10));
        
        
        
        
        
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
        
        bDeal = new JButton("DEAL");
        bDeal.setOpaque(true);
        bDeal.setFocusable(false);
        bDeal.setFont(new Font("Comic Sans", Font.BOLD, 40));
        bDeal.setForeground(Color.BLACK);
        bDeal.setBackground(Color.LIGHT_GRAY);
        bDeal.setBorder(BorderFactory.createEtchedBorder());
        bDeal.addActionListener(this);
        bDeal.setEnabled(false);
            
        
        bNoDeal = new JButton("NO DEAL");
        bNoDeal.setOpaque(true);
        bNoDeal.setFocusable(false);
        bNoDeal.setFont(new Font("Comic Sans", Font.BOLD, 40));
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
            checkBoxes[i].setText("$"+ Integer.toString(prizeValuesArray[i]));
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
    
    public void updateCasesToOpen() {
        
    }
    
    //method to change casesToOpen variable and print change on label
    public void updateCasesToOpen(int count) {
        casesToOpen = count; // updates how many cases left to open
        System.out.println(casesToOpen + " cases to open");
        //topLabel.setText("CHOOSE " + casesToOpen + " CASE(S)");
        
    }
    
    //action specs
    @Override
    public void actionPerformed(ActionEvent e) {
        casesToOpen--;
        //System.out.println("in actionPerformed");
        updateCasesToOpen(casesToOpen);    
        //System.out.println("     casesToOpen 1 = " + casesToOpen);
        //updateCasesToOpen(casesToOpen); //test
        Object o = e.getSource(); // holds pointer to caseButtons[i];
        
        
        
                //if(isFirstTurn == true) {
                //      //choosePlayerCase
                
        if(casesToOpen > 0) {
            bDeal.setEnabled(false);
            bNoDeal.setEnabled(false);
        } else if(casesToOpen == 0) {
            bDeal.setEnabled(true);
            bNoDeal.setEnabled(true);
        }
        
        //update cases to open?
        
       // while (casesToOpen > 0) {
            
    
            for(int i = 0; i < caseButtons.length; i++) {
                if(o == caseButtons[i]) {
                    //System.out.println(caseButtons[i]);
                    System.out.println("button " + (i + 1) + " clicked"); //debug
                    


                    if(isFirstTurn == true) {
                        //topLabel.setText("CHOOSE YOUR CASE");
                        //System.out.println("first turn"); //debug
                        caseButtons[i].setText("YOUR CASE"); //changes text for the first case chosen (player's case)
                        caseButtons[i].setFont(new Font("Comic Sans", Font.BOLD, 20));
                        topLabel.setText("YOUR CASE IS NUMBER " + (i + 1));
                        isFirstTurn = false;
                        System.out.println("     ** YOUR CASE IS " + (i + 1) + " **");
                        //note: this case can still be clicked again atm

                        //do not remove this first case from the array

                    }
                    else if(isFirstTurn == false) {
                        //updating button
                        System.out.println("Opening Case " + (i + 1));
                        caseButtons[i].setEnabled(false); //so button can't be clicked again
                        caseButtons[i].setOpaque(false); //turns buttons opacity off
                        caseButtons[i].setText("$" + Integer.toString(caseValuesArray[i]));
                        caseButtons[i].setFont(new Font("Comic Sans", Font.BOLD, 20));

                        //the integer values of caseValuesArray[i] and prizeValuesArray[t] are compared
                        Integer n = caseValuesArray[i]; //gets Integer value held by caseValuesArray[i] 
                        for(int t = 0; t < prizeValuesArray.length; t++) {
                            Integer q = prizeValuesArray[t];
                            if (q.intValue() == n.intValue()) {
                                checkBoxes[t].setSelected(true);
                                checkBoxes[t].setIcon(xIcon); //icon for visibility purposes

                                //remove caseValuesArray[i] from from caseValuesArray[]

                            }
                        }

                    } // end else if

                } // end if
            } // end for loop
            
            //casesToOpen--; //for the while loop
            //System.out.println("casesToOpen 2 = " + casesToOpen);
            //System.out.println("exiting while loop");
                  
       // }//end while loop
        
        //ask player to continue or exit
        

    } //end ActionPerformed
   
}


       /* Ignore all this
        
        //ImageIcon icon = new ImageIcon("howie.jpeg");
              
        button2.addActionListener(e -> System.out.println("button2"));

        //button2.setIcon(icon);
        button2.setText("button2");
        button2.setHorizontalTextPosition(JButton.CENTER);
        button2.setVerticalTextPosition(JButton.BOTTOM);
        button2.setFont(new Font("Comic Sans", Font.BOLD, 25));
        button2.setIconTextGap(-15); */

        /*
        
        ImageIcon image = new ImageIcon("image.jpeg");
        Border border = BorderFactory.createLineBorder(Color.green, 5);
        //- could also do JLabel label = new JLabel("test"); to pass directly
        label = new JLabel(); // create label
        label.setText("Test test test test"); // set text of label
        label.setIcon(image);
        label.setHorizontalTextPosition(JLabel.CENTER);// set text LEFT, CENTER, or RIGHT of image
        label.setVerticalTextPosition(JLabel.TOP); //set text TOP, CETNER, BOTTOM of image
        label.setForeground(new Color (255,255,255)); //font color of text
        label.setFont(new Font("MV Boli", Font.BOLD, 40)); // set font of text (font name, style, size)
        label.setIconTextGap(10); //set gap of text to image
        label.setBackground(Color.black); //set background color of text
        label.setOpaque(true); //display background color
        label.setBorder(border);//
        label.setVerticalAlignment((JLabel.CENTER)); //set vertical position of icon+text within label
        label.setHorizontalAlignment(JLabel.CENTER); //set horizontal position of icon+text within label
        label.setBounds(100,100,250,250); //set x,y position within frame as well as dimensions
        label.setVisible(false);
        
        JLabel label2 = new JLabel();
        label2.setText("Example Text");
        label2.setVerticalAlignment((JLabel.BOTTOM)); //set vertical position of icon+text within label
        label2.setHorizontalAlignment(JLabel.CENTER);*/
