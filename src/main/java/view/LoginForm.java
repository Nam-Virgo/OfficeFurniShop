package view;

import controller.AuthController;
import model.User;

import javax.swing.*;
import java.awt.*;

public class LoginForm extends JFrame {

    private JTextField txtEmail;
    private JPasswordField txtPassword;
    private JButton btnLogin, btnRegister;

    private AuthController controller = new AuthController();

    public LoginForm() {
        setTitle("Login");
        setSize(400, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initUI();
    }

    private void initUI() {

        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        panel.add(new JLabel("Email:"));
        txtEmail = new JTextField();
        panel.add(txtEmail);

        panel.add(new JLabel("Password:"));
        txtPassword = new JPasswordField();
        panel.add(txtPassword);

        btnLogin = new JButton("Đăng nhập");
        btnRegister = new JButton("Đăng ký");

        panel.add(btnLogin);
        panel.add(btnRegister);

        add(panel);

        // 🎮 gọi controller
        btnLogin.addActionListener(e -> handleLogin());
        btnRegister.addActionListener(e -> {
            new RegisterForm().setVisible(true);
            dispose();
        });
    }

    private void handleLogin() {

        String email = txtEmail.getText();
        String password = new String(txtPassword.getPassword());

        User user = controller.login(email, password);

        if (user == null) {
            JOptionPane.showMessageDialog(this, "Sai tài khoản hoặc mật khẩu");
            return;
        }

        String role = user.getRole().getRoleName();

        JOptionPane.showMessageDialog(this, "Welcome " + role);

        dispose();

        if (role.equalsIgnoreCase("ADMINISTRATOR")) {
            new AdminMainFrame().setVisible(true);
        } else {
            new CustomerForm().setVisible(true);
        }
    }
}

