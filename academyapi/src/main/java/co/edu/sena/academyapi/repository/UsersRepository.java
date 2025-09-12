/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.sena.academyapi.repository;

import co.edu.sena.academyapi.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author sena
 */
@Repository
public interface UsersRepository extends JpaRepository<Users, Integer>{
    @Query("SELECT u FROM Users u WHERE u.email = :email AND u.password = :password")
    Users login(@Param("email") String email, @Param("password") String password);
}
