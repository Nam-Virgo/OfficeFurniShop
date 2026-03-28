package view;

import view.LoginForm;

import javax.swing.*;
import java.awt.*;

public class AdminMainFrame extends JFrame {

    private CardLayout cardLayout;
    private JPanel contentPanel;

    public AdminMainFrame() {
        setTitle("Admin Portal");
        setSize(1000, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initUI();
    }

    private void initUI() {

        // 🔹 Layout tổng
        setLayout(new BorderLayout());

        // 🔹 LEFT MENU
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new GridLayout(10, 1));
        menuPanel.setPreferredSize(new Dimension(200, 0));

        // 🔹 BUTTONS
        JButton btnDashboard = new JButton("Tổng Quan");
        JButton btnProduct = new JButton("Sản Phẩm");
        JButton btnCategory = new JButton("Danh mục");
        JButton btnVoucher = new JButton("Voucher");
        JButton btnCustomer = new JButton("Khách Hàng");
        JButton btnOrder = new JButton("Đơn Hàng");
        JButton btnRefund = new JButton("Đổi Trả");
        JButton btnReview = new JButton("Đánh Giá");
        JButton btnSupport = new JButton("Hỗ trợ");
        JButton btnLogout = new JButton("Đăng Xuất");

        JButton[] menuButtons = {
                btnDashboard, btnProduct, btnCategory, btnVoucher,
                btnCustomer, btnOrder, btnRefund, btnReview, btnSupport
        };

        for (JButton btn : menuButtons) {
            btn.setBackground(new Color(102, 178, 255));
            btn.setForeground(Color.WHITE);
        }

        // add vào menu
        menuPanel.add(btnDashboard);
        menuPanel.add(btnProduct);
        menuPanel.add(btnCategory);
        menuPanel.add(btnVoucher);
        menuPanel.add(btnCustomer);
        menuPanel.add(btnOrder);
        menuPanel.add(btnRefund);
        menuPanel.add(btnReview);
        menuPanel.add(btnSupport);
        menuPanel.add(btnLogout);

        btnDashboard.setBackground(new Color(70, 130, 180));

        // 🔹 RIGHT CONTENT
        cardLayout = new CardLayout();
        contentPanel = new JPanel(cardLayout);

        // add các panel
        contentPanel.add(new DashboardPanel(), "dashboard");
        contentPanel.add(new ProductPanel(), "product");
        contentPanel.add(new JLabel("Category"), "category");
        contentPanel.add(new JLabel("Voucher"), "voucher");
        contentPanel.add(new JLabel("Customer"), "customer");
        contentPanel.add(new JLabel("Order"), "order");
        contentPanel.add(new JLabel("Refund"), "refund");
        contentPanel.add(new JLabel("Review"), "review");
        contentPanel.add(new JLabel("Support"), "support");

        // 🔹 ADD vào frame
        add(menuPanel, BorderLayout.WEST);
        add(contentPanel, BorderLayout.CENTER);

        // 🎮 EVENT chuyển panel
        setupMenuButton(btnDashboard, "dashboard", menuButtons);
        setupMenuButton(btnProduct, "product", menuButtons);
        setupMenuButton(btnCategory, "category", menuButtons);
        setupMenuButton(btnVoucher, "voucher", menuButtons);
        setupMenuButton(btnCustomer, "customer", menuButtons);
        setupMenuButton(btnOrder, "order", menuButtons);
        setupMenuButton(btnRefund, "refund", menuButtons);
        setupMenuButton(btnReview, "review", menuButtons);
        setupMenuButton(btnSupport, "support", menuButtons);

        btnLogout.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Đã đăng xuất");
            new LoginForm().setVisible(true);
            dispose();
        });
    }

    private void resetMenuColor(JButton... buttons) {
        for (JButton btn : buttons) {
            btn.setBackground(new Color(102, 178, 255));
            btn.setForeground(Color.WHITE);
        }
    }

    private void setupMenuButton(JButton btn, String cardName, JButton[] allButtons) {
        btn.addActionListener(e -> {
            cardLayout.show(contentPanel, cardName);
            resetMenuColor(allButtons);
            btn.setBackground(new Color(70, 130, 180));
        });
    }
}