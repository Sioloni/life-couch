package ru.project.life.couch.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.project.life.couch.dto.ProductDto;
import ru.project.life.couch.mapper.ProductMapper;
import ru.project.life.couch.model.Product;
import ru.project.life.couch.repository.ProductRepository;
import ru.project.life.couch.service.ProductService;

import javax.transaction.Transactional;
import java.util.List;


@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository repository;
    private final ProductMapper mapper;


    @Override
    public List<ProductDto> get() {
        return mapper.toDto(repository.findAll());
    }

    @Override
    public ProductDto get(Long id) {
        return mapper.toDto(repository.findById(id).get());
    }

    @Override
    @Transactional
    public void create(ProductDto dto) {
        Product product = mapper.toEntity(dto);
        repository.save(product);
    }

    @Override
    public void update(Long id, ProductDto dto) {
        repository.save(mapper.update(mapper.toEntity(get(id)), mapper.toEntity(dto)));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Product findByTitle(String title) {
        if (repository.findByTitle(title).isPresent()) {
            return repository.findByTitle(title).get();
        } else {
            return null;
        }
    }

    @Override
    public String info(Product entity) {
        return entity == null ? null : entity.getTitle();
    }


}
