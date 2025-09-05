/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.orderapi.service;

import co.edu.sena.orderapi.model.Causal;
import co.edu.sena.orderapi.repository.CausalRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author sena
 */
@Service
public class CausalService implements ICausalService{

    @Autowired
    private CausalRepository causalRepository;
    
    public void validate(Causal causal, boolean update) throws Exception
    {
        if(causal == null)
        {
            throw new Exception("La causal está vacía");
        }

        if(update && causal.getId() == 0)        
        {
            throw new Exception("El Id es obligatorio");
        }

        if(causal.getDescription().isEmpty())
        {
            throw new Exception("El nombre es obligatorio");
        }
    }
    
    @Override
    public void insert(Causal causal) throws Exception {
        validate(causal, false);        
        causalRepository.save(causal);
    }

    @Override
    public void update(Causal causal) throws Exception {
        validate(causal, true);   
        Optional<Causal> oldCausal = causalRepository.findById(causal.getId());
        if(!oldCausal.isPresent())
        {
            throw new Exception("No existe la causal");
        }
        causalRepository.save(causal);
    }

    @Override
    public void delete(Long id) throws Exception {
        if(id == 0)
        {
            throw new Exception("El id es obligatorio");
        }
        
        Optional<Causal> oldCausal = causalRepository.findById(id);
        if(!oldCausal.isPresent())
        {
            throw new Exception("No existe la causal");
        }
        causalRepository.deleteById(id);
    }

    @Override
    public Causal findById(Long id) throws Exception {
        if(id == 0)
        {
            throw new Exception("El id es obligatorio");
        }
        
        return causalRepository.findById(id).orElse(null);
    }

    @Override
    public List<Causal> findAll() throws Exception {
        return causalRepository.findAll();
    }
    
}
