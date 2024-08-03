package com.example.productservice.exception;

/**
 * Excepción lanzada cuando un producto no es encontrado.
 */
public class ProductNotFoundException extends RuntimeException {

	/**
	 * Construye una nueva ProductNotFoundException con el mensaje detallado
	 * especificado.
	 *
	 * @param message el mensaje detallado
	 */
	public ProductNotFoundException(Long id) {
		super("Product not found with id: " + id);
	}
}
