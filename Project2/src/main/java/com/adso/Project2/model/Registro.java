package com.adso.Project2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

//Representa los datos y la lógica del dominio.

@Entity //Para decirle al programa que la clase es una tabla de la base de datos
@Data // Para crear getter y setter de cada propiedad
public class Registro {
    @Id //Marca un campo como la clave primaria de la entidad
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Configura la estrategia de generación automática de valores para la clave primaria. en este caso Incrementable
    private Long id;
    private String nombre;
    private String apellido;
    private String correo;
    private String password;
    private String descripcion;
}