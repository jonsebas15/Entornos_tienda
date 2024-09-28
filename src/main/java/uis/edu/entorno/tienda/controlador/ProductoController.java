package uis.edu.entorno.tienda.controlador;

import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import uis.edu.entorno.tienda.modelo.Producto;
import uis.edu.entorno.tienda.servicio.ProductoService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class ProductoController {

    @Autowired
    ProductoService productoService;

    @GetMapping("/productos")
    public List<Producto> cargaProductos() {
        return this.productoService.getProductos();
    }

    //buscar por id
    @GetMapping("/productos/{id}")
    public Producto buscarPorId(@PathVariable Long id){
        return productoService.buscarProducto(id);
    }
    //Agregar un producto
    @PostMapping("/productos")
    public ResponseEntity<Producto> agregar(@Valid @RequestBody Producto producto){
        Producto obj= productoService.nuevoProducto(producto);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    @PutMapping("/productos") //no deberia de tener un id para saber a quien modificar?
    public ResponseEntity<Producto> editar(@Valid @RequestBody Producto producto){
        Producto obj = productoService.buscarProducto(producto.getId());
        if(obj != null){
            obj.setIdProveedor(producto.getIdProveedor());
            obj.setNombre(producto.getNombre());
            obj.setIvaCompra(producto.getIvaCompra());
            obj.setPrecioVenta(producto.getPrecioVenta());
            obj.setPrecioCompra(producto.getPrecioCompra());
            productoService.nuevoProducto(obj);
        }else {
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    //ELiminar
    @DeleteMapping("/productos/{id}")
    public ResponseEntity<Producto> eliminar(@PathVariable Long id){
        Producto obj= productoService.buscarProducto(id);
        if(obj != null){
            productoService.borrarProducto(id);
        }else{
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
}
