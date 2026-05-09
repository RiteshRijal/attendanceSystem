package com.attendance.system.dailytrackerByQr.service;


import com.attendance.system.dailytrackerByQr.dto.SubjectDto;

import java.util.List;

public interface SubjectService {

    SubjectDto save(SubjectDto dto);

    SubjectDto update(SubjectDto dto);

    void delete(Long id);

    SubjectDto findById(Long id);

    List<SubjectDto> findAll();
}
