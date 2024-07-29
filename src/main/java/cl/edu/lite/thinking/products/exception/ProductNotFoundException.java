package cl.edu.lite.thinking.products.exception;

/**
 * Excepción lanzada cuando un producto no es encontrado.
 */
public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(String message) {
        super(message);
    }
}
