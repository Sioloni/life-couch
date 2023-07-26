package ru.project.life.couch.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.project.life.couch.dto.UserDto;
import ru.project.life.couch.service.UserService;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/product/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService service;


    @GetMapping
    public List<UserDto> get() {
        return service.get();
    }

    @GetMapping("/{id}")
    public UserDto get(@PathVariable Long id) {
        return service.get(id);
    }

    @PostMapping
    public void create(@RequestBody UserDto dto) {
        service.create(dto);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody UserDto dto) {
        service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
