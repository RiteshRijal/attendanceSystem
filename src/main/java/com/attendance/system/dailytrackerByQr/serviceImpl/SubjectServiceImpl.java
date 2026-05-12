package com.attendance.system.dailytrackerByQr.serviceImpl;


import com.attendance.system.dailytrackerByQr.converter.SubjectConverter;
import com.attendance.system.dailytrackerByQr.dao.SubjectDao;
import com.attendance.system.dailytrackerByQr.dto.SubjectDto;
import com.attendance.system.dailytrackerByQr.entity.Subject;
import com.attendance.system.dailytrackerByQr.service.SubjectService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubjectServiceImpl implements SubjectService {

    private final SubjectDao subjectDao;

    public SubjectServiceImpl(SubjectDao subjectDao) {

        this.subjectDao = subjectDao;
    }

    @Override
    public SubjectDto save(SubjectDto dto) {

        Subject subject = SubjectConverter.toEntity(dto);

        subjectDao.save(subject);

        return SubjectConverter.toDto(subject);
    }

    @Override
    public SubjectDto update(SubjectDto dto) {

        Subject subject = SubjectConverter.toEntity(dto);

        subject = subjectDao.update(subject);

        return SubjectConverter.toDto(subject);
    }

    @Override
    public void delete(Long id) {

        Subject subject = subjectDao.findById(id);

        if (subject != null) {
            subjectDao.delete(subject);
        }
    }

    @Override
    public SubjectDto findById(Long id) {

        Subject subject = subjectDao.findById(id);

        if (subject == null) {
            return null;
        }

        return SubjectConverter.toDto(subject);
    }

    @Override
    public List<SubjectDto> findAll() {

        return subjectDao.findAll().stream().map(SubjectConverter::toDto).collect(Collectors.toList());
    }
}
