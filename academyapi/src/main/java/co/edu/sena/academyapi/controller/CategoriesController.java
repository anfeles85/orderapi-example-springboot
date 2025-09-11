/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.academyapi.controller;

import co.edu.sena.academyapi.model.Categories;
import co.edu.sena.academyapi.service.ICategoriesService;
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
@RequestMapping("/categories")
public class CategoriesController {
    @Autowired
    private ICategoriesService categoriesService;
    
    @GetMapping
    public ResponseEntity<List<Categories>> findAll() throws Exception
    {
        return new ResponseEntity<>(categoriesService.findAll(), HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Categories> findById(@PathVariable("id") Integer id) throws Exception
    {
        return new ResponseEntity<>(categoriesService.findById(id), HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<Object> insert(@RequestBody Categories categories) throws Exception
    {
        categoriesService.insert(categories);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    
    @PutMapping
    public ResponseEntity<Object> update(@RequestBody Categories categories) throws Exception
    {
        categoriesService.update(categories);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") Integer id) throws Exception
    {
        categoriesService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
