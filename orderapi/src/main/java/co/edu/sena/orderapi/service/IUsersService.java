/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.sena.orderapi.service;

import co.edu.sena.orderapi.model.Users;
import org.springframework.stereotype.Service;

/**
 *
 * @author sena
 */
@Service
public interface IUsersService {
    Users login(Users user) throws Exception;
}
