package com.attendance.system.dailytrackerByQr.controller;

import com.attendance.system.dailytrackerByQr.dto.AttendanceDto;
import com.attendance.system.dailytrackerByQr.service.AttendanceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/attendance")
public class AttendanceController {

    private final AttendanceService attendanceService;

    public AttendanceController(AttendanceService attendanceService) {
        this.attendanceService = attendanceService;
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
}
