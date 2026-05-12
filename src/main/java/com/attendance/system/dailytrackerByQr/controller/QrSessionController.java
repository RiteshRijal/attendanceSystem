package com.attendance.system.dailytrackerByQr.controller;

import com.attendance.system.dailytrackerByQr.dto.QrSessionDto;
import com.attendance.system.dailytrackerByQr.dto.SubjectDto;
import com.attendance.system.dailytrackerByQr.dto.UserSubjectMapDto;
import com.attendance.system.dailytrackerByQr.service.QrSessionService;
import com.attendance.system.dailytrackerByQr.service.SubjectService;
import com.attendance.system.dailytrackerByQr.service.UserSubjectMapService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/session")
public class QrSessionController {

    private final QrSessionService qrSessionService;
    private final SubjectService subjectService;
    private final UserSubjectMapService userSubjectMapService;

    public QrSessionController(QrSessionService qrSessionService,
                               SubjectService subjectService,
                               UserSubjectMapService userSubjectMapService) {
        this.qrSessionService = qrSessionService;
        this.subjectService = subjectService;
        this.userSubjectMapService = userSubjectMapService;
    }

    @PostMapping("/create")
    public QrSessionDto create(@RequestParam Long subjectId,
                               @RequestParam String date) {
        QrSessionDto dto = new QrSessionDto();
        SubjectDto subjectDto = new SubjectDto();
        subjectDto.setId(subjectId);
        dto.setSubjectDto(subjectDto);
        dto.setDate(java.sql.Date.valueOf(date));
        dto.setToken(java.util.UUID.randomUUID().toString());
        return qrSessionService.save(dto);
    }

    @GetMapping("/token")
    public List<UserSubjectMapDto> loadUsers(@RequestParam String token) {

        QrSessionDto session = qrSessionService.findByToken(token);

        if (session == null || session.getSubjectDto() == null) {
            return new ArrayList<>();
        }

        Long subjectId = session.getSubjectDto().getId();

        return userSubjectMapService.findAllBySubjectId(subjectId);
    }
}