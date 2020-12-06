// package java_projects.desktopAppJava.src;

import java.awt.*;
import javax.swing.*;
import javax.swing.text.*;

public class Palindrome {

    public Palindrome() {
        createGUI();
    }

    public JTextField jtf = new JTextField();

    JLabel labelOutput;

    public String approved = "Палиндром";

    public String rejected = "Не Палиндром";

    public Color default_color = new Color(0, 0, 0);

    public Color green = new Color(0, 255, 0);

    public Color red = new Color(255, 0, 0);

    public String getResult() {
        return labelOutput.getText();
    }

    public boolean isPalindrome = true;

    public boolean isPalindromeApproved(boolean Palindrome) {
        if (Palindrome) {
            labelOutput.setForeground(green);
            labelOutput.setText(approved);
            return true;
        }
        return false;
    }

    public boolean isPalindromeRejected(String text) {
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) != text.charAt(text.length() - 1 - i)) {
                labelOutput.setForeground(red);
                labelOutput.setText(rejected);
                isPalindrome = false;
                return false;
            }
        }
        isPalindrome = true;
        return true;
    }
    
    private void createGUI() {
        JFrame frame = new JFrame("Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(240, 120);
        frame.setLayout(new GridLayout(2, 0));
        frame.setLocationRelativeTo(null);
        labelOutput = new JLabel("Result");

        DocumentFilter df = new DocumentFilter() {
            @Override
            public void insertString(FilterBypass fb, int i, String string, AttributeSet as)
                    throws BadLocationException {
                super.insertString(fb, i, string, as);
                Palindrome(jtf.getText());
            }

            @Override
            public void remove(FilterBypass fb, int i, int i1) throws BadLocationException {
                super.remove(fb, i, i1);
                Palindrome(jtf.getText());
            }

            @Override
            public void replace(FilterBypass fb, int i, int i1, String string, AttributeSet as)
                    throws BadLocationException {
                super.replace(fb, i, i1, string, as);
                Palindrome(jtf.getText());
            }

            private void Palindrome(String text) {
                isPalindromeRejected(text);

                if (text.length() % 2 == 0) {
                    if (text.length() > 1) {
                        isPalindromeApproved(isPalindrome);
                    } else {
                        labelOutput.setText("Result");
                        labelOutput.setForeground(default_color);
                    }
                } else {
                    labelOutput.setForeground(red);
                    labelOutput.setText(rejected);
                }
            }

        };

        ((AbstractDocument) (jtf.getDocument())).setDocumentFilter(df);
        
        frame.add(jtf);
        frame.add(labelOutput);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Palindrome();
            }
        });
    }
}
