package view;

import javax.swing.*;
import java.awt.*;

public class ReviewPanel extends JPanel {

    public ReviewPanel() {
        setLayout(new BorderLayout());

        JLabel label = new JLabel("Review");
        label.setHorizontalAlignment(SwingConstants.CENTER);

        add(label, BorderLayout.CENTER);
    }
}
