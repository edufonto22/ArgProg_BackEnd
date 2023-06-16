
package com.portfolio.EPF.Controller;


import com.portfolio.EPF.Dto.DtoSoft;
import com.portfolio.EPF.Entity.Soft;
import com.portfolio.EPF.Security.Controller.Mensaje;
import com.portfolio.EPF.Service.SoftS;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "https://frontendepf.web.app")
@RequestMapping("/sskill")
public class CSoft {

    @Autowired
    SoftS ssoft;

    @GetMapping("/lista")
    public ResponseEntity<List<Soft>> list() {
        List<Soft> list = ssoft.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Soft> getById(@PathVariable("id") int id) {
        if (!ssoft.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        Soft sSoft = ssoft.getOne(id).get();
        return new ResponseEntity(sSoft, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!ssoft.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        ssoft.delete(id);
        return new ResponseEntity(new Mensaje("Skill eliminado"), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoSoft dtosoft) {
        if (StringUtils.isBlank(dtosoft.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (ssoft.existsByNombre(dtosoft.getNombre())) {
            return new ResponseEntity(new Mensaje("Esa skill ya existe"), HttpStatus.BAD_REQUEST);
        }

        Soft sSoft = new Soft(dtosoft.getNombre(), dtosoft.getPorcentaje(), dtosoft.getImgSkill());
        ssoft.save(sSoft);

        return new ResponseEntity(new Mensaje("Skill agregada"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoSoft dtosoft) {
        //Validamos si existe el ID
        if (!ssoft.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        //Compara nombre de skills
        if (ssoft.existsByNombre(dtosoft.getNombre()) && ssoft.getByNombre(dtosoft.getNombre()).get()
                .getId() != id) {
            return new ResponseEntity(new Mensaje("Esa skill ya existe"), HttpStatus.BAD_REQUEST);
        }
        //No puede estar vacio
        if (StringUtils.isBlank(dtosoft.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Soft sSoft = ssoft.getOne(id).get();
        sSoft.setNombre(dtosoft.getNombre());
        sSoft.setPorcentaje(dtosoft.getPorcentaje());
        sSoft.setImgSkill(dtosoft.getImgSkill());

        ssoft.save(sSoft);
        return new ResponseEntity(new Mensaje("Skill actualizada"), HttpStatus.OK);

    }
}