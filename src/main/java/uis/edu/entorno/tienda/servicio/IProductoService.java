package uis.edu.entorno.tienda.servicio;

import java.util.List;

import uis.edu.entorno.tienda.modelo.Producto;

public interface IProductoService {
    List<Producto> getProductos();
    Producto nuevoProducto(Producto producto);
    Producto buscarProducto(Long id);
    int borrarProducto(Long id);
}
