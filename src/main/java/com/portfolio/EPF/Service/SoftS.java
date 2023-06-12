package com.portfolio.EPF.Service;

import com.portfolio.EPF.Entity.Soft;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.portfolio.EPF.Repository.RSoft;

@Transactional
@Service
public class SoftS {
    @Autowired
    RSoft rsoft;
    
    public List<Soft> list(){
        return rsoft.findAll();
    }
    
    public Optional<Soft> getOne(int id){
        return rsoft.findById(id);
    }
    
    public Optional<Soft> getByNombre(String nombre){
        return rsoft.findByNombre(nombre);
    }
    
    public void save(Soft sskill){
        rsoft.save(sskill);
    }
    
    public void delete(int id){
        rsoft.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rsoft.existsById(id);
    }
    
    public boolean existsByNombre(String nombre){
        return rsoft.existsByNombre(nombre);
    }
}