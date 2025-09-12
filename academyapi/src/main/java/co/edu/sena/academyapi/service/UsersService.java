/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.academyapi.service;

import co.edu.sena.academyapi.exception.BadRequestException;
import co.edu.sena.academyapi.model.Users;
import co.edu.sena.academyapi.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author sena
 */
@Service
public class UsersService implements IUsersService{
    @Autowired
    private UsersRepository usersRepository;

    @Override
    public Users findById(Integer id) throws Exception {
        if(id == 0)
        {
            throw new BadRequestException("El id es obligatorio");                   
        }
        
        return usersRepository.findById(id).orElse(null);
    }

    @Override
    public Users login(String email, String password) throws Exception {
        if("".equals(email) || "".equals(password))
        {
            throw new BadRequestException("Las credenciales de usuario son obligatorias");     
        }
        
        return usersRepository.login(email, password);
    }
    
    
}
