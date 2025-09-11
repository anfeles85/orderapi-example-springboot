/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.sena.orderapi.service;

import co.edu.sena.orderapi.model.Orders;
import co.edu.sena.orderapi.model.OrdersActivity;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author sena
 */
@Service
public interface IOrdersService {
    void insert(Orders orders) throws Exception;
    void update(Orders orders) throws Exception;
    void delete(Long id) throws Exception;
    Orders findById(Long id) throws Exception;
    List<Orders> findAll() throws Exception;
    public List<OrdersActivity> findByActivityId(long activityId) throws Exception;
}
