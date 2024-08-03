package com.example.productservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Manejador global de excepciones para el microservicio de productos.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

	/**
	 * Maneja la excepción ProductNotFoundException.
	 * 
	 * @param ex Excepción lanzada cuando un producto no es encontrado.
	 * @return Respuesta con el estado HTTP 404 y un mensaje de error.
	 */
	@ExceptionHandler(ProductNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String handleProductNotFoundException(ProductNotFoundException ex) {
		return ex.getMessage();
	}
}
