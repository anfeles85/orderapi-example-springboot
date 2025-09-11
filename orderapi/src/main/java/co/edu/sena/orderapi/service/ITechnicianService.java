/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.sena.orderapi.service;

import co.edu.sena.orderapi.model.Technician;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author sena
 */
@Service
public interface ITechnicianService {
    void insert(Technician technician) throws Exception;
    void update(Technician technician) throws Exception;
    void delete(Long id) throws Exception;
    Technician findById(Long id) throws Exception;
    List<Technician> findAll() throws Exception;
}
