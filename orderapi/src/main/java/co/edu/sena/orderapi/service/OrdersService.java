/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.orderapi.service;

import co.edu.sena.orderapi.exception.BadRequestException;
import co.edu.sena.orderapi.exception.ModelNotFoundException;
import co.edu.sena.orderapi.model.Activity;
import co.edu.sena.orderapi.model.Orders;
import co.edu.sena.orderapi.model.OrdersActivity;
import co.edu.sena.orderapi.repository.OrdersActivityRepository;
import co.edu.sena.orderapi.repository.OrdersRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author sena
 */
@Service
public class OrdersService implements IOrdersService {
    @Autowired
    private OrdersRepository ordersRepository;
    @Autowired
    private OrdersActivityRepository ordersActivityRepository;
    
    /**
     * valida los datos del modelo.Si update es true entonces validará el id(autoinc)
     * @param orders
     * @param update
     * @throws Exception 
     */
    public void validate(Orders orders, boolean update) throws Exception
    {
        if(orders == null)
        {
            throw new BadRequestException("La orden está vacía");
        }

        if(update && orders.getId() == null)        
        {
            throw new BadRequestException("El Id es obligatorio");
        }
        
        if(orders.getLegalizationDate() == null)
        {
            throw new BadRequestException("La fecha de legalización es obligatoria");
        }

        if(orders.getAddress().isEmpty())        
        {
            throw new BadRequestException("La dirección es obligatoria");
        } 
        
        if(orders.getCity().isEmpty())        
        {
            throw new BadRequestException("La ciudad es obligatoria");
        } 
        
        if(orders.getCausalId() == null)
        {
            throw new BadRequestException("La causal es obligatoria");
        }          
        
    }
    
    
    @Override
    public void insert(Orders orders) throws Exception {
        validate(orders, false);        
        ordersRepository.save(orders);
    }

    @Override
    public void update(Orders orders) throws Exception {
        validate(orders, true);   
        Optional<Orders> oldOrders = ordersRepository.findById(orders.getId());
        if(!oldOrders.isPresent())
        {
            throw new ModelNotFoundException("No existe la orden");
        }
        ordersRepository.save(orders);
    }

    @Override
    public void delete(Long id) throws Exception {
        if(id == 0)
        {
            throw new Exception("El id es obligatorio");
        }
        
        Optional<Orders> oldOrders = ordersRepository.findById(id);
        if(!oldOrders.isPresent())
        {
            throw new ModelNotFoundException("No existe la orden");
        }
        ordersRepository.deleteById(id);
    }

    @Override
    public Orders findById(Long id) throws Exception {
        if(id == 0)
        {
            throw new ModelNotFoundException("El id es obligatorio");
        }
        
        return ordersRepository.findById(id).orElse(null);
    }

    @Override
    public List<Orders> findAll() throws Exception {
        return ordersRepository.findAll();
    }

    @Override
    public List<OrdersActivity> findByActivityId(long activityId) throws Exception {
        if(activityId == 0)
        {
            throw new Exception("El id es obligatorio");
        }
        
        return ordersActivityRepository.findByActivityId(activityId);
    }
    
    
}
