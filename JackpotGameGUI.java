import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

public class JackpotGameGUI extends JFrame implements ActionListener {
    private JButton spinButton;
    private JLabel reel1Label, reel2Label, reel3Label, messageLabel;
    private ImageIcon cherryIcon, lemonIcon, orangeIcon;
    private Random random;

    public JackpotGameGUI() {
        setTitle("Jackpot Game");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        cherryIcon = new ImageIcon("cherry.png");
        lemonIcon = new ImageIcon("lemon.png");
        orangeIcon = new ImageIcon("orange.png");

        JPanel reelsPanel = new JPanel(new GridLayout(1, 3));
        reel1Label = new JLabel();
        reel2Label = new JLabel();
        reel3Label = new JLabel();
        reelsPanel.add(reel1Label);
        reelsPanel.add(reel2Label);
        reelsPanel.add(reel3Label);

        JPanel buttonsPanel = new JPanel(new FlowLayout());
        spinButton = new JButton("Spin");
        spinButton.addActionListener(this);
        buttonsPanel.add(spinButton);

        JPanel messagePanel = new JPanel(new FlowLayout());
        messageLabel = new JLabel("Press Spin to start the game.");
        messagePanel.add(messageLabel);

        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(reelsPanel, BorderLayout.CENTER);
        contentPane.add(buttonsPanel, BorderLayout.SOUTH);
        contentPane.add(messagePanel, BorderLayout.NORTH);

        random = new Random();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == spinButton) {
            spinReels();
        }
    }

    private void spinReels() {
        int reel1 = random.nextInt(3) + 1; // 1 = cherry, 2 = lemon, 3 = orange
        int reel2 = random.nextInt(3) + 1;
        int reel3 = random.nextInt(3) + 1;

        reel1Label.setIcon(getSymbolIcon(reel1));
        reel2Label.setIcon(getSymbolIcon(reel2));
        reel3Label.setIcon(getSymbolIcon(reel3));

        if (reel1 == reel2 && reel2 == reel3) {
            messageLabel.setText("Congratulations! You won the jackpot!");
        } else if (reel1 == reel2 || reel1 == reel3 || reel2 == reel3) {
            messageLabel.setText("You won a small prize!");
        } else {
            messageLabel.setText("Sorry, no matching symbols.");
        }
    }

    private ImageIcon getSymbolIcon(int symbol) {
        switch (symbol) {
            case 1:
                return cherryIcon;
            case 2:
                return lemonIcon;
            case 3:
                return orangeIcon;
            default:
                return null;
        }
    }

    public static void main(String[] args) {
        JackpotGameGUI game = new JackpotGameGUI();
        game.setVisible(true);
    }
}

