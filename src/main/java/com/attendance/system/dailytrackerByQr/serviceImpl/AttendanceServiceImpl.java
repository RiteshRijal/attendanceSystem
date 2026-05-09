package com.attendance.system.dailytrackerByQr.serviceImpl;


import com.attendance.system.dailytrackerByQr.converter.AttendanceConverter;
import com.attendance.system.dailytrackerByQr.dao.AttendanceDao;
import com.attendance.system.dailytrackerByQr.dto.AttendanceDto;
import com.attendance.system.dailytrackerByQr.entity.Attendance;
import com.attendance.system.dailytrackerByQr.service.AttendanceService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AttendanceServiceImpl implements AttendanceService {

    private final AttendanceDao attendanceDao;

    public AttendanceServiceImpl(AttendanceDao attendanceDao) {

        this.attendanceDao = attendanceDao;
    }

    @Override
    public AttendanceDto save(AttendanceDto dto) {

        Attendance attendance = AttendanceConverter.toEntity(dto);

        attendanceDao.save(attendance);

        return AttendanceConverter.toDto(attendance);
    }

    @Override
    public AttendanceDto update(AttendanceDto dto) {

        Attendance attendance = AttendanceConverter.toEntity(dto);

        attendance = attendanceDao.update(attendance);

        return AttendanceConverter.toDto(attendance);
    }

    @Override
    public void delete(Long id) {

        Attendance attendance = attendanceDao.findById(id);

        if (attendance != null) {
            attendanceDao.delete(attendance);
        }
    }

    @Override
    public AttendanceDto findById(Long id) {

        Attendance attendance = attendanceDao.findById(id);

        if (attendance == null) {
            return null;
        }

        return AttendanceConverter.toDto(attendance);
    }

    @Override
    public List<AttendanceDto> findAll() {

        return attendanceDao.findAll().stream().map(AttendanceConverter::toDto).collect(Collectors.toList());
    }
}