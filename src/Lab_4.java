import javax.swing.*;
import java.awt.*;

public class Lab_4 extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // font
        g.setFont(new Font("Times New Roman", Font.ITALIC, 16));
        Color textColor = new Color(64, 64, 64);

        // red ellipse
        g.setColor(Color.RED);
        g.fillOval(50, 50, 150, 80); // Малюємо овал
        g.setColor(textColor);
        g.drawString("Еліпс, червоний", 50, 150);

        // yell triangl
        g.setColor(Color.YELLOW);
        int[] xTri = {250, 250, 400};
        int[] yTri = {50, 130, 130};
        g.fillPolygon(xTri, yTri, 3);
        g.setColor(textColor);
        g.drawString("Трикутник, жовтий", 250, 150);

        // blue trap
        g.setColor(Color.BLUE);
        int[] xTrap = {70, 180, 210, 40};
        int[] yTrap = {200, 200, 260, 260};
        g.fillPolygon(xTrap, yTrap, 4);
        g.setColor(textColor);
        g.drawString("Трапеція, синя", 50, 285);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Лаб4");
        frame.add(new Lab_4());
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}