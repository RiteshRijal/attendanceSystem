package com.attendance.system.dailytrackerByQr.controller;

import com.attendance.system.dailytrackerByQr.dto.UserSubjectMapDto;
import com.attendance.system.dailytrackerByQr.service.UserSubjectMapService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/group")
public class UserSubjectMapController {

    private final UserSubjectMapService userSubjectMapService;

    public UserSubjectMapController(UserSubjectMapService userSubjectMapService) {
        this.userSubjectMapService = userSubjectMapService;
    }

    @PostMapping
    public UserSubjectMapDto create(@RequestBody UserSubjectMapDto dto) {
        return userSubjectMapService.save(dto);
    }

    @PutMapping
    public UserSubjectMapDto update(@RequestBody UserSubjectMapDto dto) {
        return userSubjectMapService.update(dto);
    }

    @GetMapping("/{id}")
    public UserSubjectMapDto getById(@PathVariable Long id) {
        return userSubjectMapService.findById(id);
    }

    @GetMapping("/subject/{subjectId}")
    public List<UserSubjectMapDto> getAllBySubjectId(@PathVariable Long subjectId) {
        if (subjectId != null) {
            return userSubjectMapService.findAllBySubjectId(subjectId);
        }
        return new ArrayList<>();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        userSubjectMapService.delete(id);
    }
}
