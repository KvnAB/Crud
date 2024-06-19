package com.adso.Project2.repository;

import com.adso.Project2.model.Registro;
import org.springframework.data.jpa.repository.JpaRepository;

//Encapsula la lógica de acceso a datos.

//maneja base de daos

public interface RepositoryRegistro extends JpaRepository<Registro, Long> {
}
