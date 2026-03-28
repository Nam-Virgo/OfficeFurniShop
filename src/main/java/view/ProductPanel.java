package view;

import javax.swing.*;
import java.awt.*;

public class ProductPanel extends JPanel {

    public ProductPanel() {
        setLayout(new BorderLayout());

        JLabel title = new JLabel("Quản lý sản phẩm");
        title.setFont(new Font("Arial", Font.BOLD, 20));

        add(title, BorderLayout.NORTH);

        // TODO: thêm JTable, button CRUD ở đây
    }
}
