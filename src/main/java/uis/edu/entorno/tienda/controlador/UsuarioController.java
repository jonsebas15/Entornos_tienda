package uis.edu.entorno.tienda.controlador;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import uis.edu.entorno.tienda.modelo.Usuario;
import uis.edu.entorno.tienda.servicio.UsuarioService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;





@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class UsuarioController {
    @GetMapping("/")
    public String home() {
        return "Welcome to the home page!";
    }
    
    @Autowired
    UsuarioService usuarioService; /* prodria ir en privado? */

    @GetMapping("/list")
    public ArrayList<Usuario> cargarUsuarios() {
        return this.usuarioService.getUsuarios();
    }

    //buscar por id
    @GetMapping("/list/{id}")
    public Usuario buscarPorId(@PathVariable Long id){
        return usuarioService.buscarUsuario(id);
    }
    //Agregar un usuario
    @PostMapping("/")
    public ResponseEntity<Usuario> agregar(@RequestBody Usuario usuario){
        Usuario obj= usuarioService.nuevoUsuario(usuario);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    @PutMapping("/") //no deberia de tener un id para saber a quien modificar?
    public ResponseEntity<Usuario> editar(@RequestBody Usuario usuario){
        Usuario obj = usuarioService.buscarUsuario(usuario.getId());
        if(obj != null){
            obj.setEmail(usuario.getEmail());
            obj.setIdTipodocumento(usuario.getIdTipodocumento());
            obj.setNombre(usuario.getNombre());
            obj.setNombreUsuario(usuario.getNombreUsuario());
            obj.setNumeroDocumento(usuario.getNumeroDocumento());
            obj.setPassword(usuario.getPassword());
            usuarioService.nuevoUsuario(obj);
        }else {
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    //ELiminar
    @DeleteMapping("/{id}")
    public ResponseEntity<Usuario> eliminar(@PathVariable Long id){
        Usuario obj= usuarioService.buscarUsuario(id);
        if(obj != null){
            usuarioService.borrarUsuario(id);
        }else{
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
}

