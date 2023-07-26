package ru.project.life.couch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.project.life.couch.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findByTitle(String title);
}
