package view;

import controller.AuthController;

import javax.swing.*;
import java.awt.*;

public class RegisterForm extends JFrame {

    private JTextField txtName, txtEmail;
    private JPasswordField txtPassword;
    private JButton btnRegister, btnBack;

    private AuthController controller = new AuthController();

    public RegisterForm() {
        setTitle("ĐĂNG KÝ");
        setSize(400, 300);
        setLocationRelativeTo(null);

        initUI();
    }

    private void initUI() {

        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        panel.add(new JLabel("Tên:"));
        txtName = new JTextField();
        panel.add(txtName);

        panel.add(new JLabel("Email:"));
        txtEmail = new JTextField();
        panel.add(txtEmail);

        panel.add(new JLabel("Mật khẩu:"));
        txtPassword = new JPasswordField();
        panel.add(txtPassword);

        btnRegister = new JButton("Đăng ký");
        btnBack = new JButton("Trở lại");

        panel.add(btnRegister);
        panel.add(btnBack);

        add(panel);

        // 🎮 gọi controller
        btnRegister.addActionListener(e -> handleRegister());
        btnBack.addActionListener(e -> {
            new LoginForm().setVisible(true);
            dispose();
        });
    }

    private void handleRegister() {

        String name = txtName.getText();
        String email = txtEmail.getText();
        String password = new String(txtPassword.getPassword());

        boolean success = controller.register(name, email, password);

        if (success) {
            JOptionPane.showMessageDialog(this, "Đăng ký thành công");
            new LoginForm().setVisible(true);
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Email đã tồn tại");
        }
    }
}