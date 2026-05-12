package com.attendance.system.dailytrackerByQr.dao;


import com.attendance.system.dailytrackerByQr.dto.AttendanceDto;
import com.attendance.system.dailytrackerByQr.dto.AttendanceMarkDto;
import com.attendance.system.dailytrackerByQr.entity.Attendance;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public interface AttendanceDao extends GenericDao<Attendance, Long> {
    List<Attendance> getAllByDateAndSubjectId(Long subjectId, Date date);

    boolean existsByUserSubjectMapIdAndDate(Long id, Date date);
}
