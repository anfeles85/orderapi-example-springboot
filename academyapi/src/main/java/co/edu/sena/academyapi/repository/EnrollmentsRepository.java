/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.sena.academyapi.repository;

import co.edu.sena.academyapi.model.Enrollments;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author sena
 */
@Repository
public interface EnrollmentsRepository extends JpaRepository<Enrollments, Integer>{
    //consulta los cursos matriculados de un estudiante especifico
    @Query("SELECT e FROM Enrollments e WHERE e.studentId.id = :studentId")
    List<Enrollments> findByStudendId(@Param("studentId") Integer studentId);
    
    //consultar los estudiantes matriculados de un curso especifico
    @Query("SELECT e FROM Enrollments e WHERE e.courseId.id = :courseId")
    List<Enrollments> findByCourseId(@Param("courseId") Integer courseId);
}
