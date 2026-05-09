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
}