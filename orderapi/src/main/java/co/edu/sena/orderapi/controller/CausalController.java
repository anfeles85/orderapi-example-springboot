/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.orderapi.controller;

import co.edu.sena.orderapi.model.Causal;
import co.edu.sena.orderapi.service.ICausalService;
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
@RequestMapping("/causal")
public class CausalController {
    @Autowired
    private ICausalService causalService;
    
    @GetMapping
    public ResponseEntity<List<Causal>> findAll() throws Exception
    {
        return new ResponseEntity<>(causalService.findAll(), HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Causal> findById(@PathVariable("id") Long id) throws Exception
    {
        return new ResponseEntity<>(causalService.findById(id), HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<Object> insert(@RequestBody Causal causal) throws Exception
    {
        causalService.insert(causal);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    
    @PutMapping
    public ResponseEntity<Object> update(@RequestBody Causal causal) throws Exception
    {
        causalService.update(causal);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") Long id) throws Exception
    {
        causalService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
