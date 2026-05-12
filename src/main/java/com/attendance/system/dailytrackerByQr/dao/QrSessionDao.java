package com.attendance.system.dailytrackerByQr.dao;


import com.attendance.system.dailytrackerByQr.entity.QrSession;

public interface QrSessionDao extends GenericDao<QrSession, Long> {
    QrSession findByToken(String token);
}
