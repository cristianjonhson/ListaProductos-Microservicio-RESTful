package cl.edu.lite.thinking.products.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import cl.edu.lite.thinking.products.model.Product;
import cl.edu.lite.thinking.products.service.ProductService;

import java.util.List;
import java.util.Optional;

/**
 * Controlador REST para manejar las solicitudes relacionadas con los productos.
 */
@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    /**
     * Obtiene todos los productos.
     * @return Lista de productos.
     */
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    /**
     * Obtiene un producto por su ID.
     * @param id ID del producto.
     * @return Producto con el ID especificado o un error 404 si no existe.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Optional<Product> product = productService.getProductById(id);
        return product.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Crea un nuevo producto.
     * @param product Objeto de producto a crear.
     * @return Producto creado con el estado HTTP 201.
     */
    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product createdProduct = productService.createProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProduct);
    }

    /**
     * Actualiza un producto existente.
     * @param id ID del producto a actualizar.
     * @param product Objeto de producto con los nuevos datos.
     * @return Producto actualizado con el estado HTTP 200 o un error 404 si no existe.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) {
        Product updatedProduct = productService.updateProduct(id, product);
        return updatedProduct != null ? ResponseEntity.ok(updatedProduct) : ResponseEntity.notFound().build();
    }

    /**
     * Elimina un producto por su ID.
     * @param id ID del producto a eliminar.
     * @return Estado HTTP 204 si la eliminación fue exitosa.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}