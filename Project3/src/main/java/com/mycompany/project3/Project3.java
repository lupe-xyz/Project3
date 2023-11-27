/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.project3;

/**
 *
 * @author purity
 */
//import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Project3 extends JFrame {

    private int caseValue;

    private JButton[] caseButtons = new JButton[5];
    private JLabel[] caseLabels = new JLabel[5];

    public Project3() {

        Components();
    }

    private void Components() {
        JPanel mainPanel = new JPanel();
        GroupLayout layout = new GroupLayout(mainPanel);
        mainPanel.setLayout(layout);

        System.out.println("Case Game test.");

        Integer[] defaultCaseArray = {
            1, 5, 10, 25, 50, 75, 100, 200, 300, 400,
            500, 750, 1000, 5000, 10000, 25000, 50000,
            75000, 100000, 200000, 300000, 400000,
            500000, 750000, 1000000};

        for (int i = 0; i < 5; i++) {
            caseButtons[i] = new JButton(Integer.toString(i + 1));
            //caseButtons[i].setBackground(new java.awt.Color(255, 188, 0));
            //caseButtons[i].setForeground(new java.awt.Color(0, 0, 0));
            caseButtons[i].setText(Integer.toString(i + 1));

            //Dimension buttonSize = new Dimension(90, 50);
            //caseButtons[i].setPreferredSize(buttonSize);

            caseButtons[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    handleButtonClick(evt, defaultCaseArray);
                }
            });

            //labels for the caseLabels not done
            // caseLabels[i] = new JLabel(("$ " + (Integer.toString(i + 1))));
        }

        caseGrid(layout, mainPanel);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("DEAL OR NO DEAL");
        pack();
        setLocationRelativeTo(null);

        printArray(defaultCaseArray);

        java.awt.EventQueue.invokeLater(() -> {
            setVisible(true);
        });
    }

    public void caseGrid(GroupLayout layout, JPanel mainPanel) {
        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                        .addComponent(caseButtons[0])
                        .addComponent(caseButtons[1])
                        .addComponent(caseButtons[2])
                        .addComponent(caseButtons[3])
                        .addComponent(caseButtons[4])
        );
        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(caseButtons[0])
                                .addComponent(caseButtons[1])
                                .addComponent(caseButtons[2])
                                .addComponent(caseButtons[3])
                                .addComponent(caseButtons[4]))
        );

        add(mainPanel);
    }

    private void handleButtonClick(ActionEvent evt, Integer[] array) {
        JButton clickedButton = (JButton) evt.getSource();
        caseValue = selectRandomNumber(array);
        String buttonText = Integer.toString(caseValue);
        clickedButton.setText(buttonText);
    }

    public static void printArray(Integer[] array) {
        int n = array.length;
        for (int i = 0; i < n; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public int selectRandomNumber(Integer[] shuffledArray) {
        Random rand = new Random();
        int randomIndex = rand.nextInt(shuffledArray.length);
        return shuffledArray[randomIndex];
    }

    public static void main(String[] args) {

        new Project3();

    }

}
