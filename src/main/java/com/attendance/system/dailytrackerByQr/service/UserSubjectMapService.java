package com.attendance.system.dailytrackerByQr.service;

import com.attendance.system.dailytrackerByQr.dto.UserSubjectMapDto;

import java.util.List;

public interface UserSubjectMapService {

    UserSubjectMapDto save(UserSubjectMapDto dto);

    UserSubjectMapDto update(UserSubjectMapDto dto);

    void delete(Long id);

    UserSubjectMapDto findById(Long id);

    List<UserSubjectMapDto> findAllBySubjectId(Long id);
}
