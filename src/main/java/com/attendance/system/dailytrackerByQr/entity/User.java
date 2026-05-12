package com.attendance.system.dailytrackerByQr.entity;


import com.attendance.system.dailytrackerByQr.abstractClasses.AbstractProfile;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "USER")
public class User extends AbstractProfile{

    @Column(name= "MANUAL_ID")
    private String manualId;

    @Column(name="EMAIL")
    private String email;

}
