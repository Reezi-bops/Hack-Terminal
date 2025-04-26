import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FinalProject {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Login");
        frame.setSize(450, 320);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setBackground(Color.BLACK);
        panel.setLayout(null);

        JLabel titleLabel = new JLabel("Login");
        titleLabel.setForeground(Color.GREEN);
        titleLabel.setFont(new Font("Courier New", Font.BOLD, 28));
        titleLabel.setBounds(185, 20, 100, 40);
        panel.add(titleLabel);

        JLabel userLabel = new JLabel("Username:");
        userLabel.setForeground(Color.GREEN);
        userLabel.setFont(new Font("Courier New", Font.PLAIN, 16));
        userLabel.setBounds(50, 80, 100, 25);
        panel.add(userLabel);

        JTextField userText = new JTextField();
        userText.setFont(new Font("Courier New", Font.PLAIN, 14));
        userText.setBounds(160, 80, 200, 28);
        panel.add(userText);

        JLabel passLabel = new JLabel("Password:");
        passLabel.setForeground(Color.GREEN);
        passLabel.setFont(new Font("Courier New", Font.PLAIN, 16));
        passLabel.setBounds(50, 120, 100, 25);
        panel.add(passLabel);

        JPasswordField passText = new JPasswordField();
        passText.setFont(new Font("Courier New", Font.PLAIN, 14));
        passText.setBounds(160, 120, 200, 28);
        panel.add(passText);

        JButton loginButton = new JButton("Login");
        loginButton.setFont(new Font("Courier New", Font.PLAIN, 14));
        loginButton.setBounds(160, 170, 90, 30);
        panel.add(loginButton);

        JButton createButton = new JButton("Create");
        createButton.setFont(new Font("Courier New", Font.PLAIN, 14));
        createButton.setBounds(270, 170, 90, 30);
        panel.add(createButton);

        frame.add(panel);
        frame.setVisible(true);

        loginButton.addActionListener(e -> {
            String username = userText.getText();
            String password = new String(passText.getPassword());

            if (username.equals("admin") && password.equals("123")) {
                frame.dispose();
                HackTerminal.launchTerminal();
            } else {
                JOptionPane.showMessageDialog(frame, "Invalid username or password", "Login Failed", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}

class HackTerminal {
    public static void launchTerminal() {
        JFrame frame = new JFrame("Hacker Terminal");
        frame.setSize(1100, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JTextArea terminalArea = new JTextArea();
        terminalArea.setBackground(Color.BLACK);
        terminalArea.setForeground(Color.GREEN);
        terminalArea.setFont(new Font("Courier New", Font.PLAIN, 18));
        terminalArea.setCaretColor(Color.GREEN);
        terminalArea.setLineWrap(true);
        terminalArea.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(terminalArea);
        scrollPane.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
        frame.add(scrollPane);

        new Thread(() -> {
            appendWithDelay(terminalArea, "> Booting HackerOS v1.0...\n", 1000);
            appendWithDelay(terminalArea, "> Initializing encrypted protocols...\n", 1000);
            appendWithDelay(terminalArea, "> Loading Black Hat tools...\n", 1000);
            appendWithDelay(terminalArea, "> Access level: Admin++ \n", 1000);
            appendWithDelay(terminalArea, "> Verifying Raiko's clearance...\n", 1000);
            appendWithDelay(terminalArea, "> Access Granted\n", 1000);
            appendWithDelay(terminalArea, "> Welcome to Hack ", 1000);
            appendWithDelay(terminalArea, "Tung tung tung ", 1000);
            appendWithDelay(terminalArea, "Sahur v1.0\n", 1000);
            appendWithDelay(terminalArea, "> ", 0);
        }).start();

        terminalArea.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    String[] lines = terminalArea.getText().split("\n");
                    String lastLine = lines[lines.length - 1].trim();

                    if (lastLine.endsWith("cd hcdcbreach")) {
                        new Thread(() -> {
                            appendWithDelay(terminalArea, "> ", 1000);
                            appendWithDelay(terminalArea, "\n> Connecting to the secret WiFi: 'HCDC-WiFi-Hidden'", 1000);
                            appendWithDelay(terminalArea, "\n> Initiating breach protocol...", 1000);
                            appendWithDelay(terminalArea, "\n> Bypassing firewalls...", 1000);
                            appendWithDelay(terminalArea, "\n> Injecting backdoor virus...", 1000);
                            appendWithDelay(terminalArea, "\n> Access granted to HCDC Mainframe...", 1000);
                            appendWithDelay(terminalArea, "\n> Downloading confidential files...", 1000);
                            appendWithDelay(terminalArea, "\n> System Breached Successfully!", 1000);
                            appendWithDelay(terminalArea, "\n> ", 500);
                        }).start();
                    } else if (lastLine.endsWith("cd delete")) {
                        new Thread(() -> {
                            appendWithDelay(terminalArea, "> ", 1000);
                            appendWithDelay(terminalArea, "\n> WARNING: Unauthorized command detected!", 1000);
                            appendWithDelay(terminalArea, "\n> Activating self-destruct mode...", 1000);
                            appendWithDelay(terminalArea, "\n> Deleting terminal logs...", 1000);
                            appendWithDelay(terminalArea, "\n> Erasing traces...", 1000);
                            appendWithDelay(terminalArea, "\n> Shutting down...", 1000);
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException ignored) {}
                            System.exit(0);
                        }).start();
                    } else {
                        terminalArea.append("\n> Unknown command.");
                        terminalArea.append("\n> ");
                    }
                }
            }
        });

        frame.setVisible(true);
    }

    private static void appendWithDelay(JTextArea area, String text, int delayMillis) {
        try {
            Thread.sleep(delayMillis);
        } catch (InterruptedException ignored) {}
        SwingUtilities.invokeLater(() -> area.append(text));
    }
}