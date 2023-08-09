package ru.project.life.couch.service;

import org.springframework.web.multipart.MultipartFile;
import ru.project.life.couch.dto.ProductDto;
import ru.project.life.couch.model.Product;

import java.util.List;

public interface ProductService {
    List<ProductDto> get();

    ProductDto get(Long id);

    void create(ProductDto dto);

    void update(Long id, ProductDto dto);

    void delete(Long id);

    Product findByTitle(String title);

    String info(Product entity);
}
