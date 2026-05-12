package com.attendance.system.dailytrackerByQr.converter;

import com.attendance.system.dailytrackerByQr.dto.UserSubjectMapDto;
import com.attendance.system.dailytrackerByQr.entity.UserSubjectMap;
import org.springframework.stereotype.Component;

@Component
public class UserSubjectMapConverter {

    public static UserSubjectMap toEntity(UserSubjectMapDto dto) {

        UserSubjectMap userSubjectMap = new UserSubjectMap();
        userSubjectMap.setId(dto.getId());
        userSubjectMap.setSubject(SubjectConverter.toEntity(dto.getSubjectDto()));
        userSubjectMap.setUser(UserConverter.toEntity(dto.getUserDto()));
        return userSubjectMap;
    }

    public static UserSubjectMapDto toDto(UserSubjectMap entity) {

        UserSubjectMapDto dto = new UserSubjectMapDto();
        dto.setId(entity.getId());
        dto.setUserDto(UserConverter.toDto(entity.getUser()));
        dto.setSubjectDto(SubjectConverter.toDto(entity.getSubject()));
        return dto;
    }
}
