package com.attendance.system.dailytrackerByQr.serviceImpl;

import com.attendance.system.dailytrackerByQr.converter.UserConverter;
import com.attendance.system.dailytrackerByQr.dao.UserDao;
import com.attendance.system.dailytrackerByQr.dto.UserDto;
import com.attendance.system.dailytrackerByQr.entity.User;
import com.attendance.system.dailytrackerByQr.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public UserDto save(UserDto dto) {

        User user = UserConverter.toEntity(dto);

        userDao.save(user);

        return UserConverter.toDto(user);
    }

    @Override
    public UserDto update(UserDto dto) {

        User user = UserConverter.toEntity(dto);

        user = userDao.update(user);

        return UserConverter.toDto(user);
    }

    @Override
    public void delete(Long id) {

        User user = userDao.findById(id);

        if (user != null) {
            userDao.delete(user);
        }
    }

    @Override
    public UserDto findById(Long id) {

        User user = userDao.findById(id);

        if (user == null) {
            return null;
        }

        return UserConverter.toDto(user);
    }

    @Override
    public List<UserDto> findAll() {

        return userDao.findAll()
                .stream()
                .map(UserConverter::toDto)
                .collect(Collectors.toList());
    }
}

