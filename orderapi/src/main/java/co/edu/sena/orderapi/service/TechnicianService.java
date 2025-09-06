/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.orderapi.service;

import co.edu.sena.orderapi.exception.BadRequestException;
import co.edu.sena.orderapi.exception.ConflictException;
import co.edu.sena.orderapi.exception.ModelNotFoundException;
import co.edu.sena.orderapi.model.Technician;
import co.edu.sena.orderapi.repository.TechnicianRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author sena
 */
@Service
public class TechnicianService implements ITechnicianService {
    @Autowired
    private TechnicianRepository technicianRepository;
    
    /**
     * valida los datos del modelo.Si update es true entonces validará el id(autoinc)
     * @param technician
     * @param update
     * @throws Exception 
     */
    public void validate(Technician technician, boolean update) throws Exception
    {
        if(technician == null)
        {
            throw new BadRequestException("El técnico está vacío");
        }

        if(update && technician.getId() == null)        
        {
            throw new BadRequestException("El Id es obligatorio");
        }

        if(technician.getDocument() == 0)        
        {
            throw new BadRequestException("El documento es obligatorio");
        }
        //solo se valida que no exista ya el documento cuando se va a insertar
        if(!update)
        {
            Optional<Technician> oldTechnician = technicianRepository.findByDocument(technician.getDocument());
            if(oldTechnician.isPresent())
            {
                throw new ConflictException("Ya existe un técnico con el mismo documento");
            }
        }        
        
        if(technician.getName().isEmpty())
        {
            throw new BadRequestException("El nombre es obligatorio");
        }        
    }

    @Override
    public void insert(Technician technician) throws Exception {
        validate(technician, false);        
        technicianRepository.save(technician);
    }

    @Override
    public void update(Technician technician) throws Exception {
        validate(technician, true);   
        Optional<Technician> oldTechnician= technicianRepository.findById(technician.getId());
        if(!oldTechnician.isPresent())
        {
            throw new ModelNotFoundException("No existe el técnico");
        }
        technicianRepository.save(technician);
    }

    @Override
    public void delete(Long id) throws Exception {
        if(id == 0)
        {
            throw new Exception("El id es obligatorio");
        }
        
        Optional<Technician> oldTechnician= technicianRepository.findById(id);
        if(!oldTechnician.isPresent())
        {
            throw new ModelNotFoundException("No existe el técnico");
        }
        technicianRepository.deleteById(id);
    }

    @Override
    public Technician findById(Long id) throws Exception {
        if(id == 0)
        {
            throw new ModelNotFoundException("El id es obligatorio");
        }
        
        return technicianRepository.findById(id).orElse(null);
    }

    @Override
    public List<Technician> findAll() throws Exception {
        return technicianRepository.findAll();
    }
    
    
}
