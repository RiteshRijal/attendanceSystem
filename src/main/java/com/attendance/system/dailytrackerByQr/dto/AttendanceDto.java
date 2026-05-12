package com.attendance.system.dailytrackerByQr.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class AttendanceDto {

    private Long id;

    private UserSubjectMapDto userSubjectMapDto;

    private String token;

    private Date date;

    private Boolean isPresent;

    public UserSubjectMapDto getUserSubjectMapDto() {
        if (userSubjectMapDto == null) {
            userSubjectMapDto = new UserSubjectMapDto();
        }
        return userSubjectMapDto;
    }



}
