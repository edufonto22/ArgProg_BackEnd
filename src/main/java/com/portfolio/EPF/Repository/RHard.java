
package com.portfolio.EPF.Repository;

import com.portfolio.EPF.Entity.Hard;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Usuario
 */
public interface RHard extends JpaRepository<Hard, Integer>{
    Optional<Hard> findByNombre(String nombre);
    public boolean existsByNombre(String nombre);
}