package uis.edu.entorno.tienda.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uis.edu.entorno.tienda.modelo.Producto;

@Repository
public interface ProductoRepositorio extends JpaRepository<Producto, Long>{

}
