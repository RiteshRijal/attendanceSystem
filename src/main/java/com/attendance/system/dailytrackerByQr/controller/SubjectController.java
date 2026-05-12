package com.attendance.system.dailytrackerByQr.controller;

import com.attendance.system.dailytrackerByQr.dto.SubjectDto;
import com.attendance.system.dailytrackerByQr.service.SubjectService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subjects")
public class SubjectController {

    private final SubjectService subjectService;

    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @PostMapping
    public SubjectDto create(@RequestBody SubjectDto dto) {
        return subjectService.save(dto);
    }

    @PutMapping
    public SubjectDto update(@RequestBody SubjectDto dto) {
        return subjectService.update(dto);
    }

    @GetMapping("/{id}")
    public SubjectDto getById(@PathVariable Long id) {
        return subjectService.findById(id);
    }

    @GetMapping
    public List<SubjectDto> getAll() {
        return subjectService.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        subjectService.delete(id);
    }
}
