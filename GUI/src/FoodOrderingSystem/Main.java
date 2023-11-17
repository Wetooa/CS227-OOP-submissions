package FoodOrderingSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class Main extends  JFrame {
    private JCheckBox pizzaCheckBox;
    private JRadioButton noneRadioButton;
    private JRadioButton a15OffRadioButton;
    private JButton btnOrder;
    private JPanel jpanel;
    private JPanel panelOrderGroup;
    private JPanel panelDiscountGroup;

    public Main() {
        Map<String, Integer> order = new HashMap<>();
        order.put("Pizza", 100);
        order.put("Burger", 80);
        order.put("Fries", 65);
        order.put("Softdrinks", 55);
        order.put("Tea", 50);
        order.put("Sundae", 40);


        btnOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double total = 0;
                for (Component c : panelOrderGroup.getComponents()) {
                    for (Component c2 : ((JPanel) c).getComponents()) {
                        if (c2 instanceof JCheckBox && ((JCheckBox) c2).isSelected()) {
                            String txt = (String)((JCheckBox)c2).getText();
                            total += order.get(txt);
                        }
                    }
                }

                for (Component c : panelDiscountGroup.getComponents()) {
                    if (c instanceof JRadioButton && ((JRadioButton) c).isSelected()) {
                        String disc = ((JRadioButton) c).getText();

                        if (disc.equals("5% Off")) total *= (double)0.95;
                        if (disc.equals("10% Off")) total *= (double)0.90;
                        if (disc.equals("15% Off")) total *= (double)0.85;
                    }
                }

                JOptionPane pane = new JOptionPane();
                pane.showMessageDialog(null, "Your total is " + total);

            }
        });
    }

    public static void main(String[] args) {
        FoodOrderingSystem.Main app = new FoodOrderingSystem.Main();

        app.setContentPane(app.jpanel);
        app.setSize(1000, 600);
        app.setLocationRelativeTo(null);
        app.setDefaultCloseOperation(EXIT_ON_CLOSE);
        app.setTitle("Food Ordering System");
        app.setVisible(true);
    }
}

