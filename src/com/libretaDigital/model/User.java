package com.libretaDigital.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonAutoDetect;
 
@Entity
@Table(name="usuario")
@JsonAutoDetect
public class User {
	
	@Id
    @Column(name="id")
    @GeneratedValue
    private Integer id;
 
    @Column(name="nombre")
    private String nombre;
 
    @Column(name="clave")
    private String clave;
 
    public Integer getId() {
        return id;
    }
 
    public void setId(Integer id) {
        this.id = id;
    }
 
    public String getNombre() {
        return nombre;
    }
 
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
 
    public String getClave() {
        return clave;
    }
 
    public void setClave(String clave) {
        this.clave = clave;
    }
 
    public String toString(){
 
        return "Usuario: "+this.nombre;
    }
}
