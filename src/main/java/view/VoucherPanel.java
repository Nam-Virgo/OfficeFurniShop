package view;

import javax.swing.*;
import java.awt.*;

public class VoucherPanel extends JPanel {

    public VoucherPanel() {
        setLayout(new BorderLayout());

        JLabel label = new JLabel("Voucher");
        label.setHorizontalAlignment(SwingConstants.CENTER);

        add(label, BorderLayout.CENTER);
    }
}