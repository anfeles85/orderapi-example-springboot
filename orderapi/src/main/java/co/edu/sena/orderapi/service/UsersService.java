/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.orderapi.service;

import co.edu.sena.orderapi.exception.BadRequestException;
import co.edu.sena.orderapi.exception.ModelNotFoundException;
import co.edu.sena.orderapi.model.Activity;
import co.edu.sena.orderapi.model.Users;
import co.edu.sena.orderapi.repository.UserRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author sena
 */
@Service
public class UsersService implements IUsersService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public Users login(Users user) throws Exception {
        if(user == null)
        {
            throw new BadRequestException("El usuario está vacío");
        }
        
        Optional<Users> oldUsers = userRepository.findByEmail(user.getEmail());
        if(!oldUsers.isPresent())
        {
            return null;
        }
        else if(oldUsers.get().getPassword().equals(user.getPassword()))
        {
            return oldUsers.get();
        }
        else
        {
            return null;
        }        
        
    }
    
    
}
