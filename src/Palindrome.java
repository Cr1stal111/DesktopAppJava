import java.util.Scanner;
import java.awt.*;
import javax.swing.*;
import javax.swing.text.*;

public class Palindrome {

    public Palindrome() {
        Main();
    }

    private void Main() {
        JFrame frame = new JFrame("Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(240, 120);
        frame.setLayout(new GridLayout(2, 0));
        frame.setLocationRelativeTo(null);
        final JTextField jtf = new JTextField();
        JLabel labelOutput = new JLabel("Result");

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

            private void Palindrome(String origString) {
                int length = origString.length();
                boolean isPalindrome = true;
                for (int beginIndex = 0; beginIndex < length; beginIndex++) {
                    if ((origString.charAt(beginIndex) != origString.charAt(length - 1 - beginIndex)) || jtf.getText().isEmpty()) {
                        labelOutput.setForeground(new Color(255, 0, 0));
                        labelOutput.setText("Не палиндром");
                        isPalindrome = false;
                        break;
                    }
                }
                if (isPalindrome) {
                    labelOutput.setForeground(new Color(0, 255, 0));
                    labelOutput.setText("Палиндром");
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