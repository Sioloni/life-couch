package ru.project.life.couch.mapper;

import org.springframework.stereotype.Component;
import ru.project.life.couch.dto.ProductDto;
import ru.project.life.couch.model.Product;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductMapper {

    public Product toEntity(ProductDto dto) {
        return new Product
                (
                        dto.getId(),
                        dto.getTitle(),
                        dto.getDescribe(),
                        dto.getPrice()
                );
    }

    public ProductDto toDto(Product entity) {
        return new ProductDto
                (
                        entity.getId(),
                        entity.getTitle(),
                        entity.getDescription(),
                        entity.getPrice()
                );
    }

    public List<Product> toEntity(List<ProductDto> dto) {
        return dto.stream().map(this::toEntity).collect(Collectors.toList());
    }

    public List<ProductDto> toDto(List<Product> entity) {
        return entity.stream().map(this::toDto).collect(Collectors.toList());
    }

    public Product update(Product entity, Product updateEntity) {
        if (updateEntity.getTitle() != null && !updateEntity.getTitle().isEmpty()) {
            entity.setTitle(updateEntity.getTitle());
        }
        if (updateEntity.getDescription() != null && !updateEntity.getDescription().isEmpty()) {
            entity.setDescription(updateEntity.getDescription());
        }
        if (updateEntity.getPrice() != null && !updateEntity.getPrice().toString().isEmpty()) {
            entity.setPrice(updateEntity.getPrice());
        }
        return entity;
    }
}
