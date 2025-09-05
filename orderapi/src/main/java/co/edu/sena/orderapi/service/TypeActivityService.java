/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.orderapi.service;

import co.edu.sena.orderapi.exception.BadRequestException;
import co.edu.sena.orderapi.exception.ModelNotFoundException;
import co.edu.sena.orderapi.model.TypeActivity;
import co.edu.sena.orderapi.repository.TypeActivityRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author sena
 */
@Service
public class TypeActivityService implements ITypeActivityService {
    @Autowired
    private TypeActivityRepository typeActivityRepository;
    
    /**
     * valida los datos del tipo de actividad.Si update es true entonces validará el id(autoinc)
     * @param typeActivity
     * @param update
     * @throws Exception 
     */
    public void validate(TypeActivity typeActivity, boolean update) throws Exception
    {
        if(typeActivity == null)
        {
            throw new BadRequestException("El tipo de actividad está vacía");
        }

        if(update && typeActivity.getId() == null)  
        {
            throw new BadRequestException("El Id es obligatorio");
        }

        if(typeActivity.getDescription().isEmpty())
        {
            throw new BadRequestException("La descripción es obligatoria");
        }
    }
    
    @Override
    public void insert(TypeActivity typeActivity) throws Exception {
        validate(typeActivity, false);        
        typeActivityRepository.save(typeActivity);
    }

    @Override
    public void update(TypeActivity typeActivity) throws Exception {
        validate(typeActivity, true);   
        Optional<TypeActivity> oldTypeActivity = typeActivityRepository.findById(typeActivity.getId());
        if(!oldTypeActivity.isPresent())
        {
            throw new ModelNotFoundException("No existe el tipo de actividad");
        }
        typeActivityRepository.save(typeActivity);
    }

    @Override
    public void delete(Long id) throws Exception {
        if(id == 0)
        {
            throw new Exception("El id es obligatorio");
        }
        
        Optional<TypeActivity> oldTypeActivity = typeActivityRepository.findById(id);
        if(!oldTypeActivity.isPresent())
        {
            throw new ModelNotFoundException("No existe el tipo de actividad");
        }
        typeActivityRepository.deleteById(id);
    }

    @Override
    public TypeActivity findById(Long id) throws Exception {
        if(id == 0)
        {
            throw new ModelNotFoundException("El id es obligatorio");
        }
        
        return typeActivityRepository.findById(id).orElse(null);
    }

    @Override
    public List<TypeActivity> findAll() throws Exception {
        return typeActivityRepository.findAll();
    }
    
}
