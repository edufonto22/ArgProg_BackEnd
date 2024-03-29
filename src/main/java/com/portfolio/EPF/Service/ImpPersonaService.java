package com.portfolio.EPF.Service;

import com.portfolio.EPF.Entity.Persona;
import com.portfolio.EPF.Repository.IPersonaRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ImpPersonaService {

    @Autowired
    IPersonaRepository IpersonaRepository;

     public List<Persona> list(){
    
            return IpersonaRepository.findAll();
    }
    
    public Optional<Persona> getOne(int id) {
        return IpersonaRepository.findById(id);
    }
    
    public Optional<Persona> getByNombre(String nombre) {
        return IpersonaRepository.findByNombre(nombre);
    }
    
    public void save(Persona persona) {
        IpersonaRepository.save(persona);
    }
    
    public void delete(int id) {
        IpersonaRepository.deleteById(id);
    }
    
    public boolean existsById(int id) {
        return IpersonaRepository.existsById(id);
    }
    
    public boolean existsByNombre(String nombre) {
        return IpersonaRepository.existsByNombre(nombre);
    }
    
}


