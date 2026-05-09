package com.attendance.system.dailytrackerByQr.converter;


import com.attendance.system.dailytrackerByQr.dto.UserDto;
import com.attendance.system.dailytrackerByQr.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    public static User toEntity(UserDto dto) {

        User user = new User();
        user.setId(dto.getId());
        user.setManualId(dto.getManualId());
        user.setEmail(dto.getEmail());
        return user;
    }

    public static UserDto toDto(User entity) {

        UserDto dto = new UserDto();
        dto.setId(entity.getId());
        dto.setManualId(entity.getManualId());
        dto.setEmail(entity.getEmail());
        return dto;
    }
}
