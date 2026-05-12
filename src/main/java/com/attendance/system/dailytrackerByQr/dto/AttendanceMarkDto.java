package com.attendance.system.dailytrackerByQr.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AttendanceMarkDto {

    private String token;

    private Long userSubjectMapId;
}