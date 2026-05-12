package com.attendance.system.dailytrackerByQr.controller;

import com.attendance.system.dailytrackerByQr.dto.*;
import com.attendance.system.dailytrackerByQr.entity.QrSession;
import com.attendance.system.dailytrackerByQr.service.AttendanceService;
import com.attendance.system.dailytrackerByQr.service.QrSessionService;
import com.attendance.system.dailytrackerByQr.service.SubjectService;
import com.attendance.system.dailytrackerByQr.service.UserSubjectMapService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@RestController
@RequestMapping("/api/attendance")
public class AttendanceController {

    private List<UserSubjectMapDto> userSubjectMapDtos;

    private final AttendanceService attendanceService;
    private final SubjectService subjectService;
    private final UserSubjectMapService userSubjectMapService;
    private final QrSessionService qrSessionService;

    public AttendanceController(AttendanceService attendanceService, SubjectService subjectService, UserSubjectMapService userSubjectMapService, QrSessionService qrSessionService) {
        this.attendanceService = attendanceService;
        this.subjectService = subjectService;
        this.userSubjectMapService = userSubjectMapService;
        this.qrSessionService=qrSessionService;
    }

    @PostMapping
    public AttendanceDto create(@RequestBody AttendanceDto dto) {
        return attendanceService.save(dto);
    }

    @PutMapping
    public AttendanceDto update(@RequestBody AttendanceDto dto) {
        return attendanceService.update(dto);
    }

    @GetMapping("/{id}")
    public AttendanceDto getById(@PathVariable Long id) {
        return attendanceService.findById(id);
    }

    @GetMapping
    public List<AttendanceDto> getAll() {
        return attendanceService.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        attendanceService.delete(id);
    }

    // MARK ATTENDANCE FROM QR
    @PostMapping("/mark")
    public ResponseEntity<?> mark(@RequestBody AttendanceDto dto) {
        attendanceService.mark(dto.getToken(), dto.getUserSubjectMapDto().getId());
        return ResponseEntity.ok("Success");
    }

    @GetMapping("/filter")
    public List<AttendanceDto> getBySubjectAndDate(
            @RequestParam Long subjectId,
            @RequestParam String date
    ) {
        return attendanceService
                .getAllByDateAndSubjectId(subjectId, date);
    }


}
