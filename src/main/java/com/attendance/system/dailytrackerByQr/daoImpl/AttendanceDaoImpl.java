package com.attendance.system.dailytrackerByQr.daoImpl;


import com.attendance.system.dailytrackerByQr.dao.AttendanceDao;
import com.attendance.system.dailytrackerByQr.dto.AttendanceDto;
import com.attendance.system.dailytrackerByQr.dto.AttendanceMarkDto;
import com.attendance.system.dailytrackerByQr.entity.Attendance;
import com.attendance.system.dailytrackerByQr.entity.UserSubjectMap;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Repository
public class AttendanceDaoImpl extends GenericDaoImpl<Attendance, Long> implements AttendanceDao {

    @Override
    public List<Attendance> getAllByDateAndSubjectId(Long subjectId, Date date) {

        try {

            Date startDate= getStartdate(date);
            Date endDate = getEndDate(date);

            return entityManager.createQuery(
                            "SELECT a FROM Attendance a " +
                                    "WHERE a.userSubjectMap.subject.id = :subjectId " +
                                    "AND a.date BETWEEN :startDate AND :endDate",
                            Attendance.class)
                    .setParameter("subjectId", subjectId)
                    .setParameter("startDate", startDate)
                    .setParameter("endDate", endDate)
                    .getResultList();

        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    public Date getStartdate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);

        return cal.getTime();
    }

    private Date getEndDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 999);
        return cal.getTime();
    }

    @Override
    public boolean existsByUserSubjectMapIdAndDate(Long id, Date date) {

        try {
            Date startDate= getStartdate(date);
            Date endDate = getEndDate(date);

            Long count = entityManager.createQuery(
                            "SELECT COUNT(a) FROM Attendance a " +
                                    "WHERE a.userSubjectMap.id = :id " +
                                    "AND a.date BETWEEN :startDate AND :endDate",
                            Long.class)
                    .setParameter("id", id)
                    .setParameter("startDate", startDate)
                    .setParameter("endDate", endDate)
                    .getSingleResult();

            return count > 0;

        } catch (Exception e) {
            return false;
        }
    }

}
