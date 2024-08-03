package com.example.productservice.controllers;

import com.example.productservice.exception.ProductNotFoundException;
import com.example.productservice.model.Product;
import com.example.productservice.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Controlador REST para manejar las solicitudes relacionadas con los productos.
 */
@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductRepository productRepository;

	/**
	 * Obtiene todos los productos.
	 * 
	 * @return Lista de productos.
	 */
	@GetMapping
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	/**
	 * Obtiene un producto por su ID.
	 * 
	 * @param id ID del producto.
	 * @return Producto con el ID especificado o un error 404 si no existe.
	 */
	@GetMapping("/{id}")
	public Product getProductById(@PathVariable Long id) {
		return productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
	}

	/**
	 * Crea un nuevo producto.
	 * 
	 * @param product Objeto de producto a crear.
	 * @return Producto creado con el estado HTTP 201.
	 */
	@PostMapping
	public Product createProduct(@RequestBody Product product) {
		return productRepository.save(product);
	}

	/**
	 * Actualiza un producto existente.
	 * 
	 * @param id      ID del producto a actualizar.
	 * @param product Objeto de producto con los nuevos datos.
	 * @return Producto actualizado con el estado HTTP 200 o un error 404 si no
	 *         existe.
	 */
	@PutMapping("/{id}")
	public Product updateProduct(@PathVariable Long id, @RequestBody Product productDetails) {
		Product product = productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
		product.setName(productDetails.getName());
		product.setPrice(productDetails.getPrice());
		product.setQuantity(productDetails.getQuantity());
		return productRepository.save(product);
	}

	/**
	 * Elimina un producto por su ID.
	 * 
	 * @param id ID del producto a eliminar.
	 * @return Estado HTTP 204 si la eliminación fue exitosa.
	 */
	@DeleteMapping("/{id}")
	public String deleteProduct(@PathVariable Long id) {
		Product product = productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
		productRepository.delete(product);
		return "Product " + id + " deleted successfully!";
	}
}