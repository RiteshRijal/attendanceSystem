package com.attendance.system.dailytrackerByQr.daoImpl;

import com.attendance.system.dailytrackerByQr.dao.QrSessionDao;
import com.attendance.system.dailytrackerByQr.entity.QrSession;
import org.springframework.stereotype.Repository;

@Repository
public class QrSessionDaoImpl extends GenericDaoImpl<QrSession, Long> implements QrSessionDao {

    @Override
    public QrSession findByToken(String token) {

        try {
            return entityManager.createQuery(
                            "SELECT q FROM QrSession q WHERE q.token= :token",
                            QrSession.class
                    )
                    .setParameter("token", token)
                    .getSingleResult();

        } catch (Exception e) {
            return null; // if user not found
        }
    }
}
