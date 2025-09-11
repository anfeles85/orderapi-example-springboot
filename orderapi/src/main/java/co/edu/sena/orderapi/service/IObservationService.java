/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.sena.orderapi.service;

import co.edu.sena.orderapi.model.Observation;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author sena
 */
@Service
public interface IObservationService {
    void insert(Observation observation) throws Exception;
    void update(Observation observation) throws Exception;
    void delete(Long id) throws Exception;
    Observation findById(Long id) throws Exception;
    List<Observation> findAll() throws Exception;
}
