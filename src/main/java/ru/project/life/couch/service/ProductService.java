package ru.project.life.couch.service;

import ru.project.life.couch.dto.ProductDto;

import java.util.List;

public interface ProductService {
    List<ProductDto> get();

    ProductDto get(Long id);

    void create(ProductDto dto);

    void update(Long id, ProductDto dto);

    void delete(Long id);


}
