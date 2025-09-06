/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.orderapi.controller;

import co.edu.sena.orderapi.model.Orders;
import co.edu.sena.orderapi.model.OrdersActivity;
import co.edu.sena.orderapi.service.IOrdersService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author sena
 */
@RestController
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private IOrdersService ordersService;
    
    @GetMapping
    public ResponseEntity<List<Orders>> findAll() throws Exception
    {
        return new ResponseEntity<>(ordersService.findAll(), HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Orders> findById(@PathVariable("id") Long id) throws Exception
    {
        return new ResponseEntity<>(ordersService.findById(id), HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<Object> insert(@RequestBody Orders orders) throws Exception
    {
        ordersService.insert(orders);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    
    @PutMapping
    public ResponseEntity<Object> update(@RequestBody Orders orders) throws Exception
    {
        ordersService.update(orders);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") Long id) throws Exception
    {
        ordersService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @GetMapping("/activity/{id}")
    public ResponseEntity<List<OrdersActivity>> findByActivityId(@PathVariable("id") Long id) throws Exception
    {
        return new ResponseEntity<>(ordersService.findByActivityId(id), HttpStatus.OK);
    }
}
