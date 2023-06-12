
package com.portfolio.EPF.Service;

import com.portfolio.EPF.Entity.Hard;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.portfolio.EPF.Repository.RHard;

@Transactional
@Service
public class HardS {
    @Autowired
    RHard rhard;
    
    public List<Hard> list(){
        return rhard.findAll();
    }
    
    public Optional<Hard> getOne(int id){
        return rhard.findById(id);
    }
    
    public Optional<Hard> getByNombre(String nombre){
        return rhard.findByNombre(nombre);
    }
    
    public void save(Hard skill){
        rhard.save(skill);
    }
    
    public void delete(int id){
        rhard.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rhard.existsById(id);
    }
    
    public boolean existsByNombre(String nombre){
        return rhard.existsByNombre(nombre);
    }
}