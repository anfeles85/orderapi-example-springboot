/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.academyapi.controller;

import co.edu.sena.academyapi.model.Users;
import co.edu.sena.academyapi.service.IUsersService;
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
    
    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody Users users) throws Exception
    {
        Users loginUser = usersService.login(users.getEmail(), users.getPassword());
        if(loginUser != null)
        {
            return new ResponseEntity<>(new GenericResponse("Autenticación exitosa", HttpStatus.OK.value()), HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(new GenericResponse("Credenciales incorrectas", HttpStatus.UNAUTHORIZED.value()), HttpStatus.UNAUTHORIZED);
        }        
    }
}
