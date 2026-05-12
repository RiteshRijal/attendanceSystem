package com.attendance.system.dailytrackerByQr.entity;

import com.attendance.system.dailytrackerByQr.abstractClasses.AbstractId;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "ATTENDANCE")
public class Attendance extends AbstractId {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_SUBJECT_MAP")
    private UserSubjectMap userSubjectMap;

    @Column(name="IS_PRESENT")
    private Boolean isPresent;

    @Column(name="DATE")
    private Date date;

    @Column(name="TOKEN")
    private String token;

}
