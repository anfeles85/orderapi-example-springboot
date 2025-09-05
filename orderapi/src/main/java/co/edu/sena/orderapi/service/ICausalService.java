/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.sena.orderapi.service;

import co.edu.sena.orderapi.model.Causal;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author sena
 */
@Service
public interface ICausalService {
    void insert(Causal causal) throws Exception;
    void update(Causal causal) throws Exception;
    void delete(Long id) throws Exception;
    Causal findById(Long id) throws Exception;
    List<Causal> findAll() throws Exception;
}
