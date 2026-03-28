package view;

import javax.swing.*;
import java.awt.*;

public class CategoryPanel extends JPanel {

    public CategoryPanel() {
        setLayout(new BorderLayout());

        JLabel label = new JLabel("Category");
        label.setHorizontalAlignment(SwingConstants.CENTER);

        add(label, BorderLayout.CENTER);
    }
}
