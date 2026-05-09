package com.attendance.system.dailytrackerByQr.daoImpl;


import com.attendance.system.dailytrackerByQr.dao.AttendanceDao;
import com.attendance.system.dailytrackerByQr.entity.Attendance;
import org.springframework.stereotype.Repository;

@Repository
public class AttendanceDaoImpl extends GenericDaoImpl<Attendance, Long> implements AttendanceDao {
}
