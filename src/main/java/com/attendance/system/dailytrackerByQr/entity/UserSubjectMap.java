package com.attendance.system.dailytrackerByQr.entity;

import com.attendance.system.dailytrackerByQr.abstractClasses.AbstractId;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name="USER_SUBJECT_MAP")
public class UserSubjectMap extends AbstractId {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Subject_ID")
    private Subject subject;

    @OneToMany(mappedBy = "userSubjectMap", cascade = CascadeType.ALL)
    private List<Attendance> attendances = new ArrayList<>();


}
