/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.orderapi.controller;

import co.edu.sena.orderapi.model.TypeActivity;
import co.edu.sena.orderapi.service.ITypeActivityService;
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
@RequestMapping("/type_activity")
public class TypeActivityController {
    @Autowired
    private ITypeActivityService typeActivityService;
    
    @GetMapping
    public ResponseEntity<List<TypeActivity>> findAll() throws Exception
    {
        return new ResponseEntity<>(typeActivityService.findAll(), HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<TypeActivity> findById(@PathVariable("id") Long id) throws Exception
    {
        return new ResponseEntity<>(typeActivityService.findById(id), HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<Object> insert(@RequestBody TypeActivity typeActivity) throws Exception
    {
        typeActivityService.insert(typeActivity);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    
    @PutMapping
    public ResponseEntity<Object> update(@RequestBody TypeActivity typeActivity) throws Exception
    {
        typeActivityService.update(typeActivity);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") Long id) throws Exception
    {
        typeActivityService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
   
}
