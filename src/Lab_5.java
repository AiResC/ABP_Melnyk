import javax.swing.*;
import java.awt.*;

public class Lab_5 extends JFrame {

    private JRadioButton imageButton(String text, String iconPath, int width, int height) {
        JRadioButton rb = new JRadioButton(text);
        rb.setOpaque(false);
        rb.setFont(new Font("Serif", Font.PLAIN, 15));

        try {
            ImageIcon originalIcon = new ImageIcon(iconPath);
            if (originalIcon.getIconWidth() > 0) {
                Image scaledImage = originalIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
                rb.setIcon(new ImageIcon(scaledImage));
                rb.setSelectedIcon(new ImageIcon(scaledImage));
                rb.setIconTextGap(15);
            } else {
                rb.setText("[Відсутнє фото] " + text);
            }
        } catch (Exception e) {
            rb.setText("[Помилка] " + text);
        }
        return rb;
    }

    public Lab_5() {
        setTitle("Конвертація документів");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(550, 450);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        mainPanel.setBackground(new Color(245, 222, 195));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;

        JLabel title = new JLabel("<html><h1 style='color:#8B4513; font-family:serif;'>Конвертація документів</h1></html>");
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        mainPanel.add(title, gbc);

        JLabel labelTask = new JLabel("Оберіть завдання:");
        labelTask.setFont(new Font("Serif", Font.PLAIN, 16));
        gbc.gridx = 0; gbc.gridy = 1; gbc.gridwidth = 2;
        mainPanel.add(labelTask, gbc);

        ButtonGroup group = new ButtonGroup();
        int iconWidth = 40;
        int iconHeight = 40;

        JRadioButton btn1 = imageButton("Конвертувати в PDF", "src/Lab5-content/PDF.png", iconWidth, iconHeight);
        JRadioButton btn2 = imageButton("Конвертувати в Microsoft Word", "src/Lab5-content/MW.png", iconWidth, iconHeight);
        JRadioButton btn3 = imageButton("Перетворити на документ Microsoft Excel", "src/Lab5-content/ME.png", iconWidth, iconHeight);

        group.add(btn1); group.add(btn2); group.add(btn3);

        gbc.gridwidth = 2;
        gbc.gridx = 0;
        gbc.insets = new Insets(10, 40, 10, 10);
        gbc.gridy = 2; mainPanel.add(btn1, gbc);
        gbc.gridy = 3; mainPanel.add(btn2, gbc);
        gbc.gridy = 4; mainPanel.add(btn3, gbc);

        gbc.insets = new Insets(10, 10, 10, 10);

        gbc.gridwidth = 1;
        gbc.gridy = 5;
        gbc.gridx = 0;
        JLabel fileLabel = new JLabel("<html><i>Ім'я файлу</i></html>");
        fileLabel.setFont(new Font("Serif", Font.PLAIN, 16));
        mainPanel.add(fileLabel, gbc);

        gbc.gridx = 1;
        mainPanel.add(new JTextField(20), gbc);

        gbc.gridy = 6;
        gbc.gridx = 0;
        JCheckBox checkBox = new JCheckBox("<html>Я погоджуюсь з <font color='blue'><u>Умовами</u></font></html>");
        checkBox.setOpaque(false);
        checkBox.setFont(new Font("Serif", Font.PLAIN, 14));
        mainPanel.add(checkBox, gbc);

        JButton btnNext = new JButton("Далі");
        btnNext.setBackground(new Color(160, 82, 45));
        btnNext.setForeground(Color.WHITE);
        btnNext.setOpaque(true);
        btnNext.setBorderPainted(false);
        btnNext.setPreferredSize(new Dimension(100, 35));
        btnNext.setFont(new Font("Arial", Font.BOLD, 14));

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.EAST;
        mainPanel.add(btnNext, gbc);

        add(mainPanel);
    }



    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Lab_5().setVisible(true));
    }
}