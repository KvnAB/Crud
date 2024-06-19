package com.adso.Project2.service;

import com.adso.Project2.model.Registro;
import com.adso.Project2.repository.RepositoryRegistro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//Implementa la lógica de negocio y coordina las operaciones.

@Service //Para definir la clase actual como un servicio
public class ServiceRegistro {
    @Autowired
    private RepositoryRegistro repositoryRegister;

    public List<Registro> getAllRegistro(){
        return repositoryRegister.findAll();//se utiliza para recuperar todas las instancias de una entidad específica desde la base de datos
    } //obtiene los datos de el repositorio

    public Registro saveRegister(Registro registro){
        return repositoryRegister.save(registro);
    }

    public Registro getRegisterById(Long id) {
        return repositoryRegister.findById(id).orElse(null);
    }

    public void updateRegister(Registro registro) {
        repositoryRegister.save(registro);
    }

    public void deleteRegister(Long id) {
        repositoryRegister.deleteById(id);
    }
}
