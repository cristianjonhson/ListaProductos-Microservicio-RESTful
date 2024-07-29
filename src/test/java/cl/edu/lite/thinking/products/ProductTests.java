package cl.edu.lite.thinking.products;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import cl.edu.lite.thinking.products.model.Product;
import cl.edu.lite.thinking.products.repository.ProductRepository;
import cl.edu.lite.thinking.products.service.ProductService;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

/**
 * Pruebas unitarias para el servicio de productos.
 */
@SpringBootTest
public class ProductTests {

    @Autowired
    private ProductService productService;

    @MockBean
    private ProductRepository productRepository;

    @Test
    public void testGetProductById() {
        Product product = new Product();
        product.setId(1L);
        product.setName("Test Product");
        product.setDescription("Test Description");
        product.setPrice(100.0);

        when(productRepository.findById(1L)).thenReturn(Optional.of(product));

        Optional<Product> foundProduct = productService.getProductById(1L);
        assertThat(foundProduct.isPresent()).isTrue();
        assertThat(foundProduct.get().getName()).isEqualTo("Test Product");
    }

    @Test
    public void testCreateProduct() {
        Product product = new Product();
        product.setName("New Product");
        product.setDescription("New Description");
        product.setPrice(200.0);

        when(productRepository.save(any(Product.class))).thenReturn(product);

        Product createdProduct = productService.createProduct(product);
        assertThat(createdProduct.getName()).isEqualTo("New Product");
    }
}