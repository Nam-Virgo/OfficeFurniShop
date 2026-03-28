package service;

import dao.RoleDAO;
import dao.UserDAO;
import jakarta.persistence.*;
import model.*;

public class AuthService {

    private UserDAO userDAO = new UserDAO();
    private RoleDAO roleDAO = new RoleDAO();

    // 🔐 LOGIN
    public User login(String email, String password) {

        User user = userDAO.findByEmail(email);

        if (user == null) return null;

        if (!user.getPassword().equals(password)) return null;

        if (user.getIsActive() == 0) return null;

        return user;
    }

    // 📝 REGISTER CUSTOMER
    public boolean register(String name, String email, String password) {

        // check tồn tại
        if (userDAO.findByEmail(email) != null) {
            return false;
        }

        EntityManager em = util.JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();

            // 🔹 Role CUSTOMER
            Role role = roleDAO.findByName("CUSTOMER");

            // 🔹 Tạo User
            User user = new User();
            user.setName(name);
            user.setEmail(email);
            user.setPassword(password);
            user.setIsActive(1);
            user.setIsDelete(0);
            user.setRole(role);

            em.persist(user);

            // 🔹 Tạo Customer (shared PK)
            Customer customer = new Customer();
            customer.setUser(user);

            em.persist(customer);

            tx.commit();
            return true;

        } catch (Exception e) {
            tx.rollback();
            return false;
        } finally {
            em.close();
        }
    }
}