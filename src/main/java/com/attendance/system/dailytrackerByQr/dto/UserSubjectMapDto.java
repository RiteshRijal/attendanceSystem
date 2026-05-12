package com.attendance.system.dailytrackerByQr.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserSubjectMapDto {

    private Long id;

    private SubjectDto subjectDto;

    private UserDto userDto;

    public UserDto getUserDto() {
        if (userDto == null) {
            userDto = new UserDto();
        }
        return userDto;
    }

    public SubjectDto getSubjectDto(){
        if(subjectDto==null){
            subjectDto=new SubjectDto();
        }
        return subjectDto;
    }
}
