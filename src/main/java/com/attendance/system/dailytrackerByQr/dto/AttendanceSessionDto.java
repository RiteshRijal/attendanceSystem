package com.attendance.system.dailytrackerByQr.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AttendanceSessionDto {

    private String token;

    private Long subjectId;

    private String date;
}
