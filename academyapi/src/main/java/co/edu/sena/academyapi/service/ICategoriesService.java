/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.sena.academyapi.service;

import co.edu.sena.academyapi.model.Categories;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author sena
 */
@Service
public interface ICategoriesService {
    void insert(Categories categories) throws Exception;
    void update(Categories categories) throws Exception;
    void delete(Integer id) throws Exception;
    Categories findById(Integer id) throws Exception;
    List<Categories> findAll() throws Exception;
}
