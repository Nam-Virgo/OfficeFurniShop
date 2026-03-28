package view;

import javax.swing.*;
import java.awt.*;

public class SupportPanel extends JPanel {

    public SupportPanel() {
        setLayout(new BorderLayout());

        JLabel label = new JLabel("Support");
        label.setHorizontalAlignment(SwingConstants.CENTER);

        add(label, BorderLayout.CENTER);
    }
}
