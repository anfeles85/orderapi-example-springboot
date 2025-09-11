/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.sena.orderapi.repository;

import co.edu.sena.orderapi.model.Technician;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author sena
 */
@Repository
public interface TechnicianRepository extends JpaRepository<Technician, Long> {
    @Query("Select t from Technician t where t.document = :document")
    Optional<Technician> findByDocument(@Param("document") long document);
}
