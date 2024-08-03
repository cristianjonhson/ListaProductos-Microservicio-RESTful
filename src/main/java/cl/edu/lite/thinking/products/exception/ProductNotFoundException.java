package cl.edu.lite.thinking.products.exception;

/**
 * Excepción lanzada cuando un producto no es encontrado.
 */
public class ProductNotFoundException extends RuntimeException {

    /**
     * Construye una nueva ProductNotFoundException con el mensaje detallado especificado.
     *
     * @param message el mensaje detallado
     */
	public ProductNotFoundException(String message) {
        super(message);
    }
}
