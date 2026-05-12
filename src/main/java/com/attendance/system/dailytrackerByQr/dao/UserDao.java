package com.attendance.system.dailytrackerByQr.dao;


import com.attendance.system.dailytrackerByQr.entity.User;

public interface UserDao extends GenericDao<User, Long> {
    User findByManualId(Long userId);
}
