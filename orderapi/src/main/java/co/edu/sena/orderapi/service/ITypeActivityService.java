/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.sena.orderapi.service;

import co.edu.sena.orderapi.model.TypeActivity;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author sena
 */
@Service
public interface ITypeActivityService {
    void insert(TypeActivity typeActivity) throws Exception;
    void update(TypeActivity typeActivity) throws Exception;
    void delete(Long id) throws Exception;
    TypeActivity findById(Long id) throws Exception;
    List<TypeActivity> findAll() throws Exception;
}
