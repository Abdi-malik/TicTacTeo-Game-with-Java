import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import static javax.swing.SwingConstants.CENTER;

public class TicTacTeo implements ActionListener {
    Random random = new Random();
    JPanel textPanel = new JPanel();
    JPanel buttonPanel = new JPanel();
    JLabel text = new JLabel();
    JButton[] buttons = new JButton[9];
    JPanel panel = new JPanel();
    boolean playerOneTurn;

     TicTacTeo(){
        panel.setLayout(new BorderLayout());

        text.setBackground(new Color(0, 0, 0));
        text.setForeground(new Color(255, 255, 255));
        text.setFont(new Font("Ink Free", Font.BOLD,100));
        text.setHorizontalAlignment(CENTER);
        text.setText("Tic-Tac_teo");
        text.setOpaque(true);

        textPanel.setLayout(new BorderLayout());
        textPanel.add(text);
        panel.add(textPanel,BorderLayout.NORTH);


        buttonPanel.setLayout(new GridLayout(3,3));
        buttonPanel.setBackground(new Color(255,255,255));
        panel.add(buttonPanel);

        for (int i = 0; i < 9; i++){
            buttons[i] = new JButton();
            buttonPanel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli",Font.BOLD,120));
            buttons[i].addActionListener(this);
            buttons[i].setFocusable(false);
            buttons[i].setBackground(new Color(255,255, 255));
        }
            firstTurn();
    }
    public void firstTurn() {
        if(random.nextInt(2) == 0){
            playerOneTurn = true;
            text.setForeground(Color.BLUE);
            text.setText("X turn");
        }
        else {
            playerOneTurn = false;
            text.setForeground(Color.RED);
            text.setText("O turn");
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 9; i++) {
            if (e.getSource() == buttons[i]) {
                if (playerOneTurn) {
                    if (buttons[i].getText() == "") {
                        buttons[i].setText("X");
                        playerOneTurn = false;
                        text.setForeground(new Color(241, 4, 4));
                        text.setText("O turn");
                        buttons[i].setEnabled(false);
                    }
                    check();
                } else {
                    if (buttons[i].getText() == "") {
                        buttons[i].setText("O");
                        playerOneTurn = true;
                        text.setText("X turn");
                        text.setForeground(new Color(12, 12, 236));
                        buttons[i].setEnabled(false);
                    }
                    check();
                }
            }
        }
    }
    public void check(){
        // X Wins //////////////////////////////////////////////////////////////////////////////////////////////
        if(
                (buttons[0].getText() == "X") &&
                        (buttons[1].getText() == "X") &&
                        (buttons[2].getText() == "X")
        ){
            xWins(0,1,2);
        }
        if(
                (buttons[0].getText() == "X") &&
                        (buttons[3].getText() == "X") &&
                        (buttons[6].getText() == "X")
        ){
            xWins(0,3,6);
        }
        if(
                (buttons[0].getText() == "X") &&
                        (buttons[4].getText() == "X") &&
                        (buttons[8].getText() == "X")
        ){
            xWins(0,4,8);
        }
        if(
                (buttons[1].getText() == "X") &&
                        (buttons[4].getText() == "X") &&
                        (buttons[7].getText() == "X")
        ){
            xWins(1,4,7);
        }
        if(
                (buttons[2].getText() == "X") &&
                        (buttons[5].getText() == "X") &&
                        (buttons[8].getText() == "X")
        ){
            xWins(2,5,8);
        }
        if(
                (buttons[3].getText() == "X") &&
                        (buttons[4].getText() == "X") &&
                        (buttons[5].getText() == "X")
        ){
            xWins(3,4,5);
        }
        if(
                (buttons[6].getText() == "X") &&
                        (buttons[7].getText() == "X") &&
                        (buttons[8].getText() == "X")
        ){
            xWins(6,7,8);
        }
        if(
                (buttons[2].getText() == "X") &&
                        (buttons[4].getText() == "X") &&
                        (buttons[6].getText() == "X")
        ){
            xWins(2,4,6);
        }
        // O Wins ////////////////////////////////////////////////////////////////////////////////////////////
        if(
                (buttons[0].getText() == "O") &&
                        (buttons[1].getText() == "O") &&
                        (buttons[2].getText() == "O")
        ){
            oWins(0,1,2);
        }
        if(
                (buttons[0].getText() == "O") &&
                        (buttons[3].getText() == "O") &&
                        (buttons[6].getText() == "O")
        ){
            oWins(0,3,6);
        }
        if(
                (buttons[0].getText() == "O") &&
                        (buttons[4].getText() == "O") &&
                        (buttons[8].getText() == "O")
        ){
            oWins(0,4,8);
        }
        if(
                (buttons[1].getText() == "O") &&
                        (buttons[4].getText() == "O") &&
                        (buttons[7].getText() == "O")
        ){
            oWins(1,4,7);
        }
        if(
                (buttons[2].getText() == "O") &&
                        (buttons[5].getText() == "O") &&
                        (buttons[8].getText() == "O")
        ){
            oWins(2,5,8);
        }
        if(
                (buttons[3].getText() == "O") &&
                        (buttons[4].getText() == "O") &&
                        (buttons[5].getText() == "O")
        ){
            oWins(3,4,5);
        }
        if(
                (buttons[6].getText() == "O") &&
                        (buttons[7].getText() == "O") &&
                        (buttons[8].getText() == "O")
        ){
            oWins(6,7,8);
        }
        if(
                (buttons[2].getText() == "O") &&
                        (buttons[4].getText() == "O") &&
                        (buttons[6].getText() == "O")
        ){
            oWins(2,4,6);
        }
    }
    public void xWins(int a, int b, int c){
        buttons[a].setBackground(Color.BLUE);
        buttons[b].setBackground(Color.BLUE);
        buttons[c].setBackground(Color.BLUE);
        for (int i =0; i < 9; i++){
            buttons[i].setEnabled(false);
        }
        text.setText("X wins");
        text.setBackground(Color.BLUE);
        text.setForeground(Color.WHITE);
    }
    public void oWins(int a, int b, int c){
        buttons[a].setBackground(Color.RED);
        buttons[b].setBackground(Color.RED);
        buttons[c].setBackground(Color.RED);
        for (int i =0; i < 9; i++){
            buttons[i].setEnabled(false);
        }
        text.setText("O wins");
        text.setBackground(Color.RED);
        text.setForeground(Color.WHITE);

    }
}
