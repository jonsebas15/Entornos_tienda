package uis.edu.entorno.tienda.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = Usuario.TABLE_NAME)
public class Usuario {
    public static final String TABLE_NAME = "usuario";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idTipoDocumento")
    private Tipodocumento idTipodocumento;

    @Column(name = "numeroDocumento")
    private String numeroDocumento;

    @Column(name="nombre")
    private String nombre;

    @Column(name="password")
    private String password;

    @Column(name = "nombreUsuario")
    private String nombreUsuario;

    @Column(name="email")
    private String email;


    public Usuario() {
    }


    public Usuario(Long id, Tipodocumento idTipodocumento, String numeroDocumento, String nombre, String password,
            String nombreUsuario, String email) {
        this.id = id;
        this.idTipodocumento = idTipodocumento;
        this.numeroDocumento = numeroDocumento;
        this.nombre = nombre;
        this.password = password;
        this.nombreUsuario = nombreUsuario;
        this.email = email;
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


    public Tipodocumento getIdTipodocumento() {
        return idTipodocumento;
    }


    public void setIdTipodocumento(Tipodocumento idTipodocumento) {
        this.idTipodocumento = idTipodocumento;
    }


    public String getNumeroDocumento() {
        return numeroDocumento;
    }


    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }


    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }


    public String getNombreUsuario() {
        return nombreUsuario;
    }


    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }
}
