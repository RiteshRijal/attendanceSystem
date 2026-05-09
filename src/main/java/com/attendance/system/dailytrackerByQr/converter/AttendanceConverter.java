package com.attendance.system.dailytrackerByQr.converter;

import com.attendance.system.dailytrackerByQr.dto.AttendanceDto;
import com.attendance.system.dailytrackerByQr.entity.Attendance;
import org.springframework.stereotype.Component;


@Component
public class AttendanceConverter {

    public static Attendance toEntity(AttendanceDto dto) {

        Attendance attendance = new Attendance();
        attendance.setId(dto.getId());
        attendance.setUser(UserConverter.toEntity(dto.getUserDto()));
        attendance.setSubject(SubjectConverter.toEntity(dto.getSubjectDto()));
        attendance.setDate(dto.getDate());
        attendance.setIsPresent(dto.getIsPresent());
        return attendance;
    }

    public static AttendanceDto toDto(Attendance entity) {

        AttendanceDto dto = new AttendanceDto();

        dto.setId(entity.getId());

        if (entity.getUser() != null) {
            dto.setUserDto(UserConverter.toDto(entity.getUser() ));
        }

        if (entity.getSubject() != null) {
            dto.setSubjectDto(SubjectConverter.toDto(entity.getSubject()));
        }

        if (entity.getDate() != null) {
            dto.setDate(entity.getDate());
        }

        return dto;
    }
}
