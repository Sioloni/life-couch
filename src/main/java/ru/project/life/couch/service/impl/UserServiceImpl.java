package ru.project.life.couch.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.project.life.couch.dto.UserDto;
import ru.project.life.couch.mapper.UserMapper;
import ru.project.life.couch.repository.UserRepository;
import ru.project.life.couch.service.UserService;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    private final UserMapper mapper;


    @Override
    @Transactional
    public List<UserDto> get() {
        return mapper.toDto(repository.findAll());
    }

    @Override
    @Transactional
    public UserDto get(Long id) {
        return mapper.toDto(repository.findById(id).get());
    }

    @Override
    @Transactional
    public void create(UserDto dto) {
        repository.save(mapper.toEntity(dto));
    }

    @Override
    @Transactional
    public void update(Long id, UserDto dto) {
        repository.save(mapper.update(mapper.toEntity(get(id)), mapper.toEntity(dto)));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
