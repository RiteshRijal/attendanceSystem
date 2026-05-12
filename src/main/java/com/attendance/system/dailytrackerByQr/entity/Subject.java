package com.attendance.system.dailytrackerByQr.entity;

import com.attendance.system.dailytrackerByQr.abstractClasses.AbstractProfile;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name="SUBJECT")
public class Subject extends AbstractProfile {

    @OneToMany(mappedBy = "subject", cascade = CascadeType.ALL)
    private List<QrSession> qrSessions = new ArrayList<>();

}
