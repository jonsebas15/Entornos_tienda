package uis.edu.entorno.tienda.modelo;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = Producto.TABLE_NAME)
public class Producto {
    public static final String TABLE_NAME = "producto";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idProveedor")
    private Proveedor idProveedor;

    @Column
    private double ivaCompra;

    @NotNull(message = "El producto debe tener un nombre")
    @NotBlank(message = "Es obligatorio el nombre")
    @Column
    private String nombre;


    @NotNull(message = "debe haber un precio de compra")
    @NotBlank(message = "Es obligatorio el precio e compra")
    @Column
    private double precioCompra;

    @NotNull(message = "Debe de haber un precio de venta")
    @NotBlank(message = "Es obligatorio el precio de venta")
    @Column
    private double precioVenta;

    public Producto() {
    }

    public Producto(Long id, Proveedor idProveedor, double ivaCompra, String nombre, double precioCompra,
            double precioVenta) {
        this.id = id;
        this.idProveedor = idProveedor;
        this.ivaCompra = ivaCompra;
        this.nombre = nombre;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
    }

    public static String getTableName() {
        return TABLE_NAME;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Proveedor getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Proveedor idProveedor) {
        this.idProveedor = idProveedor;
    }

    public double getIvaCompra() {
        return ivaCompra;
    }

    public void setIvaCompra(double ivaCompra) {
        this.ivaCompra = ivaCompra;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }
}
