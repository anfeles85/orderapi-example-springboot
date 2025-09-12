/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.sena.academyapi.service;

import co.edu.sena.academyapi.model.Users;
import org.springframework.stereotype.Service;

/**
 *
 * @author sena
 */
@Service
public interface IUsersService {
    Users findById(Integer id) throws Exception;
    Users login(String email, String password) throws Exception;
}
