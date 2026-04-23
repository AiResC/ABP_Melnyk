import javax.swing.*;
import java.awt.*;

class DrawingPanel extends JPanel {
    private String currentShape = "";

    public void setShape(String shape) {
        this.currentShape = shape;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(new Color(0, 102, 204));
        g2d.setStroke(new BasicStroke(3));

        int width = getWidth();
        int height = getHeight();
        int size = Math.min(width, height) - 80;
        int x = (width - size) / 2;
        int y = (height - size) / 2;

        switch (currentShape) {
            case "CIRCLE":
                g2d.drawOval(x, y, size, size);
                break;
            case "SQUARE":
                g2d.drawRect(x, y, size, size);
                break;
            case "POLYGON":
                int cx = width / 2;
                int cy = height / 2;
                int radius = size / 2;
                int sides = 5;

                int[] xPoints = new int[sides];
                int[] yPoints = new int[sides];

                for (int i = 0; i < sides; i++) {
                    double angle = 2 * Math.PI / sides * i - Math.PI / 2;
                    xPoints[i] = cx + (int) (radius * Math.cos(angle));
                    yPoints[i] = cy + (int) (radius * Math.sin(angle));
                }
                g2d.drawPolygon(xPoints, yPoints, sides);
                break;
        }
    }
}

public class Lab_6 extends JFrame {

    private DrawingPanel drawingPanel;

    public Lab_6() {
        setTitle("Лабораторна робота №6 - Варіант 7");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(550, 500);
        setLocationRelativeTo(null);

        drawingPanel = new DrawingPanel();
        add(drawingPanel, BorderLayout.CENTER);

        JPanel radioPanel = new JPanel();
        JRadioButton rbCircle = new JRadioButton("намалювати коло");
        JRadioButton rbSquare = new JRadioButton("намалювати квадрат");
        JRadioButton rbPolygon = new JRadioButton("намалювати багатокутник");

        ButtonGroup group = new ButtonGroup();
        group.add(rbCircle);
        group.add(rbSquare);
        group.add(rbPolygon);

        radioPanel.add(rbCircle);
        radioPanel.add(rbSquare);
        radioPanel.add(rbPolygon);

        add(radioPanel, BorderLayout.SOUTH);

        rbCircle.addActionListener(e -> drawingPanel.setShape("CIRCLE"));
        rbSquare.addActionListener(e -> drawingPanel.setShape("SQUARE"));
        rbPolygon.addActionListener(e -> drawingPanel.setShape("POLYGON"));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Lab_6().setVisible(true));
    }
}

