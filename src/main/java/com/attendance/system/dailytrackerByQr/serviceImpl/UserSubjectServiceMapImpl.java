package com.attendance.system.dailytrackerByQr.serviceImpl;

import com.attendance.system.dailytrackerByQr.converter.UserConverter;
import com.attendance.system.dailytrackerByQr.converter.UserSubjectMapConverter;
import com.attendance.system.dailytrackerByQr.dao.UserSubjectMapDao;
import com.attendance.system.dailytrackerByQr.dto.UserDto;
import com.attendance.system.dailytrackerByQr.dto.UserSubjectMapDto;
import com.attendance.system.dailytrackerByQr.entity.User;
import com.attendance.system.dailytrackerByQr.entity.UserSubjectMap;
import com.attendance.system.dailytrackerByQr.service.UserSubjectMapService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserSubjectServiceMapImpl implements UserSubjectMapService {

    private final UserSubjectMapDao userSubjectMapDao;

    public UserSubjectServiceMapImpl(UserSubjectMapDao userSubjectMapDao) {
        this.userSubjectMapDao = userSubjectMapDao;
    }

    @Override
    public UserSubjectMapDto save(UserSubjectMapDto dto) {

        UserSubjectMap userSubjectMap = UserSubjectMapConverter.toEntity(dto);

        userSubjectMapDao.save(userSubjectMap);

        return UserSubjectMapConverter.toDto(userSubjectMap);
    }

    @Override
    public UserSubjectMapDto update(UserSubjectMapDto dto) {

        UserSubjectMap userSubjectMap = UserSubjectMapConverter.toEntity(dto);

        userSubjectMap = userSubjectMapDao.update(userSubjectMap);

        return UserSubjectMapConverter.toDto(userSubjectMap);
    }

    @Override
    public void delete(Long id) {

        UserSubjectMap userSubjectMap = userSubjectMapDao.findById(id);

        if (userSubjectMap != null) {
            userSubjectMapDao.delete(userSubjectMap);
        }
    }

    @Override
    public UserSubjectMapDto findById(Long id) {

        UserSubjectMap userSubjectMap = userSubjectMapDao.findById(id);

        if (userSubjectMap == null) {
            return null;
        }

        return UserSubjectMapConverter.toDto(userSubjectMap);
    }

    @Override
    public List<UserSubjectMapDto> findAllBySubjectId(Long id) {

        return userSubjectMapDao.findAllBySubjectId(id)
                .stream()
                .map(UserSubjectMapConverter::toDto)
                .collect(Collectors.toList());
    }
}
