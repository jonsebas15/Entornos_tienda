package uis.edu.entorno.tienda.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uis.edu.entorno.tienda.modelo.Proveedor;

@Repository
public interface ProveedorRepositorio extends JpaRepository<Proveedor,Long>{

}
