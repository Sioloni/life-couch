package ru.project.life.couch.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.project.life.couch.dto.UserDto;
import ru.project.life.couch.model.User;
import ru.project.life.couch.repository.ProductRepository;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class UserMapper {
    private final ProductRepository repository;


    public User toEntity(UserDto dto) {
        return new User
                (
                        dto.getId(),
                        dto.getName(),
                        dto.getPhoneNumber(),
                        dto.getEmail(),
                        dto.getDescribeService(),
                        repository.findByTitle(dto.getProductTitle())
                );
    }

    public UserDto toDto(User entity) {
        return new UserDto
                (
                        entity.getId(),
                        entity.getName(),
                        entity.getPhoneNumber(),
                        entity.getEmail(),
                        entity.getDescribeService(),
                        entity.getProducts().getTitle()
                );
    }

    public List<User> toEntity(List<UserDto> dto) {
        return dto.stream().map(this::toEntity).collect(Collectors.toList());
    }

    public List<UserDto> toDto(List<User> entity) {
        return entity.stream().map(this::toDto).collect(Collectors.toList());
    }

    public User update(User entity, User updateEntity) {
        if (updateEntity.getName() != null && !updateEntity.getName().isEmpty()) {
            entity.setName(updateEntity.getName());
        }
        if (updateEntity.getPhoneNumber() != null && !updateEntity.getPhoneNumber().isEmpty()) {
            entity.setPhoneNumber(updateEntity.getPhoneNumber());
        }
        if (updateEntity.getEmail() != null && !updateEntity.getEmail().isEmpty()) {
            entity.setEmail(updateEntity.getEmail());
        }
        if (updateEntity.getDescribeService() != null && !updateEntity.getDescribeService().isEmpty()) {
            entity.setDescribeService(updateEntity.getDescribeService());
        }
        if (updateEntity.getProducts() != null) {
            entity.setProducts(updateEntity.getProducts());
        }
        return entity;
    }
}
