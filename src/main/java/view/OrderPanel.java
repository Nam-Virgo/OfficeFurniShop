package view;

import javax.swing.*;
import java.awt.*;

public class OrderPanel extends JPanel {

    public OrderPanel() {
        setLayout(new BorderLayout());

        JLabel label = new JLabel("Order");
        label.setHorizontalAlignment(SwingConstants.CENTER);

        add(label, BorderLayout.CENTER);
    }
}