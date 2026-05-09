package com.attendance.system.dailytrackerByQr.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class AttendanceDto {

    private Long id;

    private UserDto userDto;

    private SubjectDto subjectDto;

    private Date date;

    private Boolean isPresent;

    public UserDto getUserDto() {
        if (userDto == null) {
            userDto = new UserDto();
        }
        return userDto;
    }

    public SubjectDto getSubjectDto() {
        if (subjectDto == null) {
            subjectDto = new SubjectDto();
        }
        return subjectDto;
    }


}
