package cl.edu.lite.thinking.products.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.edu.lite.thinking.products.model.Product;
import cl.edu.lite.thinking.products.repository.ProductRepository;

import java.util.List;
import java.util.Optional;


/**
 * Servicio para manejar la lógica de negocio relacionada con los productos.
 */
@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    /**
     * Obtiene todos los productos.
     * @return Lista de productos.
     */
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    /**
     * Obtiene un producto por su ID.
     * @param id ID del producto.
     * @return Producto con el ID especificado.
     */
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    /**
     * Crea un nuevo producto.
     * @param product Objeto de producto a crear.
     * @return Producto creado.
     */
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    /**
     * Actualiza un producto existente.
     * @param id ID del producto a actualizar.
     * @param product Objeto de producto con los nuevos datos.
     * @return Producto actualizado o null si el producto no existe.
     */
    public Product updateProduct(Long id, Product product) {
        if (productRepository.existsById(id)) {
            product.setId(id);
            return productRepository.save(product);
        } else {
            return null;
        }
    }

    /**
     * Elimina un producto por su ID.
     * @param id ID del producto a eliminar.
     */
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}