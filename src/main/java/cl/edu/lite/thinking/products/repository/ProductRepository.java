package cl.edu.lite.thinking.products.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import cl.edu.lite.thinking.products.model.Product;

/**
 * Repositorio para realizar operaciones CRUD sobre los productos.
 */
public interface ProductRepository extends JpaRepository<Product, Long> {
}

