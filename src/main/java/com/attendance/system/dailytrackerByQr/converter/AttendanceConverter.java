package com.attendance.system.dailytrackerByQr.converter;

import com.attendance.system.dailytrackerByQr.dto.AttendanceDto;
import com.attendance.system.dailytrackerByQr.entity.Attendance;
import org.springframework.stereotype.Component;


@Component
public class AttendanceConverter {

    public static Attendance toEntity(AttendanceDto dto) {

        Attendance attendance = new Attendance();
        attendance.setId(dto.getId());
        attendance.setUserSubjectMap(UserSubjectMapConverter.toEntity(dto.getUserSubjectMapDto()));
        attendance.setDate(dto.getDate());
        attendance.setIsPresent(dto.getIsPresent());
        attendance.setToken(dto.getToken());
        return attendance;
    }

    public static AttendanceDto toDto(Attendance entity) {

        AttendanceDto dto = new AttendanceDto();
        dto.setId(entity.getId());
        if (entity.getUserSubjectMap() != null) {
            dto.setUserSubjectMapDto(UserSubjectMapConverter.toDto(entity.getUserSubjectMap()));
        }
        if (entity.getDate() != null) {
            dto.setDate(entity.getDate());
        }
        dto.setToken(entity.getToken());
        dto.setIsPresent(entity.getIsPresent());
        return dto;
    }
}
