package com.attendance.system.dailytrackerByQr.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class QrSessionDto {

    private Long id;

    private String token;

    private Date date;

    private SubjectDto subjectDto;

    private Long subjectId;

    public SubjectDto getSubjectDto() {
        if (subjectDto == null) {
            subjectDto = new SubjectDto();
            if (subjectId != null) {
                subjectDto.setId(subjectId);
            }
        }
        return subjectDto;
    }


}
