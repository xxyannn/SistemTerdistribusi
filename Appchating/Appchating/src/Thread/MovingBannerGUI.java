import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MovingBannerGUI extends JFrame implements ActionListener {
    private String textToDisplay = "cakra adhana";
    private int xCoordinate = 0;
    private int yCoordinate = 100;
    private Timer timer;

    public MovingBannerGUI() {
        setTitle("Moving Banner");
        setSize(800, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a JPanel to hold the banner
        JPanel bannerPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.BLACK);
                g.setFont(new Font("Arial", Font.PLAIN, 36));
                g.drawString(textToDisplay, xCoordinate, yCoordinate);
            }
        };
        bannerPanel.setPreferredSize(new Dimension(800, 200));

        add(bannerPanel);

        // Create a timer to update the text position
        timer = new Timer(50, this);
        timer.start();
    }

    public void actionPerformed(ActionEvent e) {
        // Update the x-coordinate to move text from left to right
        xCoordinate += 5;

        // Check if the text has moved out of the panel, and reset its position
        if (xCoordinate > getWidth()) {
            xCoordinate = -getFontMetrics(new Font("Arial", Font.PLAIN, 36)).stringWidth(textToDisplay);
        }

        repaint();
        try {
            Thread.sleep(100); // Delay for 100 milliseconds (adjust as needed)
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MovingBannerGUI bannerGUI = new MovingBannerGUI();
            bannerGUI.setVisible(true);
        });
    }
}