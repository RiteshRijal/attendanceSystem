package com.attendance.system.dailytrackerByQr.controller;

import com.attendance.system.dailytrackerByQr.dto.UserDto;
import com.attendance.system.dailytrackerByQr.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public UserDto create(@RequestBody UserDto dto) {
        return userService.save(dto);
    }

    @PutMapping
    public UserDto update(@RequestBody UserDto dto) {
        return userService.update(dto);
    }

    @GetMapping("/{id}")
    public UserDto getById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @GetMapping
    public List<UserDto> getAll() {
        return userService.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }
}
