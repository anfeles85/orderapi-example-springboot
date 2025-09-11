/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.orderapi.controller;

import co.edu.sena.orderapi.model.Activity;
import co.edu.sena.orderapi.model.Users;
import co.edu.sena.orderapi.service.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author sena
 */
@RestController
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private IUsersService usersService;
    
    @PostMapping
    public ResponseEntity<Object> login(@RequestBody Users user) throws Exception
    {
        Users loginUser = usersService.login(user);
        if(loginUser != null)
        {
            return new ResponseEntity<>(loginUser, HttpStatus.OK);
        }
        else            
        {
            return new ResponseEntity<>("Credenciales incorrectas",HttpStatus.UNAUTHORIZED);
        }
        
    }
}
