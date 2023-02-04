import javax.swing.*;
import java.awt.*;

class Restart {
    JButton restartButton;
    JPanel restartPanel;
    Restart() {
        restartButton = new JButton();
        restartPanel = new JPanel();

        restartPanel.setLayout(new BorderLayout());
        restartPanel.add(restartButton);

        restartButton.setBackground(new Color(0));
        restartButton.setForeground(new Color(255, 255, 255));
        restartButton.setText("Restart");
        restartButton.setFocusable(false);
        restartButton.setFont(new Font("Abadi Extra Light", Font.PLAIN,30));
    }
}
