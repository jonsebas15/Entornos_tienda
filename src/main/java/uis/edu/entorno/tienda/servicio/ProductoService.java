package uis.edu.entorno.tienda.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import uis.edu.entorno.tienda.modelo.Producto;
import uis.edu.entorno.tienda.repositorio.ProductoRepositorio;

@Service
@Transactional
public class ProductoService implements IProductoService{
    @Autowired
    ProductoRepositorio productoRepositorio;

    @Override
    public List<Producto> getProductos(){
        return(List<Producto>) productoRepositorio.findAll();
    }
    @Override
    public Producto nuevoProducto(Producto producto){
        return productoRepositorio.save(producto);
    }
    @Override
    public Producto buscarProducto(Long id){
        Producto producto = null;
        producto = productoRepositorio.findById(id).orElse(null);
        if(producto == null){
            return null;
        } return producto;
    }
    @Override
    public int borrarProducto(Long id){
        productoRepositorio.deleteById(id);
        return 1;
    }
}
