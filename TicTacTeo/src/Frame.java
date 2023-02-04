
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Frame implements ActionListener{
    TicTacTeo ticTacTeo;
    Restart restart;
    JFrame frame;

    Frame() {
        frame = new JFrame("Tic-Tac-Teo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 1000);
        frame.getContentPane().setBackground(new Color(50, 50, 50));
        frame.setLayout(new BorderLayout());

        ticTacTeo = new TicTacTeo();
        frame.add(ticTacTeo.panel);
        frame.setVisible(true);

        restart = new Restart();
        frame.add(restart.restartPanel, BorderLayout.SOUTH);
        restart.restartButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == restart.restartButton){
            frame.remove(ticTacTeo.panel);
            ticTacTeo = new TicTacTeo();
            frame.add(ticTacTeo.panel);
            SwingUtilities.updateComponentTreeUI(frame);
        }
    }
}
