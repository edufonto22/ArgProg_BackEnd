
package com.portfolio.EPF.Repository;

import com.portfolio.EPF.Entity.Soft;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Usuario
 */
public interface RSoft extends JpaRepository<Soft, Integer>{
    Optional<Soft> findByNombre(String nombre);
    public boolean existsByNombre(String nombre);
}