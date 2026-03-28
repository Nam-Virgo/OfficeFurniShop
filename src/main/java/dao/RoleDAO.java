package dao;

import jakarta.persistence.*;
import model.Role;
import util.JPAUtil;

public class RoleDAO {

    public Role findByName(String roleName) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createQuery(
                            "SELECT r FROM Role r WHERE r.roleName = :name",
                            Role.class)
                    .setParameter("name", roleName)
                    .getSingleResult();
        } catch (Exception e) {
            return null;
        } finally {
            em.close();
        }
    }
}