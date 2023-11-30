import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;

public class GUI{

    JButton button = new JButton();

    Cases listOfCases = new Cases();

    public GUI () {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel buttonPanel = new JPanel();
        JPanel containerPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2, 2));
        containerPanel.add(buttonPanel);
        buttonPanel.add(createButton("1"));
        buttonPanel.add(createButton("2"));
        buttonPanel.add(createButton("3"));
        buttonPanel.add(createButton("4"));
        buttonPanel.add(createButton("5"));
        buttonPanel.add(createButton("6"));

        frame.getContentPane().add(containerPanel);
        frame.pack();
        frame.setVisible(true);
    }

    public Component createButton (String input) {
        JButton button = new JButton(input);

        Integer i = Integer.parseInt(input);
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (button == (JButton)e.getSource()) {
                    button.setEnabled(false);
                    button.setText(listOfCases.getCaseValue(i));
                }
            }
            
        });
        return button;
    }
    public static void main(String[] args) {
        new GUI();
    }
}
