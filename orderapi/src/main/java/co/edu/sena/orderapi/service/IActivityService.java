/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.sena.orderapi.service;

import co.edu.sena.orderapi.model.Activity;
import co.edu.sena.orderapi.model.OrdersActivity;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author sena
 */
@Service
public interface IActivityService {
    void insert(Activity activity) throws Exception;
    void update(Activity activity) throws Exception;
    void delete(Long id) throws Exception;
    Activity findById(Long id) throws Exception;
    List<Activity> findAll() throws Exception;
    List<OrdersActivity> findByOrdersId(long ordersId) throws Exception;    
}
