/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.academyapi.service;

import co.edu.sena.academyapi.exception.BadRequestException;
import co.edu.sena.academyapi.exception.ModelNotFoundException;
import co.edu.sena.academyapi.model.Categories;
import co.edu.sena.academyapi.repository.CategoriesRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author sena
 */
@Service
public class CategoriesService implements ICategoriesService {
    @Autowired
    private CategoriesRepository categoriesRepository;
    
    public void validate(Categories categories, boolean update) throws Exception
    {
        if(categories == null)
        {
            throw new BadRequestException("La categoría está vacía");
        }
        
        if(update && categories.getId() == null)
        {
            throw new BadRequestException("El id es obligatorio");
        }
        
        if(categories.getName() == null || "".equals(categories.getName() ))
        {
            throw new BadRequestException("El nombre es obligatorio");
        }      
        
    }
    
    
    @Override
    public void insert(Categories categories) throws Exception {
        validate(categories, false);
        categoriesRepository.save(categories);
    }

    @Override
    public void update(Categories categories) throws Exception {
        validate(categories, true);
        Optional<Categories> oldCategories = categoriesRepository.findById(categories.getId());
        if(!oldCategories.isPresent())
        {
            throw new ModelNotFoundException("No existe la categoría");
        }
        categoriesRepository.save(categories);
    }

    @Override
    public void delete(Integer id) throws Exception {
        if(id == 0)
        {
            throw new Exception("El id es obligatorio");
        }
        
        Optional<Categories> oldCategories = categoriesRepository.findById(id);
        if(!oldCategories.isPresent())
        {
            throw new ModelNotFoundException("No existe la categoría");
        }
        categoriesRepository.deleteById(id);
    }

    @Override
    public Categories findById(Integer id) throws Exception {
        if(id == 0)
        {
            throw new BadRequestException("El id es obligatorio");
        }
        
        return categoriesRepository.findById(id).orElse(null);
    }

    @Override
    public List<Categories> findAll() throws Exception {
        return categoriesRepository.findAll();
    }
    
}
