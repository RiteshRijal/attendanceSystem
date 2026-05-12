package com.attendance.system.dailytrackerByQr.entity;

import com.attendance.system.dailytrackerByQr.abstractClasses.AbstractId;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name="QR_SESSION")
public class QrSession extends AbstractId {

    private String token;

    private Date date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SUBJECT")
    private Subject subject;
}
