/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.orderapi.service;

import co.edu.sena.orderapi.exception.BadRequestException;
import co.edu.sena.orderapi.exception.ModelNotFoundException;
import co.edu.sena.orderapi.model.Observation;
import co.edu.sena.orderapi.repository.ObservationRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author sena
 */
@Service
public class ObservationService implements IObservationService {
    
    @Autowired
    private ObservationRepository observationRepository;

    /**
     * valida los datos de la observación. Si update es true entonces validará el id(autoinc)
     * @param observation
     * @param update
     * @throws Exception 
     */
    public void validate(Observation observation, boolean update) throws Exception
    {
        if(observation == null)
        {
            throw new BadRequestException("La observación está vacía");
        }

        if(update && observation.getId() == null)        
        {
            throw new BadRequestException("El Id es obligatorio");
        }

        if(observation.getDescription().isEmpty())
        {
            throw new BadRequestException("La descripción es obligatoria");
        }
    }
    
    
    @Override
    public void insert(Observation observation) throws Exception {
        validate(observation, false);        
        observationRepository.save(observation);
    }

    @Override
    public void update(Observation observation) throws Exception {
        validate(observation, true);   
        Optional<Observation> oldObservation = observationRepository.findById(observation.getId());
        if(!oldObservation.isPresent())
        {
            throw new ModelNotFoundException("No existe la observación");
        }
        observationRepository.save(observation);
    }

    @Override
    public void delete(Long id) throws Exception {
        if(id == 0)
        {
            throw new Exception("El id es obligatorio");
        }
        
        Optional<Observation> oldObservation = observationRepository.findById(id);
        if(!oldObservation.isPresent())
        {
            throw new ModelNotFoundException("No existe la observación");
        }
        observationRepository.deleteById(id);
    }

    @Override
    public Observation findById(Long id) throws Exception {
        if(id == 0)
        {
            throw new ModelNotFoundException("El id es obligatorio");
        }
        
        return observationRepository.findById(id).orElse(null);
    }

    @Override
    public List<Observation> findAll() throws Exception {
        return observationRepository.findAll();
    }
    
}
