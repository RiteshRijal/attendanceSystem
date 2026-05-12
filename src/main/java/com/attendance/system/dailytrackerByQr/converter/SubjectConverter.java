package com.attendance.system.dailytrackerByQr.converter;

import com.attendance.system.dailytrackerByQr.dto.SubjectDto;
import com.attendance.system.dailytrackerByQr.entity.Subject;
import org.springframework.stereotype.Component;

@Component
public class SubjectConverter {

    public static Subject toEntity(SubjectDto dto) {

        Subject subject = new Subject();
        subject.setId(dto.getId());
        subject.setName(dto.getName());
        return subject;
    }

    public static SubjectDto toDto(Subject entity) {

        SubjectDto dto = new SubjectDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        return dto;
    }
}