package view;

import javax.swing.*;
import java.awt.*;

public class RefundPanel extends JPanel {

    public RefundPanel() {
        setLayout(new BorderLayout());

        JLabel label = new JLabel("Refund");
        label.setHorizontalAlignment(SwingConstants.CENTER);

        add(label, BorderLayout.CENTER);
    }
}
