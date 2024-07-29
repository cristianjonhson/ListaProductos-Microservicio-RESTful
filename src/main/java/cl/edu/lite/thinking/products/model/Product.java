package cl.edu.lite.thinking.products.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Representa un producto en el sistema.
 */
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private double price;

    /**
     * Obtiene el ID del producto.
     * @return ID del producto.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el ID del producto.
     * @param id ID del producto.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del producto.
     * @return Nombre del producto.
     */
    public String getName() {
        return name;
    }

    /**
     * Establece el nombre del producto.
     * @param name Nombre del producto.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Obtiene la descripción del producto.
     * @return Descripción del producto.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Establece la descripción del producto.
     * @param description Descripción del producto.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Obtiene el precio del producto.
     * @return Precio del producto.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Establece el precio del producto.
     * @param price Precio del producto.
     */
    public void setPrice(double price) {
        this.price = price;
    }
}