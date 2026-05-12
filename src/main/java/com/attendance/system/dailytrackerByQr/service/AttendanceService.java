package com.attendance.system.dailytrackerByQr.service;

import com.attendance.system.dailytrackerByQr.dto.AttendanceDto;
import com.attendance.system.dailytrackerByQr.dto.AttendanceMarkDto;
import com.attendance.system.dailytrackerByQr.dto.QrSessionDto;

import java.util.List;

public interface AttendanceService {

    AttendanceDto save(AttendanceDto dto);

    AttendanceDto update(AttendanceDto dto);

    void delete(Long id);

    AttendanceDto findById(Long id);

    List<AttendanceDto> findAll();

    List<AttendanceDto> getAllByDateAndSubjectId(Long subjectId,String date);

    void mark(String token, Long userSubjectId);
}
