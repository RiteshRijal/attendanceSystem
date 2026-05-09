package com.attendance.system.dailytrackerByQr.service;


import com.attendance.system.dailytrackerByQr.dto.UserDto;

import java.util.List;

public interface UserService {

    UserDto save(UserDto dto);

    UserDto update(UserDto dto);

    void delete(Long id);

    UserDto findById(Long id);

    List<UserDto> findAll();
}
