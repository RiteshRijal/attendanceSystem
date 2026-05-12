package com.attendance.system.dailytrackerByQr.daoImpl;


import com.attendance.system.dailytrackerByQr.dao.UserDao;
import com.attendance.system.dailytrackerByQr.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl extends GenericDaoImpl<User, Long> implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User findByManualId(Long userId) {

        try {
            return entityManager.createQuery(
                            "SELECT u FROM User u WHERE u.manualId = :userId",
                            User.class
                    )
                    .setParameter("userId", userId)
                    .getSingleResult();

        } catch (Exception e) {
            return null; // if user not found
        }
    }

}