package SimpleCalculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Year.*;

public class Main extends  JFrame {

    private JPanel jpanel;
    private JButton btnCompute;
    private JTextField tfNumber1;
    private JComboBox cbOperations;
    private JTextField tfNumber2;
    private JLabel lblResult;

    public Main() {
        btnCompute.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    double firstNum = Integer.parseInt(tfNumber1.getText());
                    double secondNum = Integer.parseInt(tfNumber2.getText());
                    Object op = (cbOperations.getSelectedItem());

                    double res = 0;
                    if (op == "+") {
                        res = firstNum + secondNum;
                    }
                    if (op == "-") {
                        res = firstNum - secondNum;
                    }
                    if (op == "*") {
                        res = firstNum * secondNum;
                    }
                    if (op == "/") {
                        res = firstNum / secondNum;
                    }

                    lblResult.setText(String.valueOf(res));

                } catch (Exception error) {
                    JOptionPane.showMessageDialog(null, error.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }


            }
        });
    }

    public static void main(String[] args) {
        SimpleCalculator.Main app = new SimpleCalculator.Main();

        app.setContentPane(app.jpanel);
        app.setSize(1000, 600);
        app.setDefaultCloseOperation(EXIT_ON_CLOSE);
        app.setLocationRelativeTo(null);
        app.setTitle("Simple Calculator");
        app.setVisible(true);
    }
}
