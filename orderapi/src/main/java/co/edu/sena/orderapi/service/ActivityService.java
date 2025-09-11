/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.orderapi.service;

import co.edu.sena.orderapi.exception.BadRequestException;
import co.edu.sena.orderapi.exception.ModelNotFoundException;
import co.edu.sena.orderapi.model.Activity;
import co.edu.sena.orderapi.model.OrdersActivity;
import co.edu.sena.orderapi.repository.ActivityRepository;
import co.edu.sena.orderapi.repository.OrdersActivityRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author sena
 */
@Service
public class ActivityService implements IActivityService{
    @Autowired
    private ActivityRepository activityRepository;
    @Autowired
    private OrdersActivityRepository ordersActivityRepository;

    /**
     * valida los datos del modelo.Si update es true entonces validará el id(autoinc)
     * @param activity
     * @param update
     * @throws Exception 
     */
    public void validate(Activity activity, boolean update) throws Exception
    {
        if(activity == null)
        {
            throw new BadRequestException("La actividad está vacía");
        }

        if(update && activity.getId() == null)        
        {
            throw new BadRequestException("El Id es obligatorio");
        }
        
        if(activity.getDescription().isEmpty())
        {
            throw new BadRequestException("La desccripción es obligatoria");
        }

        if(activity.getHours() <= 0)        
        {
            throw new BadRequestException("Las horas son obligatorias");
        }             
        
        if(activity.getTechnicianId() == null)
        {
            throw new BadRequestException("El técnico es obligatorio");
        }  
        
        if(activity.getTypeId() == null)
        {
            throw new BadRequestException("El tipo de actividad es obligatorio");
        }
    }
    
    @Override
    public void insert(Activity activity) throws Exception {
        validate(activity, false);        
        activityRepository.save(activity);
    }

    @Override
    public void update(Activity activity) throws Exception {
        validate(activity, true);   
        Optional<Activity> oldActivity = activityRepository.findById(activity.getId());
        if(!oldActivity.isPresent())
        {
            throw new ModelNotFoundException("No existe la actividad");
        }
        activityRepository.save(activity);
    }

    @Override
    public void delete(Long id) throws Exception {
        if(id == 0)
        {
            throw new Exception("El id es obligatorio");
        }
        
        Optional<Activity> oldActivity = activityRepository.findById(id);
        if(!oldActivity.isPresent())
        {
            throw new ModelNotFoundException("No existe la actividad");
        }
        activityRepository.deleteById(id);
    }

    @Override
    public Activity findById(Long id) throws Exception {
        if(id == 0)
        {
            throw new ModelNotFoundException("El id es obligatorio");
        }
        
        return activityRepository.findById(id).orElse(null);
    }

    @Override
    public List<Activity> findAll() throws Exception {
        return activityRepository.findAll();
    }

    @Override
    public List<OrdersActivity> findByOrdersId(long ordersId) throws Exception {
        if(ordersId == 0)
        {
            throw new ModelNotFoundException("El id de la orden es obligatorio");
        }
        
        return ordersActivityRepository.findByOrdersId(ordersId);
    }
    
    
}
