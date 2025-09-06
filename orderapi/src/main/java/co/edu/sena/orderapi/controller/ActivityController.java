/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.orderapi.controller;

import co.edu.sena.orderapi.model.Activity;
import co.edu.sena.orderapi.model.OrdersActivity;
import co.edu.sena.orderapi.service.IActivityService;
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
@RequestMapping("/activity")
public class ActivityController {
    @Autowired
    private IActivityService activityService;
    
    @GetMapping
    public ResponseEntity<List<Activity>> findAll() throws Exception
    {
        return new ResponseEntity<>(activityService.findAll(), HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Activity> findById(@PathVariable("id") Long id) throws Exception
    {
        return new ResponseEntity<>(activityService.findById(id), HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<Object> insert(@RequestBody Activity activity) throws Exception
    {
        activityService.insert(activity);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    
    @PutMapping
    public ResponseEntity<Object> update(@RequestBody Activity activity) throws Exception
    {
        activityService.update(activity);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") Long id) throws Exception
    {
        activityService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @GetMapping("/orders/{id}")
    public ResponseEntity<List<OrdersActivity>> findByOrdersId(@PathVariable("id") Long id) throws Exception
    {
        return new ResponseEntity<>(activityService.findByOrdersId(id), HttpStatus.OK);
    }
}
