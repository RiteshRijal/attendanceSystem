package com.attendance.system.dailytrackerByQr.serviceImpl;


import com.attendance.system.dailytrackerByQr.converter.AttendanceConverter;
import com.attendance.system.dailytrackerByQr.dao.AttendanceDao;
import com.attendance.system.dailytrackerByQr.dao.QrSessionDao;
import com.attendance.system.dailytrackerByQr.dao.UserSubjectMapDao;
import com.attendance.system.dailytrackerByQr.dto.AttendanceDto;
import com.attendance.system.dailytrackerByQr.dto.AttendanceMarkDto;
import com.attendance.system.dailytrackerByQr.dto.QrSessionDto;
import com.attendance.system.dailytrackerByQr.entity.Attendance;
import com.attendance.system.dailytrackerByQr.entity.QrSession;
import com.attendance.system.dailytrackerByQr.entity.UserSubjectMap;
import com.attendance.system.dailytrackerByQr.service.AttendanceService;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AttendanceServiceImpl implements AttendanceService {

    private final AttendanceDao attendanceDao;

    private final QrSessionDao qrSessionDao;

    private final UserSubjectMapDao userSubjectMapDao;

    public AttendanceServiceImpl(AttendanceDao attendanceDao, QrSessionDao qrSessionDao, UserSubjectMapDao userSubjectMapDao) {

        this.attendanceDao = attendanceDao;
        this.qrSessionDao = qrSessionDao;
        this.userSubjectMapDao = userSubjectMapDao;
    }

    @Override
    public AttendanceDto save(AttendanceDto dto) {

        UserSubjectMap userSubjectMap=userSubjectMapDao.findById(dto.getUserSubjectMapDto().getId());
        Attendance attendance = AttendanceConverter.toEntity(dto);
        attendance.setUserSubjectMap(userSubjectMap);
        attendanceDao.save(attendance);

        return AttendanceConverter.toDto(attendance);
    }

    @Override
    public AttendanceDto update(AttendanceDto dto) {
        Attendance attendance = attendanceDao.findById(dto.getId());
        attendance.setIsPresent(dto.getIsPresent());
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

    @Override
    public void mark(String token, Long id){
        QrSession qrSession = qrSessionDao.findByToken(token);
        UserSubjectMap userSubjectMap = userSubjectMapDao.findById(id);
        Long subjectId = qrSession.getSubject().getId();
        Date date = qrSession.getDate();

        boolean exists = attendanceDao.existsByUserSubjectMapIdAndDate(userSubjectMap.getId(), date);

        if (exists) {
            throw new RuntimeException("Already marked attendance");
        }

        Attendance att = new Attendance();
        att.setUserSubjectMap(userSubjectMap);
        att.setToken(token);
        att.setDate(qrSession.getDate());
        att.setIsPresent(true);
        attendanceDao.save(att);





    }

    public List<AttendanceDto> getAllByDateAndSubjectId(Long subjectId, String date) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date parsedDate = sdf.parse(date);
            return attendanceDao.getAllByDateAndSubjectId(subjectId, parsedDate).stream().map(AttendanceConverter::toDto).collect(Collectors.toList());
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
}