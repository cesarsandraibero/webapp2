package com.app.web.prueba.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
public class Usuario implements Serializable {

    private static final long serialVersionUID = 5L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;

    @Column
    private String nombre;

    @Column
    private String apellido;

    @Column
    private String correo;

    @Column
    private String usuario;

    @Column
    private String contraseña;

    @Transient //no es utilizada por la super clase o clase embebida
    private String confirmarContraseña;

    //con set no se repiten valores, como puede pasar en una list
    @ManyToMany(fetch = FetchType.LAZY)
    //estructura para crear la tabla n a n entre usuario y roles
    @JoinTable(name = "usuario_roles",
                joinColumns = @JoinColumn(name = "usuario_id"),
                inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    public Usuario() {
        super();
    }

    public Usuario(Long id) {
        super();
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getConfirmarContraseña() {
        return confirmarContraseña;
    }

    public void setConfirmarContraseña(String confirmarContraseña) {
        this.confirmarContraseña = confirmarContraseña;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Usuario)) return false;
        Usuario usuario1 = (Usuario) o;
        return id.equals(usuario1.id) &&
                nombre.equals(usuario1.nombre) &&
                apellido.equals(usuario1.apellido) &&
                correo.equals(usuario1.correo) &&
                usuario.equals(usuario1.usuario) &&
                contraseña.equals(usuario1.contraseña) &&
                confirmarContraseña.equals(usuario1.confirmarContraseña) &&
                roles.equals(usuario1.roles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, apellido, correo, usuario, contraseña, confirmarContraseña, roles);
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", correo='" + correo + '\'' +
                ", usuario='" + usuario + '\'' +
                ", contraseña='" + contraseña + '\'' +
                ", confirmarContraseña='" + confirmarContraseña + '\'' +
                ", roles=" + roles +
                '}';
    }
}
