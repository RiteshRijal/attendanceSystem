package com.attendance.system.dailytrackerByQr.service;

import com.attendance.system.dailytrackerByQr.dto.AttendanceDto;

import java.util.List;

public interface AttendanceService {

   AttendanceDto save(AttendanceDto dto);

   AttendanceDto update(AttendanceDto dto);

    void delete(Long id);

   AttendanceDto findById(Long id);

    List<AttendanceDto> findAll();
}
